import React from "react";
import type { FileGuideData } from "@/types/guide";
import { formatFieldName } from "@/lib/format";

interface FileGuideViewProps {
  data: FileGuideData;
}

export const FileGuideView: React.FC<FileGuideViewProps> = ({ data }) => {
  return (
    <div className="space-y-6">
      {/* 파일 정보 섹션 */}
      <div className="bg-white rounded-lg p-6 shadow-sm border">
        <h2 className="text-xl font-semibold mb-4">파일 정보</h2>
        <div className="space-y-2">
          <div className="flex gap-2">
            <span className="font-medium">데이터 명:</span>
            <span>{formatFieldName(data.originalFileName)}</span>
          </div>
          <div className="flex gap-2">
            <span className="font-medium">변역된 데이터 명:</span>
            <span>{data.translatedFileName}</span>
          </div>
        </div>
      </div>

      {/* 필드 명세 섹션 */}
      <div className="bg-white rounded-lg p-6 shadow-sm border">
        <h2 className="text-xl font-semibold mb-4">필드 명세</h2>
        <div className="space-4">
          {data.fields.map((field, index) => (
            <div key={index} className="p-4 bg-gray-50 rounded-lg">
              <div className="flex items-start gap-x-4">
                <div className="min-w-[120px] font-medium">
                  {field.translatedName}
                  <div className="text-sm text-gray-500">{field.originalName}</div>
                </div>
                <div className="flex-1">
                  <div className="text-sm text-gray-500">{field.originalName}</div>
                  타입: <code className="bg-gray-100 px-2 py-0.5 rounded">{field.type}</code>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};
