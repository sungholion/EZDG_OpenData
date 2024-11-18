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
import { useState } from "react";

interface GuideMenuProps {
  items: GuideMenuItem[];
}

export function NavData({ items }: GuideMenuProps) {
  const [openStates, setOpenStates] = useState<Record<string, boolean>>({});

  const toggleOpen = (itemId: string) => {
    setOpenStates((prev) => ({
      ...prev,
      [itemId]: !prev[itemId],
    }));
  };

  return (
    <SidebarGroup>
      <SidebarGroupLabel>Data</SidebarGroupLabel>
      <SidebarMenu>
        {items.map((item) => (
          <SidebarMenuItem key={item._id}>
            {isApiGuideItem(item) ? (
              <Collapsible
                asChild
                className="group/collapsible"
                open={openStates[item._id]}
                onOpenChange={() => toggleOpen(item._id)}>
                <>
                  <CollapsibleTrigger asChild>
                    <SidebarMenuButton
                      tooltip={openStates[item._id] ? undefined : item.mainTitle}
                      className={openStates[item._id] ? "pb-2" : ""}>
                      <div className="flex items-center w-full">
                        <span
                          className={`${openStates[item._id] ? "whitespace-normal leading-snug py-0.5" : "truncate"}`}>
                          {formatFieldName(item.mainTitle)}
                        </span>
                        <ChevronRight
                          className={`ml-auto flex-shrink-0 transition-transform duration-200 ${
                            openStates[item._id] ? "rotate-90" : ""
                          }`}
                        />
                      </div>
                    </SidebarMenuButton>
                  </CollapsibleTrigger>
                  <CollapsibleContent>
                    <SidebarMenuSub className="pt-1">
                      {item.apiList.map((api) => (
                        <SidebarMenuSubItem key={api.className}>
                          <SidebarMenuSubButton asChild>
                            <Link
                              href={`/datas/${item._id}/${api.className}`}
                              onClick={(e) => e.stopPropagation()}
                              className="w-full">
                              <span
                                className={`block ${
                                  openStates[item._id] ? "whitespace-normal leading-snug py-0.5" : "truncate"
                                }`}
                                title={openStates[item._id] ? undefined : api.title}>
                                {api.title}
                              </span>
                            </Link>
                          </SidebarMenuSubButton>
                        </SidebarMenuSubItem>
                      ))}
                    </SidebarMenuSub>
                  </CollapsibleContent>
                </>
              </Collapsible>
            ) : (
              <Link href={`/datas/${item._id}`} onClick={(e) => e.stopPropagation()} className="block w-full">
                <SidebarMenuButton tooltip={item.originalFileName}>
                  <span className="truncate">{formatFieldName(item.originalFileName)}</span>
                </SidebarMenuButton>
              </Link>
            )}
          </SidebarMenuItem>
        ))}
      </SidebarMenu>
    </SidebarGroup>
  );
}
