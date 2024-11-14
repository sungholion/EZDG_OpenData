import React from "react";
import type { ApiGuideData, ApiEndpointDetail } from "@/types/guide";

interface ApiGuideViewProps {
  data: ApiGuideData;
}

const EndpointSection: React.FC<{ endpoint: ApiEndpointDetail }> = ({ endpoint }) => {
  return (
    <div className="bg-white rounded-lg p-6 shadow-sm border">
      <h3 className="text-lg font-semibold mb-4">{endpoint.title}</h3>
      <div className="space-y-4">
        <div>
          <h4 className="font-medium mb-2">기본 정보</h4>
          <div className="space-y-2">
            <div>
              <span className="font-medium">Package:</span>
              {endpoint.packageName}
            </div>
            <div>
              <span className="font-medium">Class:</span>
              {endpoint.className}
            </div>
          </div>
          <div>
            <span className="font-medium">엔드포인트:</span>
            <code className="ml-2 px-2 py-1 bg-gray-100 rounded">
              {endpoint.baseUrl}
              {endpoint.endpoint}
            </code>
          </div>
        </div>
      </div>

      {/* Request Fields */}
      <div>
        <h4 className="font-medium mb-2">요청 필드</h4>
        <div className="space-y-2">
          {endpoint.requestFields.map((field, idx) => (
            <div key={idx} className="p-3 bg-gray-50 rounded">
              <div className="flex items-start gap-2">
                <div className="min-w-[100px]">
                  <div className="font-medium">{field.name}</div>
                  <div className="text-sm text-gray-600">{field.type}</div>
                </div>
                <div className="flex-1">
                  <div className="text-sm">{field.description}</div>
                  {field.sampleData && (
                    <div className="text-sm text-red-600">
                      예시: <code className="bg-gray-100 prx-1 rounded">{field.sampleData}</code>
                    </div>
                  )}
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>

      {/* Response Fields */}
      <div>
        <h4 className="font-medium mb-2">응답 필드</h4>
        <div className="space-y-2">
          {endpoint.responseFields.map((field, idx) => (
            <div key={idx} className="p-3 bg-gray-50 rounded">
              <div className="flex items-start gap-2">
                <div className="min-w-[100px]">
                  <div className="font-medium">{field.name}</div>
                  <div className="text-sm text-gray-600">{field.type}</div>
                </div>
                <div className="flex-1">
                  <div className="text-sm">{field.description}</div>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export const ApiGuideView: React.FC<ApiGuideViewProps> = ({ data }) => {
  return (
    <div className="space-y-6">
      {/* API 개요 */}
      <div className="bg-white rounded-lg p-6 shadow-sm border">
        <h2 className="text-xl font-semibold mb-4">{data.mainTitle}</h2>
        <p className="text-gray-600">{data.mainDescription}</p>
      </div>

      {/* API 엔드포인트 목록 */}
      <div className="space-y-6">
        {data.apiList.map((endpoint, index) => (
          <EndpointSection key={index} endpoint={endpoint} />
        ))}
      </div>
    </div>
  );
};
