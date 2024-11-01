import Image from "next/image";

interface FeatureProps {
  title: string;
  description: string;
  image: string;
}

export default function Feature({ title, description, image }: FeatureProps) {
  return (
    <div className="container mx-auto px-6 py-8">
      <div className="flex flex-col md:flex-row items-center gap-8 md:gap-12">
        {/* Text Content - Left Side (1/3) */}
        <div className="w-full md:w-1/3">
          <h2 className="text-3xl font-bold mb-4">{title}</h2>
          <p className="text-gray-600 leading-relaxed">{description}</p>
        </div>

        {/* Image - Right Side (2/3) */}
        <div className="w-full md:w-2/3">
          <div className="rounded-lg overflow-hidden">
            <Image src={image} alt={title} width={800} height={400} className="w-full h-auto object-cover" />
          </div>
        </div>
      </div>
    </div>
  );
}
