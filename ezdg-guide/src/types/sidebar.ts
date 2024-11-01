import { LucideIcon } from "lucide-react";

export interface NavDataItem {
  title: string;
  url: string;
  icon: LucideIcon;
  items?: {
    title: string;
    url: string;
  }[];
}

export interface NavMenuItem {
  name: string;
  url: string;
  icon: LucideIcon;
}

export interface SidebarData {
  navData: NavDataItem[];
  navMenu: NavMenuItem[];
}