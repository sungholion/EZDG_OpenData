"use client";

import {
  SidebarGroup,
  SidebarGroupLabel,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
} from "@/components/ui/sidebar";
import { DiscordLogoIcon } from "@radix-ui/react-icons";
import { GitlabIcon } from "lucide-react";

interface ContactItem {
  name: string;
  url: string;
  icon: React.ComponentType<{ className?: string }>;
  description?: string;
}

const contactItems: ContactItem[] = [
  {
    name: "Discord",
    url: "https://discord.gg/your-discord-invite",
    icon: DiscordLogoIcon,
    description: "실시간 문의 및 피드백",
  },
  {
    name: "GitLab",
    url: "https://gitlab.com/your-project",
    icon: GitlabIcon,
    description: "이슈 및 프로젝트 관리",
  },
];

export function NavContact() {
  return (
    <SidebarGroup className="group-data-[collapsible=icon]:hidden">
      <SidebarGroupLabel>Contact</SidebarGroupLabel>
      <SidebarMenu>
        {contactItems.map((item) => (
          <SidebarMenuItem key={item.name}>
            <SidebarMenuButton asChild tooltip={item.description}>
              <a href={item.url} target="_blank" rel="noopener noreferrer">
                <item.icon className="h-4 w-4" />
                <span>{item.name}</span>
              </a>
            </SidebarMenuButton>
          </SidebarMenuItem>
        ))}
      </SidebarMenu>
    </SidebarGroup>
  );
}
