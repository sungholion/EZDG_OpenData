import { LucideIcon } from "lucide-react";

// sidebar 데이터 및 통신 관련 types (TODO: 실제 통신에 맞게 수정 필요)
// API 엔드포인트 정보
export interface Endpoint {
  id: string;
  title: string;
  path: string;
  description: string;
  apiSpec?: ApiSpec;
}

type ParameterType = 'string' | 'number' | 'boolean';

interface ApiParameter {
  name: string;
  type: ParameterType;
  required: boolean;
  description: string;
  example?: string | number | boolean;
}

interface ApiResponse {
  description: string;
  example: Record<string, unknown>;
}

export interface ApiSpec {
  parameters?: {
    query?: ApiParameter[];
  };
  response: ApiResponse;
}

// 데이터 카테고리 정보
export interface DataCategory {
  id: string;
  title: string;
  description: string;
  icon: LucideIcon;
  apiVersion: string;
  endpoints: Endpoint[];
}

// ------------------------------------------------------------

// 메인페이지 사용 가능 데이터 종류 관련 types
// 이미지 데이터
export interface ImageData {
  src: string;
  alt: string;
}

// 메인 페이지 데이터 아이템
export interface DataItem {
  title: string;
  badge: string;
  description: string;
  content: string;
  image: ImageData;
}