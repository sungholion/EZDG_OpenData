"use client";

import * as React from "react";
import { NavData } from "@/components/sidebar/nav-data";
import { NavGuide } from "@/components/sidebar/nav-menu";
import { Sidebar, SidebarContent, SidebarFooter, SidebarHeader } from "@/components/ui/sidebar";
import { generateNavigationFromCategories } from "@/lib/navigation";
import { DATA_CATEGORIES } from "@/config/sidebar-datas";
import { NAV_MENU } from "@/config/sidebar-guide";
import { Separator } from "../ui/separator";
import { SearchProvider } from "../algolia-search/search-provider";

export function AppSidebar({ ...props }: React.ComponentProps<typeof Sidebar>) {
  const navData = React.useMemo(() => generateNavigationFromCategories(DATA_CATEGORIES), []);

  return (
    <Sidebar collapsible="icon" {...props}>
      <SidebarHeader />
      <SearchProvider />
      <SidebarContent>
        <NavData items={navData} />
        <Separator />
        <NavGuide projects={NAV_MENU} />
      </SidebarContent>
      <SidebarFooter />
    </Sidebar>
  );
}
