import type { DataCategory } from "@/types/data";
import type { NavDataItem } from "@/types/sidebar";

// DataCategory를 NavItem으로 변환하는 유틸리티 함수
export function convertDataCategoryToNavItem(category: DataCategory): NavDataItem {
  return {
    title: category.title,
    url: `/datas/${category.id}`,
    icon: category.icon,
    items: category.endpoints.map(endpoint => ({
      title: endpoint.title,
      url: `/datas/${category.id}${endpoint.path}`
    }))
  };
}

// 전체 데이터 카테고리를 네비게이션 아이템으로 변환
export function generateNavigationFromCategories(categories: DataCategory[]): NavDataItem[] {
  return categories.map(convertDataCategoryToNavItem);
}