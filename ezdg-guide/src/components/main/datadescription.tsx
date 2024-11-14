"use client";

import Image from "next/image";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Carousel, CarouselContent, CarouselItem, CarouselNext, CarouselPrevious } from "@/components/ui/carousel";
import Autoplay from "embla-carousel-autoplay";
import { useRef } from "react";
import { GuideMenuItem, isApiGuideItem } from "@/types/guide";

interface DataDescriptionProps {
  items: GuideMenuItem[];
}

const DisplayCard = ({ item }: { item: GuideMenuItem }) => {
  const isApi = isApiGuideItem(item);
  const title = isApi ? item.mainTitle : item.originalFileName;
  const description = isApi ? item.mainDescription : item.originalFileName;

  return (
    <Card className="bg-white shadow-xl hover:shadow-2xl transition-shadow w-auto">
      <CardHeader className="flex-none">
        <div className="w-full h-40 rounded-t-lg content-center overflow-hidden mb-2">
          <Image src={`/${item._id}.png`} alt={title} width={400} height={200} className="object-cover" />
        </div>
        <div className="flex items-center justify-between">
          <CardTitle className="text-2xl font-bold">{title}</CardTitle>
        </div>
      </CardHeader>
      <CardContent className="flex-1">
        <p className="text-gray-600">{description}</p>
        {isApi && item.apiList.length > 0 && (
          <div className="mt-4">
            {/* <p className="font-medium mb-2">제공 API 목록:</p>
            <ul className="list-disc list-inside text-sm text-gray-600">
              {item.apiList.map((api, index) => (
                <li key={index}>{api.title}</li>
              ))}
            </ul> */}
          </div>
        )}
      </CardContent>
    </Card>
  );
};

export default function DataDescription({ items }: DataDescriptionProps) {
  const plugin = useRef(Autoplay({ delay: 3000, stopOnInteraction: true }));

  // 3개씩 그룹화
  const groupItems = (items: GuideMenuItem[]) => {
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
                    <DisplayCard key={item._id} item={item} />
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
