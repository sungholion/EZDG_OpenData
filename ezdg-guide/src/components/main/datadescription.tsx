import Image from "next/image";
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";
import { DataItem } from "@/types/data";
import { DATA_ITEMS } from "@/config/main-datas";

const DataCard = ({ title, badge, description, content, image }: DataItem) => (
  <Card className="bg-white shadow-xl hover:shadow-2xl transition-shadow">
    <CardHeader className="flex-none">
      <div className="w-full h-40 rounded-t-lg content-center overflow-hidden mb-2">
        <Image src={image.src} alt={image.alt} width={400} height={200} className="object-cover" />
      </div>
      <div className="flex items-center justify-between">
        <CardTitle className="text-2xl font-bold">{title}</CardTitle>
      </div>
      <div>
        <Badge>{badge}</Badge>
      </div>
      <CardDescription className="text-base">{description}</CardDescription>
    </CardHeader>
    <CardContent className="flex-1">
      <p className="text-gray-600">{content}</p>
    </CardContent>
  </Card>
);

export default function DataDescription() {
  return (
    <div className="flex flex-col items-start gap-4 sm:gap-6 px-2 sm:px-4 py-8 sm:py-12 lg:py-24">
      <h1 className="text-2xl sm:text-3xl lg:text-4xl">사용 가능한 데이터</h1>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {DATA_ITEMS.map((item, index) => (
          <DataCard key={index} {...item} />
        ))}
      </div>
    </div>
  );
}
