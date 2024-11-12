import { cn } from "@/lib/utils";
import { CodeTabs } from "../installation/tabs";
import type { CodeSectionProps } from "./types";

export function CodeSection({ installations, className }: CodeSectionProps) {
  return (
    <div className={cn("space-y-8", className)}>
      {installations.map((installation, index) => (
        <section key={index}>
          <div className="mb-3">
            <h3 className="text-lg font-semibold">{installation.title}</h3>
            {installation.description && (
              <p className="mt-1 text-sm text-muted-foreground">{installation.description}</p>
            )}
          </div>
          <div className="rounded-lg border p-4">
            <CodeTabs
              code={installation.code}
              language={installation.language}
            />
          </div>
        </section>
      ))}
    </div>
  );
}
