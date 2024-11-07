// components/search/search-provider.tsx
"use client";

import { InstantSearch } from "react-instantsearch";
import { searchClient } from "@/lib/algolia";
import { SearchDialog } from "./search-command";

export function SearchProvider() {
  return (
    <InstantSearch searchClient={searchClient} indexName={process.env.NEXT_PUBLIC_ALGOLIA_INDEX_NAME ?? "public_data"}>
      <SearchDialog />
    </InstantSearch>
  );
}
