// // lib/navigation.ts
// import { TramFront, FileText } from "lucide-react";
// import { isApiGuideItem } from "@/types/guide";
// import type { GuideMenuItem } from "@/types/guide";
// import type { NavDataItem } from "@/types/sidebar";

// export function generateNavigationFromGuide(menuItems: GuideMenuItem[]): NavDataItem[] {
//   // API 아이템 그룹화
//   const apiItems = menuItems.filter(isApiGuideItem);
  
//   const navItems: NavDataItem[] = [];

//   // API 그룹이 있는 경우
//   if (apiItems.length > 0) {
//     navItems.push({
//       title: "API Guides",
//       icon: TramFront,
//       type: 'api',
//       isActive: true,
//       items: apiItems.map(item => ({
//         title: item.originalName,
//         url: `/guide/detail?id=${item._id}`,
//       })),
//       deployed: apiItems.every(item => item.deployed)
//     });
//   }

//   // File 아이템들 추가
//   const fileItems = menuItems
//     .filter(item => item.type === 'file')
//     .map(item => ({
//       title: item.originalName,
//       icon: FileText,
//       type: 'file' as const,
//       url: `/guide/detail?id=${item._id}`,
//       isActive: false,
//       deployed: item.deployed
//     }));

//   return [...navItems, ...fileItems];
// }