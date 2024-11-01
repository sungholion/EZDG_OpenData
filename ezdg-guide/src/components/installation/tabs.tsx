"use client";

import { useState } from "react";
import { Button } from "@/components/ui/button";
import { Copy, Check } from "lucide-react";

interface CodeTabsProps {
  code: string;
  language: string;
}

export function CodeTabs({ code, language }: CodeTabsProps) {
  const [copied, setCopied] = useState(false);

  const copyToClipboard = async () => {
    await navigator.clipboard.writeText(code);
    setCopied(true);
    setTimeout(() => setCopied(false), 1500);
  };

  return (
    <div className="relative">
      <pre className="rounded-lg bg-slate-950 p-4 overflow-x-auto">
        <code className="text-sm text-slate-50 font-mono">{code}</code>
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
