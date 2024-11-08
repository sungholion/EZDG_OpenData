// components/search/search-dialog.tsx
"use client";

import * as React from "react";
import { useRouter } from "next/navigation";
import { Search } from "lucide-react";
import { useInstantSearch, useSearchBox } from "react-instantsearch";
import { Dialog, DialogContent, DialogTrigger } from "@/components/ui/dialog";
import { Button } from "@/components/ui/button";
import { Command, CommandEmpty, CommandGroup, CommandInput, CommandItem, CommandList } from "@/components/ui/command";
import type { PublicDataHit } from "@/lib/algolia";

export function SearchDialog() {
  const router = useRouter();
  const [open, setOpen] = React.useState(false);
  const { query, refine } = useSearchBox();
  const { results } = useInstantSearch();
  const items = results?.hits as PublicDataHit[];

  const [inputValue, setInputValue] = React.useState(query);

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

  const handleSearch = React.useCallback(
    (value: string) => {
      setInputValue(value);
      refine(value);
    },
    [refine]
  );

  return (
    <Dialog open={open} onOpenChange={setOpen}>
      <DialogTrigger asChild>
        <Button
          variant="outline"
          className="relative h-9 w-full justify-start text-sm text-muted-foreground sm:pr-12 md:w-40 lg:w-64">
          <Search className="mr-2 h-4 w-4" />
          <span>데이터 검색...</span>
          <kbd className="pointer-events-none absolute right-1.5 top-1.5 hidden h-6 select-none items-center gap-1 rounded border bg-muted px-1.5 font-mono text-[10px] font-medium opacity-100 sm:flex">
            <span className="text-xs">⌘</span>K
          </kbd>
        </Button>
      </DialogTrigger>
      <DialogContent className="overflow-hidden p-0">
        <Command className="[&_[cmdk-group-heading]]:px-2 [&_[cmdk-group-heading]]:font-medium [&_[cmdk-group-heading]]:text-muted-foreground [&_[cmdk-group]:not([hidden])_~[cmdk-group]]:pt-0 [&_[cmdk-group]]:px-2 [&_[cmdk-input-wrapper]_svg]:h-5 [&_[cmdk-input-wrapper]_svg]:w-5 [&_[cmdk-input]]:h-12 [&_[cmdk-item]]:px-2 [&_[cmdk-item]]:py-3 [&_[cmdk-item]_svg]:h-5 [&_[cmdk-item]_svg]:w-5">
          <CommandInput placeholder="데이터 검색..." value={inputValue} onValueChange={handleSearch} className="h-12" />
          <CommandList>
            <CommandEmpty>검색 결과가 없습니다.</CommandEmpty>
            <CommandGroup heading={`검색 결과 (${items?.length ?? 0})`}>
              {items?.map((hit) => (
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
                    <p className="text-sm text-muted-foreground ml-6">{hit.description}</p>
                    <div className="flex gap-2 ml-6">
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
