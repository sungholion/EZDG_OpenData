import { notFound } from "next/navigation";
import { DATA_CATEGORIES } from "@/config/sidebar-data";
import { DATA_ITEMS } from "@/config/main-datas";

interface PageProps {
  params: {
    category: string;
    endpoint: string;
  };
}

export default function EndpointPage({ params }: PageProps) {
  const category = DATA_CATEGORIES.find((c) => c.id === params.category);
  if (!category) return notFound();

  // endpoint path에서 앞의 '/' 제거하여 비교
  const endpoint = category.endpoints.find((e) => e.path.replace("/", "") === params.endpoint);
  if (!endpoint) return notFound();

  // 메인 페이지의 상세 정보 가져오기
  const mainData = DATA_ITEMS.find((item) => item.title === category.title);

  return (
    <div className="container items-center mx-auto px-8 sm:px-12 md:px-16 lg:px-32 py-8 sm:py-12 lg:py-24">
      {/* 데이터 개요 섹션 */}
      <div className="mb-8">
        <div className="flex items-center gap-2 text-sm text-gray-500 mb-2">
          <span>{category.title}</span>
          {/* <span></span>
          <span>{endpoint.title}</span> */}
        </div>
        <h1 className="text-3xl font-bold mb-4">{endpoint.title}</h1>
        <div className="bg-white rounded-lg p-6 shadow-sm border">
          <p className="text-gray-600 mb-4">{endpoint.description}</p>
          {mainData && (
            <div className="mt-4 p-4 bg-gray-50 rounded-lg">
              <p className="text-gray-700">{mainData.content}</p>
            </div>
          )}
        </div>
      </div>

      {/* API 정보 섹션 */}
      <div className="space-y-6">
        {/* Endpoint 정보 */}
        <div className="bg-white rounded-lg p-6 shadow-sm border">
          <h2 className="text-xl font-semibold mb-4">API 엔드포인트</h2>
          <div className="px-4 py-2 bg-gray-50 rounded-md font-mono">
            /api/v1/{category.id}
            {endpoint.path}
          </div>
          <div className="mt-4">
            <span className="">Version {category.apiVersion}</span>
          </div>
        </div>

        {/* API 문서화 섹션 */}
        <div className="bg-white rounded-lg p-6 shadow-sm border">
          <h2 className="text-xl font-semibold mb-4">API 스펙</h2>
          {/* TODO: 필요한 파라미터 등 API 상세 스펙 추가 필요 */}
          <div className="space-y-4">
            <div>
              <h3 className="text-lg font-medium mb-2">요청 방법</h3>
              <code className="px-3 py-1 bg-gray-100 rounded">GET</code>
            </div>

            <div>
              <h3 className="text-lg font-medium mb-2">인증</h3>
              <p>API 키 필요 (헤더에 포함)</p>
            </div>

            {/* 추가적으로 필요한 API 문서 아래에 작성 */}
          </div>
        </div>
      </div>
    </div>
  );
}

// 정정 경로 생성
export function generateStaticParams() {
  const paths: { category: string; endpoint: string }[] = [];

  DATA_CATEGORIES.forEach((category) => {
    category.endpoints.forEach((endpoint) => {
      paths.push({
        category: category.id,
        endpoint: endpoint.path.replace("/", ""),
      });
    });
  });

  return paths;
}
