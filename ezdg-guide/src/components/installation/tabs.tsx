"use client";

import { useEffect, useState } from "react";
import { Button } from "@/components/ui/button";
import { Copy, Check } from "lucide-react";
import Prism from "prismjs";

// Java 언어만 import
import "prismjs/components/prism-java";
import "prismjs/components/prism-xml-doc";
import "prismjs/components/prism-markup";
import "prismjs/themes/prism-tomorrow.css";
import "prismjs/components/prism-gradle";
import "@/components/code-example/code-styles.css";

// 언어 타입을 Java 관련 타입으로만 제한
type CodeLanguage = "java" | "gradle";

interface CodeTabsProps {
  code: string;
  language: CodeLanguage;
}

// XML 처리만 남기고 단순화
const getEffectiveLanguage = (language: CodeLanguage): string => {
  if (language === "gradle") {
    return "markup";
  }
  return language;
};

export function CodeTabs({ code, language }: CodeTabsProps) {
  const [copied, setCopied] = useState(false);

  useEffect(() => {
    requestAnimationFrame(() => {
      Prism.highlightAll();
    });
  }, [code, language]);

  const copyToClipboard = async () => {
    try {
      await navigator.clipboard.writeText(code);
      setCopied(true);
      setTimeout(() => setCopied(false), 1500);
    } catch (error) {
      console.error("Failed to copy code:", error);
    }
  };

  const currentLanguage = getEffectiveLanguage(language);

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
