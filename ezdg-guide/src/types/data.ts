import { LucideIcon } from "lucide-react";

// sidebar 라우팅 관련 types
// API 엔드포인트 정보
export interface Endpoint {
  id: string;
  title: string;
  path: string;
  description: string;
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