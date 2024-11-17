import { Accordion, AccordionContent, AccordionItem, AccordionTrigger } from "@/components/ui/accordion";
import { Separator } from "@/components/ui/separator";

const FAQItems = [
  {
    question: "EZDG 라이브러리는 무료로 사용할 수 있나요?",
    answer:
      "네, EZDG는 오픈소스 라이브러리로 무료로 사용하실 수 있습니다. 공공데이터의 이용허락범위 제1유형에 해당하는 데이터를 쉽게 이용하게 해주며, 일부 데이터는 사용하기 위해 공공데이터 API 인증키가 별도로 필요합니다.",
  },
  {
    question: "어떤 프로그래밍 언어를 지원하나요?",
    answer:
      "현재 EZDG는 Java를 통해 백엔드 환경에서 사용하는 것이 가능합니다. 추후에 Javascript로 작성 가능한 라이브러리도 제공 예정입니다.",
  },
  {
    question: "공공데이터 포털 계정이 필요한가요?",
    answer:
      "네, 대부분의 공공데이터 API를 사용하기 위해서는 공공데이터 포털(data.go.kr)에서 계정을 만들고 API 인증키를 발급받아야 합니다. EZDG는 데이터 요청을 더 쉽게 관리할 수 있도록 도와주는 기능을 제공합니다.",
  },
  {
    question: "데이터 업데이트 주기는 어떻게 되나요?",
    answer:
      "데이터 업데이트 주기는 각 공공데이터의 특성에 따라 다릅니다. EZDG는 각 데이터의 최신 업데이트 시점을 기준으로 데이터를 제공하고 있습니다.",
  },
  {
    question: "오프라인에서도 사용할 수 있나요?",
    answer:
      "EZDG는 캐싱 기능을 제공하여 한 번 조회한 데이터를 로컬에 저장할 수 있습니다. 따라서 인터넷 연결이 불안정하거나 오프라인 상황에서도 마지막으로 캐시된 데이터를 활용할 수 있습니다. 단, 실시간 데이터의 경우 최신 정보 확인을 위해 인터넷 연결이 필요합니다.",
  },
  {
    question: "기술 지원이나 문의는 어떻게 할 수 있나요?",
    answer:
      "GitLab 이슈를 통해 버그 리포트나 기능 제안을 할 수 있으며, 또는 사이드바에 '데이터 추가 요청'을 통해 문의하실 수 있습니다.",
  },
];

export default function FAQ() {
  return (
    <div className="flex flex-col items-center gap-6 sm:gap-6 text-center px-2 sm:px-4 py-8 sm:py-12 lg:py-24">
      <h1 className="text-4xl sm:text-5xl md:text-6xl lg:text-7xl xl:text-8xl font-bold bg-gradient-to-r from-[#192f6a] via-[#0066cc] to-[#20b2aa] text-transparent bg-clip-text">
        FAQ
        <Separator />
      </h1>
      <div className="container items-center mx-auto px-8 sm:px-12 md:px-16 lg:px-64">
        <Accordion type="single" collapsible className="mt-12 space-y-4">
          {FAQItems.map((item, index) => (
            <AccordionItem key={index} value={`item-${index}`}>
              <AccordionTrigger className="text-lg font-semibold text-left">{item.question}</AccordionTrigger>
              <AccordionContent className="text-gray-600 text-left">{item.answer}</AccordionContent>
            </AccordionItem>
          ))}
        </Accordion>
      </div>
    </div>
  );
}
