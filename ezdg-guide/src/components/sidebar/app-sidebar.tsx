"use client";

import * as React from "react";
import { BookOpen, Bot, Frame, Map, PieChart, SquareTerminal } from "lucide-react";
import { NavMain } from "@/components/sidebar/nav-data";
import { NavMenu } from "@/components/sidebar/nav-menu";
import { Sidebar, SidebarContent, SidebarFooter, SidebarHeader } from "@/components/ui/sidebar";
import { Input } from "../ui/input";

// This is sample data.
const data = {
  navMain: [
    {
      title: "한국 관광지 정보",
      url: "#",
      icon: SquareTerminal,
      items: [
        {
          title: "공데1-1",
          url: "#",
        },
        {
          title: "공데1-2",
          url: "#",
        },
        {
          title: "공데1-3",
          url: "#",
        },
      ],
    },
    {
      title: "부동산 실거래가 조회",
      url: "#",
      icon: Bot,
      items: [
        {
          title: "공데2-1",
          url: "#",
        },
        {
          title: "공데2-2",
          url: "#",
        },
        {
          title: "공데2-3",
          url: "#",
        },
      ],
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
        {
          title: "공데3-2",
          url: "#",
        },
        {
          title: "공데3-3",
          url: "#",
        },
        {
          title: "공데3-4",
          url: "#",
        },
      ],
    },
  ],
  projects: [
    {
      name: "Installation",
      url: "/installation",
      icon: Frame,
    },
    {
      name: "Usage",
      url: "/usage",
      icon: PieChart,
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
      <Input></Input>
      <SidebarContent>
        <NavMain items={data.navMain} />
        <NavMenu projects={data.projects} />
      </SidebarContent>
      <SidebarFooter>{/* Nothing */}</SidebarFooter>
    </Sidebar>
  );
}
