// import { notFound } from "next/navigation";
// import { DATA_CATEGORIES } from "@/config/sidebar-datas";
// import { DATA_ITEMS } from "@/config/main-datas";
// import { ApiSpecSection } from "@/components/datas/api-spec";

// interface PageProps {
//   params: {
//     category: string;
//     endpoint: string;
//   };
// }

// export default function EndpointPage({ params }: PageProps) {
//   const category = DATA_CATEGORIES.find((c) => c.id === params.category);
//   if (!category) return notFound();

//   // 라이브러리 카테고리인 경우(endpoints가 없는 경우) notFound 반환
//   if (!category.endpoints) return notFound();

//   // endpoint path에서 앞의 '/' 제거하여 비교
//   const endpoint = category.endpoints.find((e) => e.path.replace("/", "") === params.endpoint);
//   if (!endpoint) return notFound();

//   // 메인 페이지의 상세 정보 가져오기
//   const mainData = DATA_ITEMS.find((item) => item.title === category.title);

//   const baseUrl = `/api/v1/${category.id}${endpoint.path}`;

//   return (
//     <div className="container items-center mx-auto px-8 sm:px-12 md:px-16 lg:px-32 py-8 sm:py-12 lg:py-24">
//       {/* 데이터 개요 섹션 */}
//       <div className="mb-8">
//         <div className="flex items-center gap-2 text-sm text-gray-500 mb-2">
//           <a href={`/datas/${category.id}`} className="hover:text-gray-700">
//             {category.title}
//           </a>
//           <span className="text-gray-400">/</span>
//           <span>{endpoint.title}</span>
//         </div>
//         <h1 className="text-3xl font-bold mb-4">{endpoint.title}</h1>
//         <div className="bg-white rounded-lg p-6 shadow-sm border">
//           <p className="text-gray-600 mb-4">{endpoint.description}</p>
//           {mainData && (
//             <div className="mt-4 p-4 bg-gray-50 rounded-lg">
//               <p className="text-gray-700">{mainData.content}</p>
//             </div>
//           )}
//         </div>
//       </div>

//       {/* API 정보 섹션 */}
//       <div className="space-y-6">
//         {/* Endpoint 정보 */}
//         <div className="bg-white rounded-lg p-6 shadow-sm border">
//           <h2 className="text-xl font-semibold mb-4">API 엔드포인트</h2>
//           <div className="px-4 py-2 bg-gray-50 rounded-md font-mono">
//             /{category.id}
//             {endpoint.path}
//           </div>
//           <div className="mt-4">
//             <span className="">Version {category.apiVersion}</span>
//           </div>
//         </div>

//         {/* API 문서화 섹션 */}
//         <div className="bg-white rounded-lg p-6 shadow-sm border">
//           <h2 className="text-xl font-semibold mb-4">API 스펙</h2>
//           {endpoint.apiSpec ? (
//             <ApiSpecSection spec={endpoint.apiSpec} baseUrl={baseUrl} />
//           ) : (
//             <div className="space-y-4">
//               <div>
//                 <h3 className="text-lg font-medium mb-2">요청 방법</h3>
//                 <code className="px-3 py-1 bg-gray-100 rounded">GET</code>
//               </div>

//               <div>
//                 <h3 className="text-lg font-medium mb-2">인증</h3>
//                 <p>API 키 필요 (헤더에 포함)</p>
//               </div>
//             </div>
//           )}
//         </div>
//       </div>
//     </div>
//   );
// }

// // 정적 경로 생성
// export function generateStaticParams() {
//   const paths: { category: string; endpoint: string }[] = [];

//   DATA_CATEGORIES.forEach((category) => {
//     // endpoints가 있는 카테고리만 처리
//     if (category.endpoints) {
//       category.endpoints.forEach((endpoint) => {
//         paths.push({
//           category: category.id,
//           endpoint: endpoint.path.replace("/", ""),
//         });
//       });
//     }
//   });

//   return paths;
// }

// -------------------------------------------------------------------

import { notFound } from "next/navigation";
import { guideAPI } from "@/app/api/guide";
import { ApiGuideView } from "@/components/guide/api-data";
import { FileGuideView } from "@/components/guide/file-data";

interface PageProps {
  params: {
    category: string;
  };
}

export default async function CategroyPage({ params }: PageProps) {
  const guideData = await guideAPI.getGuideDetail(params.category);
  if (!guideData) return notFound();

  return (
    <div className="container items-center mx-auto px-8 sm:px-12 md:px-16 lg:px-32 py-8 sm:py-12 lg:py-24">
      {guideAPI.isApiGuide(guideData) ? <ApiGuideView data={guideData} /> : <FileGuideView data={guideData} />}
    </div>
  );
}
