// app/installation/page.tsx
"use client";

import { Tabs, TabsList, TabsTrigger, TabsContent } from "@/components/ui/tabs";
import { JavaExample } from "@/components/installation/java";
import { JavaScriptExample } from "@/components/installation/javascript";

export default function InstallationPage() {
  return (
    <div className="container items-center mx-auto px-8 sm:px-12 md:px-16 lg:px-32 py-8 sm:py-12 lg:py-24">
      <h2 className="text-2xl font-bold mb-6">라이브러리 설치</h2>
      <Tabs defaultValue="java" className="w-full">
        <div className="flex items-center justify-between border-b pb-2">
          <TabsList className="grid w-[400px] grid-cols-2">
            <TabsTrigger value="java">Java</TabsTrigger>
            <TabsTrigger value="javascript">JavaScript</TabsTrigger>
          </TabsList>
        </div>

        <TabsContent value="java" className="mt-6">
          <JavaExample />
        </TabsContent>

        <TabsContent value="javascript" className="mt-6">
          <JavaScriptExample />
        </TabsContent>
      </Tabs>
    </div>
  );
}
