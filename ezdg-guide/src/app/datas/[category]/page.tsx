import { notFound } from "next/navigation";
import { DATA_CATEGORIES } from "@/config/sidebar-datas";
import { DATA_ITEMS } from "@/config/main-datas";
// import { ApiSpecSection } from "@/components/datas/api-spec";

interface PageProps {
  params: {
    category: string;
  };
}

export default function CategoryPage({ params }: PageProps) {
  const category = DATA_CATEGORIES.find((c) => c.id === params.category);
  if (!category) return notFound();

  // 메인 페이지의 상세 정보 가져오기
  const mainData = DATA_ITEMS.find((item) => item.title === category.title);

  // endpoint가 있는 경우와 없는 경우(라이브러리)를 구분
  if (category.endpoints && category.endpoints.length > 0) {
    return (
      <div className="container items-center mx-auto px-8 sm:px-12 md:px-16 lg:px-32 py-8 sm:py-12 lg:py-24">
        {/* API 카테고리 개요 */}
        <div className="mb-8">
          <h1 className="text-3xl font-bold mb-4">{category.title}</h1>
          <div className="bg-white rounded-lg p-6 shadow-sm border">
            <p className="text-gray-600 mb-4">{category.description}</p>
            <div className="text-sm text-gray-500">Version {category.apiVersion}</div>
          </div>
        </div>

        {/* Endpoints 목록 */}
        <div className="space-y-6">
          <h2 className="text-xl font-semibold">사용 가능한 Endpoints</h2>
          {category.endpoints.map((endpoint) => (
            <div key={endpoint.id} className="bg-white rounded-lg p-6 shadow-sm border">
              <h3 className="text-lg font-medium mb-2">
                <a
                  href={`/datas/${category.id}/${endpoint.path.replace("/", "")}`}
                  className="text-blue-600 hover:text-blue-800">
                  {endpoint.title}
                </a>
              </h3>
              <p className="text-gray-600 mb-2">{endpoint.description}</p>
              <code className="px-3 py-1 bg-gray-100 rounded">
                /{category.id}
                {endpoint.path}
              </code>
            </div>
          ))}
        </div>
      </div>
    );
  }

  // 라이브러리 문서 페이지
  return (
    <div className="container items-center mx-auto px-8 sm:px-12 md:px-16 lg:px-32 py-8 sm:py-12 lg:py-24">
      {/* 라이브러리 개요 섹션 */}
      <div className="mb-8">
        <h1 className="text-3xl font-bold mb-4">{category.title}</h1>
        <div className="bg-white rounded-lg p-6 shadow-sm border">
          <p className="text-gray-600 mb-4">{category.description}</p>
          {mainData && (
            <div className="mt-4 p-4 bg-gray-50 rounded-lg">
              <p className="text-gray-700">{mainData.content}</p>
            </div>
          )}
        </div>
      </div>

      {/* 명세 및 예시 섹션 */}
      <div className="space-y-6">
        {/* 입력 명세 */}
        {category.inputSpec && (
          <div className="bg-white rounded-lg p-6 shadow-sm border">
            <h2 className="text-xl font-semibold mb-4">입력 명세</h2>
            <div className="space-y-4">
              {category.inputSpec.map((input, index) => (
                <div key={index} className="p-4 bg-gray-50 rounded-lg">
                  <div className="flex items-start gap-x-4">
                    <div className="min-w-[120px] font-medium">{input.name}</div>
                    <div className="flex-1">
                      <div className="text-sm text-gray-600 mb-1">
                        타입: <code className="bg-gray-100 px-2 py-0.5 rounded">{input.type}</code>
                      </div>
                      <p className="text-gray-700">{input.description}</p>
                      {input.constraints && (
                        <div className="mt-2 text-sm text-gray-600">제약사항: {input.constraints}</div>
                      )}
                    </div>
                  </div>
                </div>
              ))}
            </div>
          </div>
        )}

        {/* 출력 명세 */}
        {category.outputSpec && (
          <div className="bg-white rounded-lg p-6 shadow-sm border">
            <h2 className="text-xl font-semibold mb-4">출력 명세</h2>
            <div className="space-y-4">
              {category.outputSpec.map((output, index) => (
                <div key={index} className="p-4 bg-gray-50 rounded-lg">
                  <div className="flex items-start gap-x-4">
                    <div className="min-w-[120px] font-medium">{output.name}</div>
                    <div className="flex-1">
                      <div className="text-sm text-gray-600 mb-1">
                        타입: <code className="bg-gray-100 px-2 py-0.5 rounded">{output.type}</code>
                      </div>
                      <p className="text-gray-700">{output.description}</p>
                    </div>
                  </div>
                </div>
              ))}
            </div>
          </div>
        )}

        {/* 예시 코드 */}
        {category.examples && (
          <div className="bg-white rounded-lg p-6 shadow-sm border">
            <h2 className="text-xl font-semibold mb-4">예시 코드</h2>
            <div className="space-y-6">
              {category.examples.map((example, index) => (
                <div key={index} className="space-y-3">
                  <h3 className="text-lg font-medium">{example.title}</h3>
                  {example.description && <p className="text-gray-600">{example.description}</p>}
                  <div className="relative">
                    <pre className="bg-gray-50 p-4 rounded-md overflow-x-auto">
                      <code>{example.code}</code>
                    </pre>
                  </div>
                  {example.result && (
                    <div className="mt-2">
                      <h4 className="font-medium text-sm mb-1">실행 결과:</h4>
                      <pre className="bg-gray-50 p-3 rounded-md text-sm">
                        <code>{example.result}</code>
                      </pre>
                    </div>
                  )}
                </div>
              ))}
            </div>
          </div>
        )}
      </div>
    </div>
  );
}
