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
	implementation 'com.openmind:ezdg:v1.0.0'
}`,
    language: "java",
  },
  {
    title: "사용 예제",
    description: "EZDG를 이용한 기상청 초단기실황조회",
    code: `public static void main(String[] args) {
        VilageFcstApi api = new VilageFcstApi ()
                .ServiceKey("YOUR_SERVICE_KEY") // 발급받은 서비스 키를 여기에 입력") // 발급받은 서비스 키를 여기에 입력
                .pageNo("1")
                .numOfRows("10")
                .dataType("JSON")
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
    description: "EZDG를 이용한 기상청 초단기예보조회",
    code: `public static void main(String[] args) {
        UltraSrtFcstApi api = new UltraSrtFcstApi()
                .ServiceKey("YOUR_SERVICE_KEY") // 발급받은 서비스 키를 여기에 입력") // 발급받은 서비스 키를 여기에 입력
                .pageNo("1")
                .numOfRows("10")
                .dataType("JSON")
                .base_date("20241112") // 예시 날짜
                .base_time("0630") // 예시 시간
                .nx("60")
                .ny("127");

        // API 호출 및 응답 출력
        UltraSrtFcstApiResponse response = api.fetch();
        System.out.println(response);
    }`,
    language: "java",
  },
];

export function JavaExample() {
  return <CodeSection installations={JAVA_EXAMPLES} />;
}
