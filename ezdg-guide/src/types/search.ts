import type { BaseHit } from 'instantsearch.js';

export interface SearchResult extends BaseHit {
  _id: string;
  type: 'api' | 'file';
  originalName: string;
  translatedName: string;
  className?: string;  // API 타입일 때만 존재
  _highlightResult?: {
    originalName?: { value: string };
    translatedName?: { value: string };
  };
}

export interface HistoryItem {
  objectID: string;
  title: string;
  description: string;
  type: 'api' | 'file';
  className?: string;
  timestamp: number;
}