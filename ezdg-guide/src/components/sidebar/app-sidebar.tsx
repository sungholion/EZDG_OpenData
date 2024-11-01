"use client";

import * as React from "react";
import { BookOpen, Bot, Frame, Map, PieChart, SquareTerminal } from "lucide-react";
import { NavMain } from "@/components/sidebar/nav-data";
import { NavMenu } from "@/components/sidebar/nav-menu";
import { Sidebar, SidebarContent, SidebarFooter, SidebarHeader } from "@/components/ui/sidebar";
import { Input } from "../ui/input";

// 예시 데이터들
const data = {
  navData: [
    {
      title: "한국 관광지 정보",
      url: "#",
      icon: SquareTerminal,
      items: [
        {
          title: "관광정보조회",
          url: "/datas/travel",
        },
      ],
    },
    {
      title: "부동산 실거래가 정보",
      url: "/installation",
      icon: Bot,
    },
    {
      title: "날씨 정보",
      url: "#",
      icon: BookOpen,
      items: [
        {
          title: "공데3-1",
          url: "#",
        },
      ],
    },
  ],
  navMenu: [
    {
      name: "라이브러리 설치",
      url: "/installation",
      icon: Frame,
    },
    {
      name: "FAQ",
      url: "/faq",
      icon: Map,
    },
  ],
};

export function AppSidebar({ ...props }: React.ComponentProps<typeof Sidebar>) {
  return (
    <Sidebar collapsible="icon" {...props}>
      <SidebarHeader />
      {/* TODO: 파일 내에 검색이 가능한 형태로 구현 */}
      <Input></Input>
      <SidebarContent>
        <NavMain items={data.navData} />
        <NavMenu projects={data.navMenu} />
      </SidebarContent>
      <SidebarFooter>{/* Nothing */}</SidebarFooter>
    </Sidebar>
  );
}
