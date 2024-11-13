// TODO: 통신 연결 시 파라미터 변경 필요

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
        description: "관광지 정보 검색 API",
        apiSpec: {
          parameters: {
            query: [
              {
                name: "keyword",
                type: "string",
                required: true,
                description: "검색할 관광지 키워드",
                example: "경복궁"
              },
              {
                name: "page",
                type: "number",
                required: false,
                description: "페이지 번호 (기본값: 1)",
                example: 1
              },
              {
                name: "size",
                type: "number",
                required: false,
                description: "페이지당 결과 수 (기본값: 10)",
                example: 10
              }
            ]
          },
          response: {
            description: "검색된 관광지 정보 목록을 반환합니다.",
            example: {
              status: "success",
              items: [
                {
                  id: "POI001",
                  name: "경복궁",
                  address: "서울특별시 종로구 사직로 161",
                  category: "관광지",
                  description: "조선시대 대표적인 궁궐",
                  images: [
                    "https://example.com/images/gyeongbokgung1.jpg"
                  ],
                  coordinates: {
                    latitude: 37.579617,
                    longitude: 126.977041
                  },
                  operatingHours: {
                  weekday: "09:00-18:00",
                  weekend: "09:00-17:00"
                },
                fees: {
                  adult: 3000,
                  child: 1500,
                  senior: 1500
                }
                }
              ],
              pagination: {
                totalItems: 1,
                currentPage: 1,
                totalPages: 1,
                hasNext: false
              }
            }
          }
        }
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