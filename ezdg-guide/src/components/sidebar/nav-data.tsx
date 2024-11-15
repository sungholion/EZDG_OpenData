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
import { GuideMenuItem, isApiGuideItem } from "@/types/guide";
import { formatFieldName } from "@/lib/format";

interface GuideMenuProps {
  items: GuideMenuItem[];
}

export function NavData({ items }: GuideMenuProps) {
  return (
    <SidebarGroup>
      <SidebarGroupLabel>Data</SidebarGroupLabel>
      <SidebarMenu>
        {items.map((item) => (
          <SidebarMenuItem key={item._id}>
            {isApiGuideItem(item) ? (
              // API 타입일 경우 Collapsible로 apiList 표시
              <Collapsible asChild className="group/collapsible">
                <>
                  <CollapsibleTrigger asChild>
                    <SidebarMenuButton tooltip={item.mainTitle}>
                      <span>{formatFieldName(item.mainTitle)}</span>
                      <ChevronRight className="ml-auto transition-transform duration-200 group-data-[state=open]/collapsible:rotate-90" />
                    </SidebarMenuButton>
                  </CollapsibleTrigger>
                  <CollapsibleContent>
                    <SidebarMenuSub>
                      {item.apiList.map((api) => (
                        <SidebarMenuSubItem key={api.className}>
                          <SidebarMenuSubButton asChild>
                            <Link href={`/datas/${item._id}/${api.className}`} onClick={(e) => e.stopPropagation()}>
                              <span>{api.title}</span>
                            </Link>
                          </SidebarMenuSubButton>
                        </SidebarMenuSubItem>
                      ))}
                    </SidebarMenuSub>
                  </CollapsibleContent>
                </>
              </Collapsible>
            ) : (
              // File 타입일 경우 단일 링크
              <Link href={`/datas/${item._id}`} onClick={(e) => e.stopPropagation()} className="block">
                <SidebarMenuButton tooltip={item.originalFileName}>
                  <span>{formatFieldName(item.originalFileName)}</span>
                </SidebarMenuButton>
              </Link>
            )}
          </SidebarMenuItem>
        ))}
      </SidebarMenu>
    </SidebarGroup>
  );
}
