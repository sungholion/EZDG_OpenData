"use client";

import { useEffect, useState } from "react";
import { InstantSearch, Hits } from "react-instantsearch";
import { Command } from "cmdk";
import { searchClient, ALGOLIA_INDEX } from "@/config/algolia";
import type { BaseHit, Hit } from "instantsearch.js";
import Link from "next/link";
import { useRouter } from "next/navigation";
import { Clock, Search, X } from "lucide-react";
import { useSearchHistory } from "@/hooks/use-searchhistory";

interface SearchResult extends BaseHit {
  objectID: string;
  id: string;
  title: string;
  description: string;
  _highlightResult?: {
    title?: { value: string };
    description?: { value: string };
  };
  [key: string]: unknown; // BaseHit 요구사항을 만족시키기 위한 인덱스 시그니처
}

interface HitComponentProps {
  hit: Hit<SearchResult>;
  onClose: () => void;
}

function HitComponent({ hit, onClose }: HitComponentProps) {
  const router = useRouter();

  const handleClick = (e: React.MouseEvent) => {
    e.preventDefault();
    onClose(); // 먼저 모달을 닫고
    router.push(`/datas/${hit.objectID}/${hit.id}`); // 그 다음 페이지 이동
  };

  return (
    <Link
      href={`/datas/${hit.objectID}/${hit.id}`}
      onClick={handleClick}
      className="block p-3 rounded-lg hover:bg-gray-100">
      <h3
        className="font-medium"
        dangerouslySetInnerHTML={{
          __html: hit._highlightResult?.title?.value || hit.title,
        }}
      />
      <p
        className="text-sm text-gray-500 mt-1 line-clamp-2"
        dangerouslySetInnerHTML={{
          __html: hit._highlightResult?.description?.value || hit.description,
        }}
      />
    </Link>
  );
}

export function SearchCommand() {
  const [open, setOpen] = useState(false);
  const [query, setQuery] = useState("");
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

  const handleSearch = (searchQuery: string) => {
    setQuery(searchQuery);
    if (searchQuery.trim()) {
      addToHistory(searchQuery.trim());
    }
  };

  return (
    <>
      {/* 검색 트리거 버튼 */}
      <button
        onClick={() => setOpen(true)}
        className="flex items-center w-full px-3 py-2 text-sm text-gray-500 border rounded-md hover:bg-gray-100/50 transition-colors">
        <Search className="w-4 h-4 mr-2" />
        <span className="flex-1 text-left">검색...</span>
        <kbd className="ml-auto text-xs bg-gray-100 px-2 py-0.5 rounded">
          ⌘ <span className="text-base">K</span>
        </kbd>
      </button>

      {/* 검색 모달 */}
      {open && (
        <Command.Dialog open={open} onOpenChange={setOpen} className="fixed inset-0 z-50">
          {/* 백드롭 - 클릭 시 모달 닫힘 */}
          <div className="fixed inset-0 bg-black/50" onClick={onClose} />

          {/* 모달 컨텐츠 */}
          <div className="fixed inset-10 top-[20vh] mx-auto max-w-2xl overflow-hidden rounded-xl bg-white p-0 shadow-2xl">
            <InstantSearch
              searchClient={searchClient}
              indexName={ALGOLIA_INDEX}
              future={{ preserveSharedStateOnUnmount: true }}>
              <div className="p-4">
                <Command.Input
                  value={query}
                  onValueChange={handleSearch}
                  autoFocus
                  placeholder="검색어를 입력하세요..."
                  className="w-full bg-transparent outline-none placeholder:text-gray-400"
                />
              </div>
              <hr className="border-gray-200" />
              <Command.List className="max-h-[60vh] overflow-y-auto p-2">
                {!query && (
                  <>
                    {history.length > 0 ? (
                      <div className="px-3 py-2">
                        <div className="flex items-center justify-between mb-2">
                          <h2 className="text-sm font-medium text-gray-500">최근 검색어</h2>
                          <button onClick={clearHistory} className="text-xs text-gray-500 hover:text-gray-700">
                            전체 삭제
                          </button>
                        </div>
                        {history.map((item) => (
                          <div
                            key={item.timestamp}
                            className="flex items-center justify-between px-3 py-2 rounded-lg hover:bg-gray-100">
                            <button className="flex items-center gap-2 flex-1" onClick={() => handleSearch(item.query)}>
                              <Clock className="w-4 h-4 text-gray-400" />
                              <span>{item.query}</span>
                            </button>
                            <button
                              onClick={(e) => {
                                e.stopPropagation();
                                removeFromHistory(item.query);
                              }}
                              className="p-1 hover:bg-gray-200 rounded">
                              <X className="w-3 h-3 text-gray-500" />
                            </button>
                          </div>
                        ))}
                      </div>
                    ) : (
                      <div className="px-3 py-8 text-center text-gray-500">최근 검색 기록이 없습니다</div>
                    )}
                  </>
                )}
                {query && (
                  <Hits
                    hitComponent={({ hit }: { hit: Hit<SearchResult> }) => <HitComponent hit={hit} onClose={onClose} />}
                  />
                )}
              </Command.List>
            </InstantSearch>
          </div>
        </Command.Dialog>
      )}
    </>
  );
}
