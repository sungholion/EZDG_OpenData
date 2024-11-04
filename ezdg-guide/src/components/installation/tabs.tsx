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

interface CodeTabsProps {
  code: string;
  language?: string; // 'javascript', typescript', 'java' 등
}

export function CodeTabs({ code, language }: CodeTabsProps) {
  const [copied, setCopied] = useState(false);

  useEffect(() => {
    // 특수 케이스 처리
    let effectiveLanduage = language;

    // XML 처리 (MAven 의존성)
    if (language === "xml") {
      effectiveLanduage = "markup";
    }

    // npm/yarn 명령어 처리
    if (code.includes("npm install") || code.includes("yarn add")) {
      effectiveLanduage = "bash";
    }

    // 컴포넌트가 마운트되면 Prism의 highlight 함수 실행
    Prism.highlightAll();
  }, [code, language]);

  const copyToClipboard = async () => {
    await navigator.clipboard.writeText(code);
    setCopied(true);
    setTimeout(() => setCopied(false), 1500);
  };

  return (
    <div className="relative group">
      <pre className="rounded-lg bg-slate-950 p-4 overflow-x-auto">
        <code className={`language-${language}`}>{code.trim()}</code>
      </pre>
      <Button
        variant="outline"
        size="icon"
        onClick={copyToClipboard}
        className="absolute top-3 right-3 h-8 w-8 bg-slate-800 hover:bg-slate-700 transition-all duration-200">
        {copied ? <Check className="h-4 w-4 text-slate-50" /> : <Copy className="h-4 w-4 text-slate-50" />}
      </Button>
    </div>
  );
}
