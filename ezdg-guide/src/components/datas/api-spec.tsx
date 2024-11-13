"use client";

import { CodeTabs } from "../code-example";
import { Badge } from "../ui/badge";
import type { ApiSpec } from "@/types/main-data";

interface ApiSpecProps {
  spec: ApiSpec;
  baseUrl: string;
}

export function ApiSpecSection({ spec, baseUrl }: ApiSpecProps) {
  return (
    <div className="space-y-6">
      {/* Method & Endpoint */}
      <div className="flex items-center gap-2">
        <Badge className="bg-green-600">GET</Badge>
        <code className="px-3 py-1 bg-slate-100 rounded text-sm">{baseUrl}</code>
      </div>

      {/* Parameters Section */}
      {spec.parameters?.query && spec.parameters.query.length > 0 && (
        <div>
          <h3 className="text-base font-medium mb-3">Query Parameters</h3>
          <div className="border rounded-lg overflow-hidden">
            <table className="w-full text-sm">
              <thead className="bg-slate-50">
                <tr className="border-b">
                  <th className="px-4 py-2 text-left">Parameter</th>
                  <th className="px-4 py-2 text-left">Typer</th>
                  <th className="px-4 py-2 text-left">Required</th>
                  <th className="px-4 py-2 text-left">Description</th>
                  <th className="px-4 py-2 text-left">Example</th>
                </tr>
              </thead>
              <tbody>
                {spec.parameters.query.map((param) => (
                  <tr key={param.name} className="border-b">
                    <td className="px-4 py-2 font-mono text-sm">{param.name}</td>
                    <td className="px-4 py-2">{param.type}</td>
                    <td className="px-4 py-2">
                      {param.required ? <Badge>Required</Badge> : <Badge variant="outline">Optional</Badge>}
                    </td>
                    <td className="px-4 py-2">{param.description}</td>
                    <td className="px-4 py-2 font-mono text-sm">{String(param.example)}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      )}

      {/* Response Example */}
      <div>
        <h3 className="text-base font-medium mb-3">Response</h3>
        <div className="space-y-2">
          <p className="text-sm text-gray-600">{spec.response.description}</p>
          <CodeTabs code={JSON.stringify(spec.response.example, null, 2)} language="json" />
        </div>
      </div>
    </div>
  );
}
