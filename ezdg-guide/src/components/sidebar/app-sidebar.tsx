"use client";

import * as React from "react";
import { NavData } from "@/components/sidebar/nav-data";
import { NavGuide } from "@/components/sidebar/nav-guide";
import { Sidebar, SidebarContent, SidebarFooter, SidebarHeader } from "@/components/ui/sidebar";
import { NAV_MENU } from "@/config/sidebar-guide";
import { Separator } from "../ui/separator";
import { SearchCommand } from "../algolia-search/search-modal";
import { guideAPI } from "@/app/api/guide";
import type { GuideMenuItem } from "@/types/guide";
import { Skeleton } from "../ui/skeleton";

function SidebarSkeleton() {
  return (
    <div className="space-y-4 p-4">
      <Skeleton className="h-5 w-32" />
      <div className="space-y-2">
        {[...Array(3)].map((_, i) => (
          <Skeleton key={i} className="h-8 w-full" />
        ))}
      </div>
    </div>
  );
}

export function AppSidebar({ ...props }: React.ComponentProps<typeof Sidebar>) {
  const [menuItems, setMenuItems] = React.useState<GuideMenuItem[]>([]);
  const [isLoading, setIsLoading] = React.useState(true);
  const [error, setError] = React.useState<string | null>(null);

  React.useEffect(() => {
    const fetchMenuItems = async () => {
      try {
        setIsLoading(true);
        const data = await guideAPI.getGuideMenu();
        setMenuItems(data);
      } catch (error) {
        console.error("Failed to fetch menu items:", error);
        setError("메뉴를 불러오는데 실패했습니다.");
      } finally {
        setIsLoading(false);
      }
    };

    fetchMenuItems();
  }, []);

  return (
    <Sidebar collapsible="icon" {...props}>
      <SidebarHeader />
      <SearchCommand />
      <SidebarContent>
        {isLoading ? (
          <SidebarSkeleton />
        ) : error ? (
          <div className="p-4 text-red-500">{error}</div>
        ) : (
          <NavData items={menuItems} />
        )}
        <Separator />
        <NavGuide projects={NAV_MENU} />
        <Separator />
      </SidebarContent>
      <SidebarFooter />
    </Sidebar>
  );
}
