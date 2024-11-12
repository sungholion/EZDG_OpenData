// lib/algolia.ts
import algoliasearch from 'algoliasearch/lite';

// 환경 변수 체크
if (!process.env.NEXT_PUBLIC_ALGOLIA_APP_ID) {
  throw new Error('Missing Algolia App ID');
}

if (!process.env.NEXT_PUBLIC_ALGOLIA_SEARCH_API_KEY) {
  throw new Error('Missing Algolia Search API Key');
}

if (!process.env.NEXT_PUBLIC_ALGOLIA_INDEX_NAME) {
  throw new Error('Missing Algolia Index Name');
}

export const searchClient = algoliasearch(
  process.env.NEXT_PUBLIC_ALGOLIA_APP_ID,
  process.env.NEXT_PUBLIC_ALGOLIA_SEARCH_API_KEY
);

export const ALGOLIA_INDEX = process.env.NEXT_PUBLIC_ALGOLIA_INDEX_NAME;