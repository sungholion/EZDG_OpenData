"use client";

import {
  SidebarGroup,
  SidebarGroupLabel,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
} from "@/components/ui/sidebar";
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogDescription,
  DialogTrigger,
} from "@/components/ui/dialog";
import type { NavGuideItem } from "@/types/sidebar";
import { DataRequest } from "../data-request/data-request";

interface NavGuideProps {
  projects: NavGuideItem[];
}

export function NavGuide({ projects }: NavGuideProps) {
  return (
    <SidebarGroup className="group-data-[collapsible=icon]:hidden">
      <SidebarGroupLabel>Guide Line</SidebarGroupLabel>
      <SidebarMenu>
        {projects.map((item) => (
          <SidebarMenuItem key={item.name}>
            {/* 데이터 추가 신청 */}
            {item.isDialog ? (
              <Dialog>
                <DialogTrigger asChild>
                  <SidebarMenuButton>
                    <item.icon className="h-4 w-4" />
                    <span>{item.name}</span>
                  </SidebarMenuButton>
                </DialogTrigger>
                <DialogContent className="sm:max-w-[600px]">
                  <DialogHeader className="mb-4">
                    <DialogTitle className="text-lg font-semibold">데이터 추가 요청</DialogTitle>
                    <DialogDescription className="text-red-500">
                      *(필수) 항목은 반드시 기재하셔야 신청이 가능합니다.
                    </DialogDescription>
                  </DialogHeader>
                  <DataRequest />
                </DialogContent>
              </Dialog>
            ) : (
              // 다른 Guide Line 메뉴
              <SidebarMenuButton asChild>
                <a href={item.url}>
                  <item.icon />
                  <span>{item.name}</span>
                </a>
              </SidebarMenuButton>
            )}
          </SidebarMenuItem>
        ))}
      </SidebarMenu>
    </SidebarGroup>
  );
}
