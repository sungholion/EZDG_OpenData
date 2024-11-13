import { Download, CircleHelp } from "lucide-react";
import type { NavGuideItem } from "@/types/sidebar";

export const NAV_MENU: NavGuideItem[] = [
  {
    name: "라이브러리 설치",
    url: "/installation",
    icon: Download,
  },
  {
    name: "FAQ",
    url: "/faq",
    icon: CircleHelp,
  }
];