// types/guide.ts

// 공통 필드를 위한 기본 인터페이스
interface BaseGuideData {
  _id: string;
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
  required: string | null;
  sampleData: string | null;
}

interface ResponseField {
  type: string;
  name: string;
  description: string;
  required: boolean | null;
  sampleData: string | null;
}

// API의 세부 엔드포인트 정보
interface ApiEndpointDetail {
  title: string;
  description: string;
  packageName: string;
  className: string;
  baseUrl: string;
  endpoint: string;
  requestFields: RequestField[];
  responseFields: ResponseField[];
}

// API 메뉴 아이템의 간단한 엔드포인트 정보
interface ApiEndpointSummary {
  title: string;
  className: string;
}

// API 타입 데이터 (상세 정보)
export interface ApiGuideData extends BaseGuideData {
  type: 'api';
  mainTitle: string;
  mainDescription: string;
  api: ApiEndpointDetail;  // 상세 정보에서는 전체 엔드포인트 정보
}

// 파일 필드 정의
interface FileField {
  type: string;
  translatedName: string;
  originalName: string;
}

// methodList의 메서드 정보를 위한 필드 정의
interface FileMethod {
  method: string;
  description: string;
  returnType: string;
}

// 파일 타입 데이터
export interface FileGuideData extends BaseGuideData {
  type: 'file';
  originalFileName: string;
  translatedFileName: string;
  fields: FileField[];
  methodList: FileMethod[];
}

// 통합 타입 (상세 정보)
export type GuideData = ApiGuideData | FileGuideData;

// API 메뉴 아이템 응답 (목록 조회시)
interface BaseGuideMenuItem {
  _id: string;
  createdAt: string;
  updatedAt: string;
  type: 'api' | 'file';
  deployed: boolean;
}

// API 타입의 메뉴 아이템
interface ApiGuideMenuItem extends BaseGuideMenuItem {
  type: 'api';
  mainTitle: string;
  mainDescription: string;
  apiList: ApiEndpointSummary[];  // 메뉴 목록에서는 간단한 엔드포인트 정보만
}

// File 타입의 메뉴 아이템
interface FileGuideMenuItem extends BaseGuideMenuItem {
  type: 'file';
  originalFileName: string;
  translatedFileName: string;
}

// 메뉴 아이템 통합 타입
export type GuideMenuItem = ApiGuideMenuItem | FileGuideMenuItem;

// 타입 가드
export function isApiGuideItem(item: GuideMenuItem): item is ApiGuideMenuItem {
  return item.type === 'api';
}

export function isFileGuideItem(item: GuideMenuItem): item is FileGuideMenuItem {
  return item.type === 'file';
}

export function isApiGuide(data: GuideData): data is ApiGuideData {
  return data.type === 'api';
}

export function isFileGuide(data: GuideData): data is FileGuideData {
  return data.type === 'file';
}