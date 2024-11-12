import type { BaseHit } from 'instantsearch.js';

export interface SearchResult extends BaseHit {
  objectID: string;
  id?: string;
  title: string;
  description: string;
  _highlightResult?: {
    title?: { value: string };
    description?: { value: string };
  };
}
