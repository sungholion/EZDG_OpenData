// app/page.tsx
import MainDescription from "@/components/main/maindescription";
import DataDescription from "@/components/main/datadescription";
import Languages from "@/components/main/languages";
import Feature from "@/components/main/feature";
import { guideAPI } from "./api/guide";
import type { GuideData, ApiGuideData, FileGuideData } from "@/types/guide";

export default async function Home() {
  try {
    // 메뉴 아이템 목록 가져오기
    const menuItems = await guideAPI.getGuideMenu();

    // 각 아이템의 상세 정보 가져오기
    const detailedItems = await Promise.all(
      menuItems.map(async (item) => {
        try {
          const detailData = await guideAPI.getGuideDetail(item._id);

          if (!detailData) {
            throw new Error(`No detail data for item ${item._id}`);
          }

          const isApiData = (detailData as ApiGuideData).type === "api";

          return {
            id: item._id,
            type: detailData.type,
            title: isApiData ? (detailData as ApiGuideData).mainTitle : (detailData as FileGuideData).originalFileName,
            description: isApiData
              ? (detailData as ApiGuideData).mainDescription
              : (detailData as FileGuideData).translatedFileName, // originalFileName 대신 translatedFileName 사용
            deployed: detailData.deployed,
          };
        } catch (error) {
          console.error(`Failed to fetch details for ${item._id}:`, error);
          return null;
        }
      })
    );

    // null값 제거
    const validItems = detailedItems.filter((item): item is NonNullable<typeof item> => item !== null);

    return (
      <div className="container items-center mx-auto px-8 sm:px-12 md:px-16 lg:px-32">
        <MainDescription />
        <DataDescription items={validItems} />
        <Languages />
        <Feature
          title="손쉬운 OpenAPI 활용"
          description="EZDG를 사용하면 공공데이터 OpenAPI를 쉽게 활용할 수 있습니다. 복잡한 요청 데이터 구조를 단순화하여 개발자가 필요한 정보에 빠르게 접근할 수 있습니다."
          image="/Feature1.png"
        />
        <Feature
          title="파일 데이터의 API 제공"
          description="파일 형태로 제공되는 공공데이터를 RESTful API 형태로 제공합니다. CSV의 다양한 형식의 데이터를 손쉽게 API 엔드포인트로 제공받아 즉시 사용할 수 있습니다."
          image="/Feature2.png"
        />
      </div>
    );
  } catch (error) {
    console.error("Failed to fetch guide data:", error);
    // 에러 UI 렌더링 또는 에러 페이지로 리다이렉트
    return <div>Failed to load data</div>;
  }
}
