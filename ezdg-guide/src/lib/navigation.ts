import type { DataCategory } from "@/types/data";
import type { NavDataItem } from "@/types/sidebar";

// DataCategory를 NavItem으로 변환하는 유틸리티 함수
export function convertDataCategoryToNavItem(category: DataCategory): NavDataItem {
  // 기본 NavDataItem 구조
  const navItem: NavDataItem = {
    title: category.title,
    url: `/datas/${category.id}`,
    icon: category.icon,
    items: []
  };

  // endpoints가 있는 경우에만 하위 항목 추가
  if (category.endpoints && category.endpoints.length > 0) {
    navItem.items = category.endpoints.map(endpoint => ({
      title: endpoint.title,
      url: `/datas/${category.id}/${endpoint.path.replace("/", "")}`
    }));
  }

  return navItem;
}

// 전체 데이터 카테고리를 네비게이션 아이템으로 변환
export function generateNavigationFromCategories(categories: DataCategory[]): NavDataItem[] {
  return categories.map(convertDataCategoryToNavItem);
}