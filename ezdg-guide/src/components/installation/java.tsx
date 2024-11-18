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
  //   {
  //     title: "설정",
  //     description: "EZDG 인스턴스를 초기화합니다.",
  //     code: `import com.ezdg.core.EZDG;

  // public class EZDGConfig {
  //     private static final EZDG ezdg = new EZDG.Builder()
  //         .setApiKey("your-api-key")
  //         .build();

  //     public static EZDG getInstance() {
  //         return ezdg;
  //     }
  // }`,
  //     language: "java",
  //   },
  {
    title: "사용 예제",
    description: "EZDG를 사용하여 데이터를 변환합니다.",
    code: `import com.ezdg.core.EZDG;
import com.ezdg.core.transform.TransformResult;

public class Example {
    public static void main(String[] args) {
        EZDG ezdg = EZDGConfig.getInstance();
        
        TransformResult result = ezdg.transform()
            .source("/path/to/data.csv")
            .toApi()
            .execute();
            
        String apiEndpoint = result.getEndpoint();
    }
}`,
    language: "java",
  },
];

export function JavaExample() {
  return <CodeSection installations={JAVA_EXAMPLES} />;
}
