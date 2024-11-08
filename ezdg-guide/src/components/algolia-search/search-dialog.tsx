// // components/search/search-dialog.tsx
// "use client";

// import { useRouter } from "next/navigation";
// import { useHits, useSearchBox } from "react-instantsearch";

// import { Search } from "lucide-react";
// import type { PublicDataHit } from "@/lib/algolia";
// import { useEffect } from "react";
// import type { Hit } from "instantsearch.js";
// import { CommandEmpty, CommandGroup, CommandItem, CommandList } from "@/components/ui/command";

// interface SearchDialogProps {
//   query: string;
//   setOpen: (open: boolean) => void;
// }

// export function SearchDialog({ query, setOpen }: SearchDialogProps) {
//   const router = useRouter();
//   const { items, sendEvent } = useHits<PublicDataHit>();
//   const { refine } = useSearchBox();

//   useEffect(() => {
//     refine(query);
//   }, [query, refine]);

//   const handleSelect = (hit: PublicDataHit) => {
//     // hit를 Hit 타입으로 캐스팅
//     sendEvent("click", hit as unknown as Hit, "Item Selected");
//     setOpen(false);
//     router.push(`/datas/${hit.id}`);
//   };

//   return (
//     <CommandList>
//       <CommandEmpty>검색 결과가 없습니다.</CommandEmpty>
//       <CommandGroup heading={`검색 결과${items.length > 0 ? ` (${items.length})` : ""}`}>
//         {items.map((hit) => (
//           <CommandItem
//             key={hit.objectID}
//             onSelect={() => handleSelect(hit)}
//             className="flex flex-col gap-2"
//             onMouseMove={() => sendEvent("hover", hit, "Item Hovered")}>
//             <div className="flex items-center">
//               <Search className="mr-2 h-4 w-4" />
//               <span className="font-medium">{hit.title}</span>
//             </div>
//             <p className="text-sm text-muted-foreground ml-6">{hit.description}</p>
//             <div className="flex gap-2 ml-6">
//               <span className="text-xs bg-slate-100 px-2 py-1 rounded">{hit.provider}</span>
//               <span className="text-xs bg-slate-100 px-2 py-1 rounded">{hit.category}</span>
//               {/* <span className="text-xs bg-slate-100 px-2 py-1 rounded">조회수: {hit.views.toLocaleString()}</span> */}
//             </div>
//           </CommandItem>
//         ))}
//       </CommandGroup>
//     </CommandList>
//   );
// }
