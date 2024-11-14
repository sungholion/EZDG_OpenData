// interface ImageProps {
//   id: string;
// }

export interface DataDisplayitem {
  id: string;
  type: 'api' | 'file';
  title: string;
  description?: string;
  deployed?: boolean;
}