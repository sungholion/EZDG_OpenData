// // TODO: 통신 연결 시 파라미터 변경 필요

// import { TramFront, MapPinHouse, ThermometerSun } from "lucide-react";

// // 데이터 카테고리 설정
// export const DATA_CATEGORIES: DataCategory[] = [
//   {
//     id: "tourism",
//     title: "한국 관광지 정보",
//     description: "국내 관광지 정보 통합 제공 서비스",
//     icon: TramFront,
//     apiVersion: "1.0",
//     endpoints: [
//       {
//         id: "search",
//         title: "관광정보조회",
//         path: "/search",
//         description: "관광지 정보 검색 API",
//         apiSpec: {
//           parameters: {
//             query: [
//               {
//                 name: "keyword",
//                 type: "string",
//                 required: true,
//                 description: "검색할 관광지 키워드",
//                 example: "경복궁"
//               },
//               {
//                 name: "page",
//                 type: "number",
//                 required: false,
//                 description: "페이지 번호 (기본값: 1)",
//                 example: 1
//               },
//               {
//                 name: "size",
//                 type: "number",
//                 required: false,
//                 description: "페이지당 결과 수 (기본값: 10)",
//                 example: 10
//               }
//             ]
//           },
//           response: {
//             description: "검색된 관광지 정보 목록을 반환합니다.",
//             example: {
//               status: "success",
//               items: [
//                 {
//                   id: "POI001",
//                   name: "경복궁",
//                   address: "서울특별시 종로구 사직로 161",
//                   category: "관광지",
//                   description: "조선시대 대표적인 궁궐",
//                   images: [
//                     "https://example.com/images/gyeongbokgung1.jpg"
//                   ],
//                   coordinates: {
//                     latitude: 37.579617,
//                     longitude: 126.977041
//                   },
//                   operatingHours: {
//                   weekday: "09:00-18:00",
//                   weekend: "09:00-17:00"
//                 },
//                 fees: {
//                   adult: 3000,
//                   child: 1500,
//                   senior: 1500
//                 }
//                 }
//               ],
//               pagination: {
//                 totalItems: 1,
//                 currentPage: 1,
//                 totalPages: 1,
//                 hasNext: false
//               }
//             }
//           }
//         }
//       },
//       {
//         id: "regions",
//         title: "지역별 관광지",
//         path: "/regions",
//         description: "지역별 관광지 정보 API",
//         apiSpec: {
//           parameters: {
//             query: [
//               {
//                 name: "keyword",
//                 type: "string",
//                 required: true,
//                 description: "검색할 관광지 키워드",
//                 example: "경복궁"
//               },
//               {
//                 name: "page",
//                 type: "number",
//                 required: false,
//                 description: "페이지 번호 (기본값: 1)",
//                 example: 1
//               },
//               {
//                 name: "size",
//                 type: "number",
//                 required: false,
//                 description: "페이지당 결과 수 (기본값: 10)",
//                 example: 10
//               }
//             ]
//           },
//           response: {
//             description: "검색된 관광지 정보 목록을 반환합니다.",
//             example: {
//               status: "success",
//               items: [
//                 {
//                   id: "POI001",
//                   name: "경복궁",
//                   address: "서울특별시 종로구 사직로 161",
//                   category: "관광지",
//                   description: "조선시대 대표적인 궁궐",
//                   images: [
//                     "https://example.com/images/gyeongbokgung1.jpg"
//                   ],
//                   coordinates: {
//                     latitude: 37.579617,
//                     longitude: 126.977041
//                   },
//                   operatingHours: {
//                   weekday: "09:00-18:00",
//                   weekend: "09:00-17:00"
//                 },
//                 fees: {
//                   adult: 3000,
//                   child: 1500,
//                   senior: 1500
//                 }
//                 }
//               ],
//               pagination: {
//                 totalItems: 1,
//                 currentPage: 1,
//                 totalPages: 1,
//                 hasNext: false
//               }
//             }
//           }
//         }
//       }
//     ]
//   },
//   {
//     id: "real-estate-library",
//     title: "부동산 실거래가 정보",
//     description: "부동산 실거래가 데이터 분석을 위한 자바 라이브러리",
//     icon: MapPinHouse,
//     inputSpec: [
//       {
//         name: "transactionData",
//         type: "RealEstateTransaction[]",
//         description: "분석할 실거래가 데이터 배열",
//         constraints: "최소 1개 이상의 거래 데이터 필요"
//       }
//     ],
//     outputSpec: [
//       {
//         name: "analysis",
//         type: "RealEstateAnalysis",
//         description: "부동산 실거래가 분석 결과"
//       }
//     ],
//     examples: [
//       {
//         title: "아파트 실거래가 분석",
//         description: "특정 지역의 아파트 실거래가 분석 예시",
//         code: `RealEstateAnalyzer analyzer = new RealEstateAnalyzer();

// List<RealEstateTransaction> data = Arrays.asList(
//     new RealEstateTransaction(
//         "2024-01-15",
//         "서울시 강남구",
//         "래미안아파트",
//         "아파트",
//         85.5,
//         15,
//         1200000000
//     ),
//     new RealEstateTransaction(
//         "2024-01-20",
//         "서울시 강남구",
//         "래미안아파트",
//         "아파트",
//         85.5,
//         10,
//         1150000000
//     ),
//     new RealEstateTransaction(
//         "2024-01-25",
//         "서울시 강남구",
//         "래미안아파트",
//         "아파트",
//         85.5,
//         20,
//         1250000000
//     )
// );

// RealEstateAnalysis result = analyzer.analyze(data);
// System.out.println("평균 거래가: " + result.getAveragePrice());
// System.out.println("최고 거래가: " + result.getMaxPrice());
// System.out.println("최저 거래가: " + result.getMinPrice());
// System.out.println("평균 평당가: " + result.getAveragePricePerSquareMeter());
// System.out.println("거래량: " + result.getTransactionCount());`,
//         result: `평균 거래가: 1,200,000,000원
// 최고 거래가: 1,250,000,000원
// 최저 거래가: 1,150,000,000원
// 평균 평당가: 14,035,087원
// 거래량: 3건`
//       }
//     ]
// },
//   {
//     id: "weather-library",
//     title: "날씨 정보",
//     description: "기상 데이터 분석을 위한 자바 라이브러리",
//     icon: ThermometerSun,
//     inputSpec: [
//       {
//         name: "weatherData",
//         type: "WeatherData[]",
//         description: "분석할 기상 데이터 배열",
//         constraints: "최소 1개 이상의 데이터 필요"
//       }
//     ],
//     outputSpec: [
//       {
//         name: "analysis",
//         type: "WeatherAnalysis",
//         description: "기상 데이터 분석 결과"
//       }
//     ],
//     examples: [
//       {
//         title: "기온 데이터 분석",
//         description: "일일 기온 데이터 분석 예시",
//         code: `WeatherAnalyzer analyzer = new WeatherAnalyzer();

// List<WeatherData> data = Arrays.asList(
//     new WeatherData("2024-01-01", 12.5, 60),
//     new WeatherData("2024-01-02", 13.2, 55),
//     new WeatherData("2024-01-03", 11.8, 65)
// );

// WeatherAnalysis result = analyzer.analyze(data);
// System.out.println("평균 기온: " + result.getAverageTemperature());
// System.out.println("최고 기온: " + result.getMaxTemperature());
// System.out.println("최저 기온: " + result.getMinTemperature());`,
//         result: `평균 기온: 12.5
// 최고 기온: 13.2
// 최저 기온: 11.8`
//       }
//     ]
//   }
// ];