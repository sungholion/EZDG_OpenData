interface ImageProps {
  id: string;
}

export interface DataDisplayitem {
  id: string;
  type: 'api' | 'file';
  mainTitle?: string;
  mainDescription?: string;
  originalFileName?: string;
}