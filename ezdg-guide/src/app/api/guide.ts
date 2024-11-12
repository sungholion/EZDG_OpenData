import api from "@/lib/axios";
import type { GuideItem } from "@/types/guide";

export const guideAPI = {
  getGuideMenu: async () => {
    const response = await api.get<GuideItem[]>("/admin/guide/menu")
    return response.data;
  }
};