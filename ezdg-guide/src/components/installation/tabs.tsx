"use client";

import { useEffect, useState } from "react";
import { Button } from "@/components/ui/button";
import { Copy, Check } from "lucide-react";
import Prism from "prismjs";

// 필요한 언어 import
import "prismjs/components/prism-javascript";
import "prismjs/components/prism-typescript";
import "prismjs/components/prism-java";
import "prismjs/components/prism-xml-doc";
import "prismjs/components/prism-markup";
import "prismjs/components/prism-bash";
import "prismjs/themes/prism-tomorrow.css";
import "@/components/code-example/code-styles.css";

import type { CodeLanguage } from "@/components/code-example/types";

interface CodeTabsProps {
  code: string;
  language: CodeLanguage;
}

// 언어 처리 로직을 컴포넌트 외부로 분리
const getEffectiveLanguage = (code: string, language: CodeLanguage): string => {
  // XML 처리 (Maven 의존성)
  if (language === "xml") {
    return "markup";
  }

  // npm/yarn 명령어 처리
  if (code.includes("npm install") || code.includes("yarn add")) {
    return "bash";
  }

  return language;
};

export function CodeTabs({ code, language }: CodeTabsProps) {
  const [copied, setCopied] = useState(false);

  useEffect(() => {
    // 컴포넌트가 마운트될 때와 코드/언어가 변경될 때 하이라이팅
    requestAnimationFrame(() => {
      Prism.highlightAll();
    });
  }, [code, language]);

  // 복사 버튼
  const copyToClipboard = async () => {
    try {
      await navigator.clipboard.writeText(code);
      setCopied(true);
      setTimeout(() => setCopied(false), 1500);
    } catch (error) {
      console.log("Failed to copy code:", error);
    }
  };

  const currentLanguage = getEffectiveLanguage(code, language);

  return (
    <div className="relative group">
      <pre className="rounded-lg bg-slate-950 p-4 overflow-x-auto">
        <code className={`language-${currentLanguage} syntax-highlighted`}>{code.trim()}</code>
      </pre>
      <Button
        variant="outline"
        size="icon"
        onClick={copyToClipboard}
        aria-label={copied ? "Copied!" : "Copy Code"}
        className="absolute top-3 right-3 h-8 w-8 bg-slate-800 hover:bg-slate-700 transition-all duration-200 opacity-0 group-hover:opacity-100">
        {copied ? <Check className="h-4 w-4 text-slate-50" /> : <Copy className="h-4 w-4 text-slate-50" />}
      </Button>
    </div>
  );
}
