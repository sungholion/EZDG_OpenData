// components/search/search-dialog.tsx
"use client";

import * as React from "react";
import { useRouter } from "next/navigation";
import { Search } from "lucide-react";
import { useInstantSearch } from "react-instantsearch";
import { PublicDataHit } from "@/lib/algolia";

import { Dialog, DialogContent } from "@/components/ui/dialog";
import { Command, CommandEmpty, CommandGroup, CommandInput, CommandItem, CommandList } from "@/components/ui/command";

export function SearchDialog() {
  const router = useRouter();
  const [open, setOpen] = React.useState(false);

  // useInstantSearch 훅으로부터 results 직접 접근
  const { results } = useInstantSearch();

  // 검색 결과를 타입 안전하게 가져오기
  const hits = React.useMemo(() => {
    return (results?.hits ?? []) as PublicDataHit[];
  }, [results?.hits]);

  React.useEffect(() => {
    const down = (e: KeyboardEvent) => {
      if (e.key === "k" && (e.metaKey || e.ctrlKey)) {
        e.preventDefault();
        setOpen((open) => !open);
      }
    };

    document.addEventListener("keydown", down);
    return () => document.removeEventListener("keydown", down);
  }, []);

  return (
    <Dialog open={open} onOpenChange={setOpen}>
      <DialogContent className="overflow-hidden p-0 shadow-lg">
        <Command className="[&_[cmdk-group-heading]]:px-2 [&_[cmdk-group-heading]]:font-medium [&_[cmdk-group-heading]]:text-muted-foreground [&_[cmdk-group]:not([hidden])_~[cmdk-group]]:pt-0 [&_[cmdk-group]]:px-2 [&_[cmdk-input-wrapper]_svg]:h-5 [&_[cmdk-input-wrapper]_svg]:w-5 [&_[cmdk-input]]:h-12 [&_[cmdk-item]]:px-2 [&_[cmdk-item]]:py-3 [&_[cmdk-item]_svg]:h-5 [&_[cmdk-item]_svg]:w-5">
          <CommandInput placeholder="데이터 검색..." className="h-12" />
          <CommandList>
            <CommandEmpty>검색 결과가 없습니다.</CommandEmpty>
            <CommandGroup heading="검색 결과">
              {hits.map((hit: PublicDataHit) => (
                <CommandItem
                  key={hit.objectID}
                  onSelect={() => {
                    setOpen(false);
                    router.push(`/data/${hit.id}`);
                  }}>
                  <div className="flex flex-col gap-2">
                    <div className="flex items-center">
                      <Search className="mr-2 h-4 w-4" />
                      <span className="font-medium">{hit.title}</span>
                    </div>
                    <p className="text-sm text-muted-foreground">{hit.description}</p>
                    <div className="flex gap-2">
                      <span className="text-xs bg-slate-100 px-2 py-1 rounded">{hit.provider}</span>
                      <span className="text-xs bg-slate-100 px-2 py-1 rounded">{hit.category}</span>
                      <span className="text-xs bg-slate-100 px-2 py-1 rounded">
                        조회수: {hit.views.toLocaleString()}
                      </span>
                    </div>
                  </div>
                </CommandItem>
              ))}
            </CommandGroup>
          </CommandList>
        </Command>
      </DialogContent>
    </Dialog>
  );
}
