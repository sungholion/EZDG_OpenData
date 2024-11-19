import React from "react";
import type { FileGuideData } from "@/types/guide";
import { formatFieldName } from "@/lib/format";

interface FileGuideViewProps {
  data: FileGuideData;
}

export const FileGuideView: React.FC<FileGuideViewProps> = ({ data }) => {
  return (
    <div className="space-y-8">
      {/* 파일 개요 */}
      <section className="bg-white rounded-lg p-6 shadow-sm border">
        <h2 className="text-xl font-semibold mb-4">파일 정보</h2>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
          <div className="flex gap-2">
            <span className="font-medium min-w-[120px]">데이터 명:</span>
            <span className="text-gray-600">{formatFieldName(data.originalFileName)}</span>
          </div>
          {/* <div className="flex gap-2">
            <span className="font-medium min-w-[120px]">변역된 데이터 명:</span>
            <span className="text-gray-600">{data.translatedFileName}</span>
          </div> */}
        </div>
      </section>

      {/* 필드 명세 */}
      <section className="bg-white rounded-lg p-6 shadow-sm border">
        <h2 className="text-xl font-semibold mb-4">필드 명세</h2>
        <div className="overflow-x-auto">
          <table className="min-w-full divide-y divide-gray-200">
            <thead className="bg-gray-50">
              <tr>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  필드명
                </th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  원본 필드명
                </th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">타입</th>
              </tr>
            </thead>
            <tbody className="bg-white divide-y divide-gray-200">
              {data.fields.map((field, idx) => (
                <tr key={idx} className="hover:bg-gray-50">
                  <td className="px-6 py-4 whitespace-nowrap">
                    <code className="text-blue-600">{field.translatedName}</code>
                  </td>
                  <td className="px-6 py-4 whitespace-nowrap text-gray-600">{field.originalName}</td>
                  <td className="px-6 py-4 whitespace-nowrap">
                    <span className="px-2 py-1 text-xs font-medium bg-gray-100 rounded">{field.type}</span>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </section>

      {/* 메소드 목록 */}
      {data.methodList && data.methodList.length > 0 && (
        <section className="bg-white rounded-lg p-6 shadow-sm border">
          <h2 className="text-xl font-semibold mb-4">메소드 목록</h2>
          <div className="overflow-x-auto">
            <table className="min-w-full divide-y divide-gray-200">
              <thead className="bg-gray-50">
                <tr>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    메소드
                  </th>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    설명
                  </th>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    반환 타입
                  </th>
                </tr>
              </thead>
              <tbody className="bg-white divide-y divide-gray-200">
                {data.methodList.map((method, idx) => (
                  <tr key={idx} className="hover:bg-gray-50">
                    <td className="px-6 py-4 whitespace-nowrap">
                      <code className="text-blue-600">{method.method}</code>
                    </td>
                    <td className="px-6 py-4">
                      <span className="text-gray-600">{method.description}</span>
                    </td>
                    <td className="px-6 py-4 whitespace-nowrap">
                      <span className="px-2 py-1 text-xs font-medium bg-gray-100 rounded">{method.returnType}</span>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </section>
      )}
    </div>
  );
};
