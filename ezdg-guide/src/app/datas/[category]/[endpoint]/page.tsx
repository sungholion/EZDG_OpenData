import { notFound } from "next/navigation";
import { guideAPI } from "@/app/api/guide";
import { ApiGuideView } from "@/components/guide/api-data";

interface PageProps {
  params: {
    category: string;
    endpoint: string;
  };
}

export default async function ApiPage({ params }: PageProps) {
  try {
    const guideData = await guideAPI.getGuideDetail(params.category, params.endpoint);
    if (!guideData) return notFound();

    return (
      <div className="container items-center mx-auto px-8 sm:px-12 md:px-16 lg:px-32 py-8 sm:py-12 lg:py-24">
        <ApiGuideView data={guideData} />
      </div>
    );
  } catch (error) {
    console.error("Failed to fetch guide detail:", error);
    return notFound();
  }
}
