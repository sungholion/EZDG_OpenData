import Image from "next/image";

export default function MainDescription() {
  return (
    <div className="flex flex-col items-center gap-4 sm:gap-6 text-center px-2 sm:px-4 py-8 sm:py-12 lg:py-24">
      <div className="flex justify-center items-center space-x-2 sm:space-x-4">
        <Image
          className="w-12 h-auto sm:w-16 md:w-20 lg:w-24 xl:w-28"
          src="/Logo.png"
          width={100}
          height={100}
          alt="Logo"
        />
        <h1 className="border-b-4 border-gray-300 text-5xl sm:text-6xl md:text-7xl lg:text-8xl xl:text-9xl font-bold bg-gradient-to-r from-[#192f6a] via-[#0066cc] to-[#20b2aa] text-transparent bg-clip-text">
          EZDG
        </h1>
      </div>
      <div className="max-w-4xl text-3xl sm:text-4xl md:text-4xl lg:text-5xl font-semibold">
        공공데이터를 보다 쉽게 이용해 보세요.
      </div>
      <div className="max-w-xl my-1 text-lg sm:text-xl md:text-2xl">
        <p>EZDG는 파일, OpenAPI 형태의 공공데이터를 보다 쉽게 사용할 수 있게 해주는 라이브러리입니다.</p>
        <p className="mt-2 sm:mt-3">복잡한 단순 반복 코드, EZDG 라이브러리로 해결하세요.</p>
      </div>
    </div>
  );
}
