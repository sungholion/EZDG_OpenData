// types/guide.ts
// 공통 필드를 위한 기본 인터페이스
interface BaseGuideData {
  createdAt: string;
  updatedAt: string;
  type: 'api' | 'file';
  deployed: boolean;
}

// API 문서를 위한 타입들
interface RequestField {
  type: string;
  name: string;
  description: string;
  required: boolean | null;
  sampleData: string | null;
}

interface ResponseField {
  type: string;
  name: string;
  description: string;
  required?: boolean | null;
  sampleData?: string | null;
}

interface ApiEndpoint {
  title: string;
  description: string;
  packageName: string;
  className: string;
  baseUrl: string;
  endpoint: string;
  requestFields: RequestField[];
  responseFields: ResponseField[];
}

// API 타입 데이터
export interface ApiGuideData extends BaseGuideData {
  type: 'api';
  mainTitle: string;
  mainDescription: string;
  apiList: ApiEndpoint[];
}

// 파일 필드 정의
interface FileField {
  type: string;
  translatedName: string;
  originalName: string;
}

// 파일 타입 데이터
export interface FileGuideData extends BaseGuideData {
  type: 'file';
  originalFileName: string;
  translatedFileName: string;
  fields: FileField[];
}

// 통합 타입
export type GuideData = ApiGuideData | FileGuideData; 

// API 응답을 위한 타입
export interface GuideMenuItem {
  _id: string;
  code: number;
  type: 'api' | 'file';
  createdAt: string;
  updatedAt: string;
  deployed: boolean;
  originalName: string;
  translatedName: string;
}

// 타입 가드
export function isApiGuideItem(item: GuideMenuItem): item is GuideMenuItem & { type: 'api' } {
  return item.type === 'api';
}

export function isFileGuideItem(item: GuideMenuItem): item is GuideMenuItem & { type: 'file' } {
  return item.type === 'file';
}