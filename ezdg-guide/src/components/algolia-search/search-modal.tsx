import { useEffect, useState } from "react";
import { InstantSearch, useConfigure, Hits, useHits } from "react-instantsearch";
import type { UseConfigureProps } from "react-instantsearch";
import { Command } from "cmdk";
import { searchClient, ALGOLIA_INDEX } from "@/config/algolia";
import type { Hit } from "instantsearch.js";
import Link from "next/link";
import { useRouter } from "next/navigation";
import { Clock, Search, X } from "lucide-react";
import { useSearchHistory, HistoryItem } from "@/hooks/use-searchhistory";
import type { SearchResult } from "@/types/search";

// 검색을 가능하게 하는 useConfigure Props
function SearchResults({
  query,
  onClose,
  onItemClick,
}: {
  query: string;
  onClose: () => void;
  onItemClick: (item: Omit<HistoryItem, "timestamp">) => void;
}) {
  const { hits } = useHits<SearchResult>();
  useConfigure({
    hitsPerPage: 5,
    distinct: true,
    query,
    attributesToRetrieve: ["objectID", "originalName", "translatedName", "code"],
    attributesToHighlight: ["originalName", "translatedName"],
  } as UseConfigureProps);

  if (query && hits.length === 0) {
    return <div className="p-8 text-center text-gray-500">검색어와 일치하는 데이터가 없습니다</div>;
  }

  return (
    <Hits
      hitComponent={({ hit }: { hit: Hit<SearchResult> }) => (
        <HitComponent hit={hit} onClose={onClose} onItemClick={onItemClick} />
      )}
    />
  );
}

interface HitComponentProps {
  hit: Hit<SearchResult>;
  onClose: () => void;
  onItemClick: (item: Omit<HistoryItem, "timestamp">) => void;
}

function getRouteFormHit(hit: SearchResult): string {
  if (hit.id) {
    return `/datas/${hit.originalName}/${hit.translatedName}`;
  }
  return `/datas/${hit.originalName}`;
}

function HitComponent({ hit, onClose, onItemClick }: HitComponentProps) {
  const router = useRouter();

  const handleClick = (e: React.MouseEvent) => {
    e.preventDefault();
    onItemClick({
      objectID: hit.objectID,
      id: hit.code,
      title: hit.originalName,
      description: hit.translatedName,
    });
    onClose();
    router.push(getRouteFormHit(hit));
  };

  return (
    <Link href={getRouteFormHit(hit)} onClick={handleClick} className="block p-3 rounded-lg hover:bg-gray-100">
      <h3
        className="font-medium"
        dangerouslySetInnerHTML={{
          __html: hit._highlightResult?.originalName?.value || hit.originalName,
        }}
      />
      <p
        className="text-sm text-gray-500 mt-1 line-clamp-2"
        dangerouslySetInnerHTML={{
          __html: hit._highlightResult?.translatedName?.value || hit.translatedName,
        }}
      />
    </Link>
  );
}

interface HistoryListProps {
  items: HistoryItem[];
  onItemClick: (item: HistoryItem) => void;
  onItemRemove: (objectID: string) => void;
  onClear: () => void;
}

function HistoryList({ items, onItemClick, onItemRemove, onClear }: HistoryListProps) {
  if (items.length === 0) {
    return <div className="px-3 py-8 text-center text-gray-500">최근 조회 기록이 없습니다</div>;
  }

  return (
    <div className="px-3 py-2">
      <div className="flex items-center justify-between mb-2">
        <h2 className="text-sm font-medium text-gray-500">최근 조회 항목</h2>
        <button onClick={onClear} className="text-xs text-gray-500 hover:text-gray-700">
          전체 삭제
        </button>
      </div>
      {items.map((item) => (
        <div key={item.objectID} className="flex items-center justify-between py-2 rounded-lg hover:bg-gray-100">
          <button className="flex items-start gap-2 flex-1 text-left" onClick={() => onItemClick(item)}>
            <Clock className="w-4 h-4 mt-1 text-gray-400 flex-shrink-0" />
            <div>
              <div className="font-medium">{String(item.title)}</div>
              <div className="text-sm text-gray-500 line-clamp-1">{String(item.description)}</div>
            </div>
          </button>
          <button
            onClick={(e) => {
              e.stopPropagation();
              onItemRemove(item.objectID);
            }}
            className="p-1 hover:bg-gray-200 rounded ml-2">
            <X className="w-3 h-3 text-gray-500" />
          </button>
        </div>
      ))}
    </div>
  );
}

export function SearchCommand() {
  const [open, setOpen] = useState(false);
  const [query, setQuery] = useState("");
  const router = useRouter();
  const { history, addToHistory, removeFromHistory, clearHistory } = useSearchHistory();

  useEffect(() => {
    const down = (e: KeyboardEvent) => {
      if (e.key === "k" && (e.metaKey || e.ctrlKey)) {
        e.preventDefault();
        setOpen((prev) => !prev);
      }
    };

    document.addEventListener("keydown", down);
    return () => document.removeEventListener("keydown", down);
  }, []);

  const onClose = () => {
    setOpen(false);
    setQuery("");
  };

  const handleHistoryItemClick = (item: HistoryItem) => {
    router.push(`/datas/${item.objectID}/${item.id}`);
    onClose();
  };

  return (
    <>
      <button
        onClick={() => setOpen(true)}
        className="flex items-center w-full px-3 py-2 text-sm text-gray-500 border rounded-md hover:bg-gray-100/50 transition-colors">
        <Search className="w-4 h-4 mr-2" />
        <span className="flex-1 text-left">검색...</span>
        <kbd className="ml-auto text-xs bg-gray-100 px-2 py-0.5 rounded">
          ⌘ <span className="text-base">K</span>
        </kbd>
      </button>

      {open && (
        <Command.Dialog open={open} onOpenChange={setOpen} className="fixed inset-0 z-50">
          <div className="fixed inset-0 bg-black/50" onClick={onClose} />
          <div className="fixed inset-10 top-[20vh] mx-auto max-w-2xl overflow-hidden rounded-xl bg-white p-0 shadow-2xl">
            <InstantSearch
              searchClient={searchClient}
              indexName={ALGOLIA_INDEX}
              future={{ preserveSharedStateOnUnmount: true }}>
              <div className="flex p-4">
                <Search className="mr-3" />
                <Command.Input
                  value={query}
                  onValueChange={setQuery}
                  autoFocus
                  placeholder="검색어를 입력하세요..."
                  className="w-full bg-transparent outline-none placeholder:text-gray-400"
                />
                <span
                  className="outline outline-offset-4 rounded-lg content-center text-xs outline-gray-200 cursor-pointer"
                  onClick={onClose}>
                  ESC
                </span>
              </div>
              <hr className="border-gray-200" />
              <Command.List className="max-h-[60vh] overflow-y-auto p-2">
                {!query ? (
                  <HistoryList
                    items={history}
                    onItemClick={handleHistoryItemClick}
                    onItemRemove={removeFromHistory}
                    onClear={clearHistory}
                  />
                ) : (
                  <SearchResults query={query} onClose={onClose} onItemClick={addToHistory} />
                )}
              </Command.List>
            </InstantSearch>
          </div>
        </Command.Dialog>
      )}
    </>
  );
}
