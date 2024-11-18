import { CodeSection, type CodeExample } from "../code-example";

const JAVA_EXAMPLES: CodeExample[] = [
  {
    title: "설치",
    description: "의존성을 추가합니다.",
    code: `repositories {
	maven {
	  url 'https://lab.ssafy.com/api/v4/projects/823781/packages/maven'
	}
}

dependencies {
	implementation 'com.openmind:ezdg:v1.11.0'
}`,
    language: "kotlin",
  },
  {
    title: "사용 예제",
    description: "EZDG를 이용한 기상청 초단기실황조회(OpenAPI 데이터 형태)",
    code: `public static void main(String[] args) {
        VilageFcstApi api = new VilageFcstApi("YOUR_SERVICE_KEY")
                .pageNo(1)
                .numOfRows(10)
                .base_date("20241112") // 예시 날짜
                .base_time("0630") // 예시 시간
                .nx("60")
                .ny("127");

        // API 호출 및 응답 출력
        UVilageFcstApiResponse response = api.fetch();
        System.out.println(response);
    }`,
    language: "java",
  },
  {
    description: "EZDG를 이용한 대구 음식점 등록현황(파일 데이터 형태)",
    code: `public static void main(String[] args) {
        DaeguRestaurantAPI api = new DaeguRestaurantAPI()
                .pageNo(1)
                .numOfRows(100);

        // API 호출 및 응답 출력
        List<DaeguRestaurant> response = api.fetch();
        System.out.println(response);
    }`,
    language: "java",
  },
];

export function JavaExample() {
  return <CodeSection installations={JAVA_EXAMPLES} />;
}
