import { LucideIcon } from "lucide-react";

// 사이드바 서브메뉴 아이템
export interface NavSubDataItem {
  title: string;
  url: string;
}

// 사이드바 데이터 메뉴 아이템
export interface NavDataItem {
  title: string;
  url?: string;
  icon?: LucideIcon;
  type: 'api' | 'file';
  isActive?: boolean;
  items?: NavSubDataItem[];
  deployed?: boolean;
}

// 가이드라인 메뉴 아이템
export interface NavGuideItem {
  name: string;
  url?: string;
  icon: LucideIcon;
  isDialog?: boolean;
}