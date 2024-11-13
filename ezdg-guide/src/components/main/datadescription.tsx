"use client";

import Image from "next/image";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Carousel, CarouselContent, CarouselItem, CarouselNext, CarouselPrevious } from "@/components/ui/carousel";
import Autoplay from "embla-carousel-autoplay";
import { useRef } from "react";
import type { DataDisplayitem } from "@/types/main-data";

// 카드 정보 넣기
const DataCard = ({ id, type, mainTitle, mainDescription, originalFileName }: DataDisplayitem) => (
  <Card className="bg-white shadow-xl hover:shadow-2xl transition-shadow">
    <CardHeader className="flex-none">
      <div className="w-full h-40 rounded-t-lg content-center overflow-hidden mb-2">
        <Image
          src={`/${id}.png`}
          alt={type === "api" ? mainTitle! : originalFileName!}
          width={400}
          height={200}
          className="object-cover"
        />
      </div>
      <div className="flex items-center justify-between">
        <CardTitle className="text-2xl font-bold">{type === "api" ? mainTitle : originalFileName}</CardTitle>
      </div>
    </CardHeader>
    <CardContent className="flex-1">
      <p className="text-gray-600">{type === "api" ? mainDescription : originalFileName}</p>
    </CardContent>
  </Card>
);

export default function DataDescription({ items }: { items: DataDisplayitem[] }) {
  const plugin = useRef(Autoplay({ delay: 3000, stopOnInteraction: true }));

  // 3개씩 그룹화
  const groupItems = (items: DataDisplayitem[]) => {
    const groups = [];
    for (let i = 0; i < items.length; i += 3) {
      groups.push(items.slice(i, i + 3));
    }
    return groups;
  };

  const groupedItems = groupItems(items);

  return (
    <div className="flex flex-col items-start gap-4 sm:gap-6 px-2 sm:px-4 py-8 sm:py-12 lg:py-24">
      <h1 className="text-2xl sm:text-3xl lg:text-4xl">사용 가능한 데이터</h1>
      <div className="w-full">
        <Carousel
          plugins={[plugin.current]}
          className="w-full"
          onMouseEnter={plugin.current.stop}
          onMouseLeave={plugin.current.reset}>
          <CarouselContent>
            {groupedItems.map((group, groupIndex) => (
              <CarouselItem key={groupIndex}>
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                  {group.map((item) => (
                    <DataCard key={item.id} {...item} />
                  ))}
                </div>
              </CarouselItem>
            ))}
          </CarouselContent>
          <CarouselPrevious />
          <CarouselNext />
        </Carousel>
      </div>
    </div>
  );
}
