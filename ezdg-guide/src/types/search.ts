import type { BaseHit } from 'instantsearch.js';

export interface SearchResult extends BaseHit {
  objectID: string;
  originalName: string;   // 원래 title로 사용할 필드
  translatedName: string; // 원래 description으로 사용할 필드
  code: string;
  _highlightResult?: {
    originalName?: { value: string };
    translatedName?: { value: string };
  };
}