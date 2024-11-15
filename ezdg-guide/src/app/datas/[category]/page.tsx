import { notFound } from "next/navigation";
import { guideAPI } from "@/app/api/guide";
import { FileGuideView } from "@/components/guide/file-data";

interface PageProps {
  params: {
    category: string;
  };
}

export default async function FilePage({ params }: PageProps) {
  try {
    const menuItems = await guideAPI.getGuideMenu();
    const item = menuItems.find((item) => item._id === params.category);

    if (!item) return notFound();

    const guideData = await guideAPI.getFileDetail(params.category);

    return (
      <div className="container items-center mx-auto px-8 sm:px-12 md:px-16 lg:px-32 py-8 sm:py-12 lg:py-24">
        <FileGuideView data={guideData} />
      </div>
    );
  } catch (error) {
    console.error("Failed to fetch Guide detail:", error);
    return notFound();
  }
}
