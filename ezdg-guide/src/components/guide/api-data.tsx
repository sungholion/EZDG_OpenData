"use client";

import React from "react";
import type { ApiGuideData } from "@/types/guide";
import { formatFieldName } from "@/lib/format";

interface ApiGuideViewProps {
  data: ApiGuideData;
}

export const ApiGuideView: React.FC<ApiGuideViewProps> = ({ data }) => {
  const { api } = data;

  // sampleData가 있는 필드들만 필터링
  const requestFieldsWithSamples = api.requestFields.filter((field) => field.sampleData);
  const responseFieldsWithSamples = api.responseFields.filter((field) => field.sampleData);

  return (
    <div className="space-y-8">
      {/* API 개요 */}
      <section className="bg-white rounded-lg p-6 shadow-sm border">
        <h2 className="text-xl font-semibold mb-4">{formatFieldName(data.mainTitle)}</h2>
        <p className="text-gray-600">{data.mainDescription}</p>
      </section>

      {/* API 상세 정보 */}
      <section className="bg-white rounded-lg p-6 shadow-sm border">
        <h3 className="text-lg font-semibold mb-4">{api.title}</h3>

        {/* 기본 정보 */}
        <div className="mb-8">
          <h4 className="font-medium mb-4">기본 정보</h4>
          <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mb-4">
            <div className="flex gap-2">
              <span className="font-medium min-w-[100px]">Package:</span>
              <span className="text-gray-600">{api.packageName}</span>
            </div>
            <div className="flex gap-2">
              <span className="font-medium min-w-[100px]">Class:</span>
              <span className="text-gray-600">{api.className}</span>
            </div>
          </div>
          {/* <div className="flex gap-2 items-center">
            <span className="font-medium">엔드포인트:</span>
            <code className="px-2 py-1 bg-gray-100 rounded text-sm text-blue-600">
              {api.baseUrl}
              {api.endpoint}
            </code>
          </div> */}
        </div>

        {/* Request Fields Table */}
        <div className="mb-8">
          <h4 className="font-medium mb-4">요청 필드</h4>
          <div className="overflow-x-auto">
            <table className="min-w-full divide-y divide-gray-200">
              <thead className="bg-gray-50">
                <tr>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider w-[200px]">
                    필드명
                  </th>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider w-[150px]">
                    타입
                  </th>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider w-[150px]">
                    필수 여부
                  </th>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    설명
                  </th>
                </tr>
              </thead>
              <tbody className="bg-white divide-y divide-gray-200">
                {api.requestFields.map((field, idx) => (
                  <tr key={idx} className="hover:bg-gray-50">
                    <td className="px-6 py-4 whitespace-nowrap">
                      <code className="text-blue-600">{field.name}</code>
                    </td>
                    <td className="px-6 py-4 whitespace-nowrap">
                      <span className="px-2 py-1 text-xs font-medium bg-gray-100 rounded">{field.type}</span>
                    </td>
                    <td className="px-6 py-4 whitespace-nowrap">
                      {field.required === "필수" ? (
                        <span className="text-red-600 font-medium">필수</span>
                      ) : (
                        <span className="text-gray-500">선택</span>
                      )}
                    </td>
                    <td className="px-6 py-4">
                      <span className="text-gray-600">{field.description}</span>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>

        {/* Response Fields Table */}
        <div className="mb-8">
          <h4 className="font-medium mb-4">응답 필드</h4>
          <div className="overflow-x-auto">
            <table className="min-w-full divide-y divide-gray-200">
              <thead className="bg-gray-50">
                <tr>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider w-[200px]">
                    필드명
                  </th>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider w-[150px]">
                    타입
                  </th>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    설명
                  </th>
                </tr>
              </thead>
              <tbody className="bg-white divide-y divide-gray-200">
                {api.responseFields.map((field, idx) => (
                  <tr key={idx} className="hover:bg-gray-50">
                    <td className="px-6 py-4 whitespace-nowrap">
                      <code className="text-blue-600">{field.name}</code>
                    </td>
                    <td className="px-6 py-4 whitespace-nowrap">
                      <span className="px-2 py-1 text-xs font-medium bg-gray-100 rounded">{field.type}</span>
                    </td>
                    <td className="px-6 py-4">
                      <span className="text-gray-600">{field.description}</span>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </section>

      {/* Sample Data Section */}
      {(requestFieldsWithSamples.length > 0 || responseFieldsWithSamples.length > 0) && (
        <section className="bg-white rounded-lg p-6 shadow-sm border">
          <h3 className="text-lg font-semibold mb-6">예시 데이터</h3>

          {requestFieldsWithSamples.length > 0 && (
            <div className="mb-8">
              <h4 className="font-medium text-gray-900 mb-4">요청 필드 예시</h4>
              <div className="space-y-6">
                {requestFieldsWithSamples.map((field, idx) => (
                  <div key={idx} className="bg-gray-50 rounded-lg overflow-hidden">
                    <div className="px-4 py-2 bg-gray-100 border-b">
                      <div className="flex items-center gap-2">
                        <code className="text-blue-600 font-medium">{field.name}</code>
                        <span className="text-sm text-gray-500">예시</span>
                      </div>
                    </div>
                    <pre className="p-4 overflow-x-auto text-sm">{field.sampleData}</pre>
                  </div>
                ))}
              </div>
            </div>
          )}

          {responseFieldsWithSamples.length > 0 && (
            <div>
              <h4 className="font-medium text-gray-900 mb-4">응답 필드 예시</h4>
              <div className="space-y-6">
                {responseFieldsWithSamples.map((field, idx) => (
                  <div key={idx} className="bg-gray-50 rounded-lg overflow-hidden">
                    <div className="px-4 py-2 bg-gray-100 border-b">
                      <div className="flex items-center gap-2">
                        <code className="text-blue-600 font-medium">{field.name}</code>
                        <span className="text-sm text-gray-500">예시</span>
                      </div>
                    </div>
                    <pre className="p-4 overflow-x-auto text-sm">{field.sampleData}</pre>
                  </div>
                ))}
              </div>
            </div>
          )}
        </section>
      )}
    </div>
  );
};
