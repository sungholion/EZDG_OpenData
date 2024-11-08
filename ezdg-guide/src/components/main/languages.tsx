import { Card } from "../ui/card";
import Image from "next/image";

const languages = [
  {
    id: "java",
    name: "java",
    logo: "/Java.png",
  },
  {
    id: "javascript",
    name: "javascript",
    logo: "/JavaScript.png",
  },
];

export default function Languages() {
  return (
    <div className="flex flex-col gap-4 sm:gap-6 px-2 sm:px-4 py-8 sm:py-12 lg:py-24">
      <h1 className="text-2xl sm:text-3xl lg:text-4xl ">지원 언어</h1>
      <div className="grid grid-cols-1 w-full md:grid-cols-1 lg:grid-cols-2 gap-8">
        {languages.map((language) => (
          <Card
            key={language.id}
            className="flex justfiy-center p-6 shadow-xl bg-white hover:shadow-2xl transition-shadow">
            <div className="flex w-full h-auto justify-center content-center items-center overflow-hidden">
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
