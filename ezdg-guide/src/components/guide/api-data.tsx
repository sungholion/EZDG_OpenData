"use client";

import React from "react";
import type { ApiGuideData } from "@/types/guide";
import { formatFieldName } from "@/lib/format";

interface ApiGuideViewProps {
  data: ApiGuideData;
}

export const ApiGuideView: React.FC<ApiGuideViewProps> = ({ data }) => {
  const { api } = data;

  return (
    <div className="space-y-6">
      {/* API 개요 */}
      <div className="bg-white rounded-lg p-6 shadow-sm border">
        <h2 className="text-xl font-semibold mb-4">{formatFieldName(data.mainTitle)}</h2>
        <p className="text-gray-600">{data.mainDescription}</p>
      </div>

      {/* 현재 선택된 API 엔드포인트 상세 정보 */}
      <div className="bg-white rounded-lg p-6 shadow-sm border">
        <h3 className="text-lg font-semibold mb-4">{api.title}</h3>
        <div className="space-y-6">
          {/* 기본 정보 */}
          <div>
            <h4 className="font-medium mb-2">기본 정보</h4>
            <div className="space-y-2">
              <div className="grid grid-cols-1 md:grid-cols-2 gap-2">
                <div>
                  <span className="font-medium">Package: </span>
                  <span className="text-gray-600">{api.packageName}</span>
                </div>
                <div>
                  <span className="font-medium">Class: </span>
                  <span className="text-gray-600">{api.className}</span>
                </div>
              </div>
              <div>
                <span className="font-medium">엔드포인트: </span>
                <code className="px-2 py-1 bg-gray-100 rounded text-sm">
                  {api.baseUrl}
                  {api.endpoint}
                </code>
              </div>
            </div>
          </div>

          {/* Request Fields */}
          <div>
            <h4 className="font-medium mb-3">요청 필드</h4>
            <div className="space-y-2">
              {api.requestFields.map((field, idx) => (
                <div key={idx} className="p-4 bg-gray-50 rounded">
                  <div className="flex items-start gap-4">
                    <div className="min-w-[140px]">
                      <div className="font-medium">{field.name}</div>
                      <div className="text-sm text-gray-600">{field.type}</div>
                      {field.required && <div className="text-sm text-red-600 mt-1">필수</div>}
                    </div>
                    <div className="flex-1">
                      <div className="text-sm text-gray-700">{field.description}</div>
                      {field.sampleData && (
                        <div className="text-sm text-gray-600 mt-1">
                          예시: <code className="bg-gray-100 px-1 rounded">{field.sampleData}</code>
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
            <h4 className="font-medium mb-3">응답 필드</h4>
            <div className="space-y-2">
              {api.responseFields.map((field, idx) => (
                <div key={idx} className="p-4 bg-gray-50 rounded">
                  <div className="flex items-start gap-4">
                    <div className="min-w-[140px]">
                      <div className="font-medium">{field.name}</div>
                      <div className="text-sm text-gray-600">{field.type}</div>
                    </div>
                    <div className="flex-1">
                      <div className="text-sm text-gray-700">{field.description}</div>
                      {field.sampleData && (
                        <div className="text-sm text-gray-600 mt-1">
                          예시: <code className="bg-gray-100 px-1 rounded">{field.sampleData}</code>
                        </div>
                      )}
                    </div>
                  </div>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
