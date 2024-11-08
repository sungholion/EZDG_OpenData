// 현재 안쓰는 중
"use client";

import { InstantSearchNext } from "react-instantsearch-nextjs";
import { searchClient } from "@/lib/algolia";
import { InstantSearch } from "react-instantsearch";
import { PropsWithChildren } from "react";

export function SearchProvider({ children }: PropsWithChildren) {
  return (
    <InstantSearchNext
      searchClient={searchClient}
      indexName={process.env.NEXT_PUBLIC_ALGOLIA_INDEX_NAME ?? "public_data"}
      future={{
        preserveSharedStateOnUnmount: true,
      }}
      insights={true}
      initialUiState={{
        [process.env.NEXT_PUBLIC_ALGOLIA_INDEX_NAME ?? "public_data"]: {
          query: "",
        },
      }}>
      {children}
    </InstantSearchNext>
  );
}
