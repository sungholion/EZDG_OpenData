// lib/algolia.ts
import { liteClient as algoliasearch } from "algoliasearch/lite";
import type { Hit } from "instantsearch.js";

export interface PublicDataHit extends Hit {
  id: string;
  title: string;
  description: string;
  category: string;
  provider: string;
  updateCycle: string;
  tags: string[];
  views: number;
  downloads: number;
  lastUpdate: string;
  format: string[];
  keywords: string[];
}

const appId = process.env.NEXT_PUBLIC_ALGOLIA_APP_ID ?? "";
const apiKey = process.env.NEXT_PUBLIC_ALGOLIA_SEARCH_API_KEY ?? "";

export const searchClient = algoliasearch(appId, apiKey);