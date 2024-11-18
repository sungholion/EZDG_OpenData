"use client";

import { Card } from "../ui/card";
import Image from "next/image";
// import { Lock } from "lucide-react"; // lucide-react 아이콘 사용

const languages = [
  {
    id: "java",
    name: "java",
    logo: "/Java.png",
    available: true,
  },
  {
    id: "javascript",
    name: "javascript",
    logo: "/JavaScript.png",
    available: false,
  },
];

export default function Languages() {
  return (
    <div className="flex flex-col gap-4 sm:gap-6 px-2 sm:px-4 py-8 sm:py-12 lg:py-24">
      <h1 className="text-2xl sm:text-3xl lg:text-4xl">지원 언어</h1>
      <div className="grid grid-cols-1 w-full md:grid-cols-1 lg:grid-cols-2 gap-8">
        {languages.map((language) => (
          <Card
            key={language.id}
            className="relative flex justify-center p-6 shadow-xl bg-white hover:shadow-2xl transition-shadow overflow-hidden">
            {!language.available && (
              <div className="absolute inset-0 bg-black/60 flex flex-col items-center justify-center z-10">
                <div className="transform -rotate-12">
                  <div className="bg-blue-500 text-white px-12 py-2 text-2xl font-bold shadow-lg">준비중</div>
                </div>
                <div className="mt-4 text-white text-sm">추후 지원 예정</div>
              </div>
            )}
            <div
              className={`flex w-full h-auto justify-center content-center items-center overflow-hidden ${
                !language.available ? "opacity-75" : ""
              }`}>
              <Image
                src={language.logo}
                alt={`${language.name} Logo`}
                width={400}
                height={300}
                className="flex justify-center object-contain"
              />
            </div>
          </Card>
        ))}
      </div>
    </div>
  );
}
