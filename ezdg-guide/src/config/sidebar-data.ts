import { TramFront, MapPinHouse, ThermometerSun } from "lucide-react";
import type { DataCategory } from "@/types/data";

// 데이터 카테고리 설정
export const DATA_CATEGORIES: DataCategory[] = [
  {
    id: "tourism",
    title: "한국 관광지 정보",
    description: "국내 관광지 정보 통합 제공 서비스",
    icon: TramFront,
    apiVersion: "1.0",
    endpoints: [
      {
        id: "search",
        title: "관광정보조회",
        path: "/search",
        description: "관광지 정보 검색 API"
      },
      {
        id: "regions",
        title: "지역별 관광지",
        path: "/regions",
        description: "지역별 관광지 정보 API"
      }
    ]
  },
  {
    id: "real-estate",
    title: "부동산 실거래가 정보",
    description: "전국 부동산 실거래가 정보 서비스",
    icon: MapPinHouse,
    apiVersion: "1.0",
    endpoints: [
      {
        id: "apartments",
        title: "아파트 실거래가",
        path: "/apartments",
        description: "아파트 실거래가 조회 API"
      }
    ]
  },
  {
    id: "korean-weather",
    title: "날씨 정보",
    description: "전국 날씨 조회 서비스",
    icon: ThermometerSun,
    apiVersion: "1.0",
    endpoints: [
      {
        id: "weathers",
        title: "시간별 날씨 조회 서비스",
        path: "/weathers",
        description: "날씨 조회 API"
      }
    ]
  }
];