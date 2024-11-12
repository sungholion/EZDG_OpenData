export type GuideType = 'file' | 'api'

export interface GuideItem {
  _id: string;
  code: number;
  type: GuideType;
  createdAt: string;
  updatedAt: string;
  deployed: boolean;
  originalName: string;
  translatedName: string;
}

export type GuideResponse = GuideItem[];