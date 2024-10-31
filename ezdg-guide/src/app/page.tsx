import MainDescription from "@/components/main/description";
import DataDescription from "@/components/main/datadescription";
import Languages from "@/components/main/languages";

export default function Home() {
  return (
    <div className="container items-center mx-auto px-8 sm:px-12 md:px-16 lg:px-64">
      {/* 라이브러리 설명 */}
      <MainDescription />
      {/* 제공 데이터 종류들 */}
      <DataDescription />
      {/* 지원 언어 */}
      <Languages />
    </div>
  );
}
