import Image from "next/image";
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";

export default function DataDescription() {
  return (
    <div className="flex flex-col items-start gap-4 sm:gap-6 px-2 sm:px-4 py-8 sm:py-12 lg:py-24">
      <h1 className="text-2xl sm:text-3xl lg:text-4xl ">사용 가능한 데이터</h1>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {/* 한국 관광지 정보 */}
        <Card className="bg-white shadow-lg hover:shadow-xl transition-shadow">
          <CardHeader className="flex-none">
            <div className="w-full h-40 rounded-t-lg content-center overflow-hidden mb-2">
              <Image src="/Tourism.jpg" alt="한국관광공사 이미지" width={400} height={200} className="object-cover" />
            </div>
            <div className="flex items-center justify-between">
              <CardTitle className="text-2xl font-bold">한국 관광지 정보</CardTitle>
            </div>
            <div>
              <Badge>Tourism API 1.0</Badge>
            </div>
            <CardDescription className="text-base">국내 관광지 정보 통합 제공 서비스</CardDescription>
          </CardHeader>
          <CardContent>
            <p className="text-gray-600">
              전국의 관광지, 문화시설, 축제/행사, 여행코스, 숙박, 음식점 등 다양한 관광 콘텐츠 정보를 제공합니다.
              지역별, 카테고리별 검색이 가능하며, 다국어 지원과 위치기반 검색 기능을 통해 맞춤형 여행 정보 서비스 개발에
              활용할 수 있습니다.
            </p>
          </CardContent>
        </Card>

        {/* 부동산 실거래가 정보 */}
        <Card className="bg-white shadow-lg hover:shadow-xl transition-shadow">
          <CardHeader className="flex-none">
            <div className="w-full h-40 rounded-t-lg content-center overflow-hidden mb-2">
              <Image
                src={"/Realestate.jpg"}
                alt="국토교통부 이미지"
                width={400}
                height={200}
                className="object-cover"
              />
            </div>
            <div className="flex items-center justify-between">
              <CardTitle className="text-2xl font-bold">부동산 실거래가 조회</CardTitle>
            </div>
            <div>
              <Badge>Realestate API 1.0</Badge>
            </div>
            <CardDescription className="text-base">전국 부동산 실거래가 정보 서비스</CardDescription>
          </CardHeader>
          <CardContent className="flex-1">
            <p className="text-gray-600">
              아파트, 단독/다가구, 오피스텔 등 전국 부동산의 실제 거래 정보를 제공합니다. 지역별, 기간별 실거래 내역
              조회가 가능하며, 면적, 층수, 거래 금액 등 상세 정보를 통해 정확한 부동산 시세 분석이 가능합니다.
            </p>
          </CardContent>
        </Card>

        {/* 날씨 정보 */}
        <Card className="bg-white shadow-lg hover:shadow-xl transition-shadow">
          <CardHeader className="flex-none">
            <div className="w-full h-40 rounded-t-lg content-center overflow-hidden mb-2">
              <Image src={"/Weather.png"} alt="기상청 이미지" width={350} height={200} className="object-cover" />
            </div>
            <div className="flex items-center justify-between">
              <CardTitle className="text-2xl font-bold">날씨 정보</CardTitle>
            </div>
            <div>
              <Badge>Weather API 1.0</Badge>
            </div>
            <CardDescription className="text-base">기상청 단기/중기 예보 서비스</CardDescription>
          </CardHeader>
          <CardContent className="flex-1">
            <p className="text-gray-600">
              전국 단기예보(3일) 및 중기예보(10일)에 대한 상세 날씨 정보를 제공합니다. 기온, 강수량, 습도, 풍향/풍속
              등의 기상 데이터를 실시간으로 확인할 수 있으며, 동네예보 API를 통해 상세한 지역별 날씨 정볼르 활용할 수
              있습니다.
            </p>
          </CardContent>
        </Card>
      </div>
    </div>
  );
}
