// lib/algolia.ts
import { algoliasearch } from "algoliasearch";
import type { BaseHit } from "instantsearch.js";

// 타입 정의
export interface PublicDataHit extends BaseHit {
  id: string;
  title: string;
  description: string;
  category: string;
  provider: string;
  views: number;
  tags: string[];
  updateCycle: string;
  lastUpdate: string;
}

// 환경 변수 값이 undefined일 경우를 대비한 기본값 처리
const appId = process.env.NEXT_PUBLIC_ALGOLIA_APP_ID ?? "";
const apiKey = process.env.NEXT_PUBLIC_ALGOLIA_SEARCH_API_KEY ?? "";

// searchClient 인스턴스 생성
export const searchClient = algoliasearch(appId, apiKey);