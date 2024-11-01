import { Card } from "../ui/card";
import Image from "next/image";

const languages = [
  {
    id: "spring",
    name: "spring",
    logo: "/Spring.png",
  },
  {
    id: "nodejs",
    name: "nodejs",
    logo: "/Nodejs.png",
  },
];

export default function Languages() {
  return (
    <div className="flex flex-col items-start gap-4 sm:gap-6 px-2 sm:px-4 py-8 sm:py-12 lg:py-24">
      <h1 className="text-2xl sm:text-3xl lg:text-4xl ">지원 언어</h1>
      <div className="grid grid-cols-1 md:grid-cols-1 lg:grid-cols-2 gap-8">
        {languages.map((language) => (
          <Card
            key={language.id}
            className="flex items-center justfiy-center p-12 bg-white hover:shadow-lg transition-shadow">
            <div className="relative w-full h-32 content-center overflow-hidden">
              <Image
                src={language.logo}
                alt={`$(language.name) Logo`}
                width={400}
                height={300}
                className="object-contain"
              />
            </div>
          </Card>
        ))}
      </div>
    </div>
  );
}
