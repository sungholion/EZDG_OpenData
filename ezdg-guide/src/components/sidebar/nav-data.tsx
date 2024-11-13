"use client";

import { ChevronRight } from "lucide-react";
import Link from "next/link";

import { Collapsible, CollapsibleContent, CollapsibleTrigger } from "@/components/ui/collapsible";
import {
  SidebarGroup,
  SidebarGroupLabel,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
  SidebarMenuSub,
  SidebarMenuSubButton,
  SidebarMenuSubItem,
} from "@/components/ui/sidebar";
import type { NavDataItem } from "@/types/sidebar";

interface NavDataProps {
  items: NavDataItem[];
}

export function NavData({ items }: NavDataProps) {
  // API와 File 항목 분리
  const apiItems = items.filter((item) => item.type === "api");
  const fileItems = items.filter((item) => item.type === "file");

  return (
    <SidebarGroup>
      <SidebarGroupLabel>Data</SidebarGroupLabel>
      <SidebarMenu>
        {/* API 아이템 렌더링 */}
        {apiItems.map((item) => (
          <SidebarMenuItem key={item.title}>
            <Collapsible asChild defaultOpen={item.isActive} className="group/collapsible">
              <>
                <CollapsibleTrigger asChild>
                  <SidebarMenuButton tooltip={item.title}>
                    {item.icon && <item.icon />}
                    <span>{item.title}</span>
                    <ChevronRight className="ml-auto transition-transform duration-200 group-data-[state=open]/collapsible:rotate-90" />
                  </SidebarMenuButton>
                </CollapsibleTrigger>
                <CollapsibleContent>
                  <SidebarMenuSub>
                    {item.items?.map((subItem) => (
                      <SidebarMenuSubItem key={subItem.title}>
                        <SidebarMenuSubButton asChild>
                          <Link
                            href={subItem.url}
                            onClick={(e) => {
                              e.stopPropagation();
                            }}>
                            <span>{subItem.title}</span>
                          </Link>
                        </SidebarMenuSubButton>
                      </SidebarMenuSubItem>
                    ))}
                  </SidebarMenuSub>
                </CollapsibleContent>
              </>
            </Collapsible>
          </SidebarMenuItem>
        ))}

        {/* File 아이템 렌더링 */}
        {fileItems.map((item) => (
          <SidebarMenuItem key={item.title}>
            <Link
              href={item.url || "#"}
              onClick={(e) => {
                e.stopPropagation();
              }}
              className="block">
              <SidebarMenuButton tooltip={item.title}>
                {item.icon && <item.icon />}
                <span>{item.title}</span>
              </SidebarMenuButton>
            </Link>
          </SidebarMenuItem>
        ))}
      </SidebarMenu>
    </SidebarGroup>
  );
}
