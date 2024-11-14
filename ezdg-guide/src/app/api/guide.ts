import api from "@/lib/axios";
import type { GuideMenuItem, GuideData, ApiGuideData, FileGuideData } from "@/types/guide";

export const guideAPI = {
  // 가이드 메뉴 목록 조회
  getGuideMenu: async () => {
    try {
      const response = await api.get<GuideMenuItem[]>("/admin/guide/menu")
      return response.data
    } catch (error) {
      console.log('Failed to fetch guide menu:', error);
      throw error;
    }
  },

  // 특정 가이드 상세 정보 조회 (GuideMenuItem의 id를 쿼리 파라미터로 전달)
  getGuideDetail: async (id: string) => {
    try {
      const response = await api.get<GuideData>(`/admin/guide/detail`, {
        params: { id }
      })
      return response.data
    } catch (error) {
      console.log('Failed to fetch guide detail:', error)
      throw error;
    }
  },

  // 타입 가드 함수들
  isApiGuide: (data: GuideData): data is ApiGuideData => {
    return data.type === 'api';
  },

  isFileGuide: (data: GuideData): data is FileGuideData => {
    return data.type === 'file';
  }
};