import { LucideIcon } from "lucide-react";

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

  // API 관련 필드들
  apiVersion?: string;
  endpoints?: Array<{
    id: string;
    title: string;
    path: string;
    description: string;
    apiSpec?: ApiSpec;
  }>;

  //Java 라이브러리 관련 필드들
  inputSpec?: Array<{
    name: string;
    type: string;
    description: string;
    constraints?: string;
  }>;
  outputSpec?: Array<{
    name: string;
    type: string;
    description: string;
  }>;
  examples?: Array<{
    title: string;
    description?: string;
    code: string;
    result?: string;  // 실행 결과 (선택사항)
  }>;
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