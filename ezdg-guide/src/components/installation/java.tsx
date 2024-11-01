import { CodeTabs } from "./tabs";

export function JavaExample() {
  const installCode = `<dependency>
    <groupId>com.ezdg</groupId>
    <artifactId>ezdg-core</artifactId>
    <version>1.0.0</version>
</dependency>`;

  const configCode = `import com.ezdg.core.EZDG;

public class EZDGConfig {
    private static final EZDG ezdg = new EZDG.Builder()
        .setApiKey("your-api-key")
        .build();
    
    public static EZDG getInstance() {
        return ezdg;
    }
}`;

  const usageCode = `import com.ezdg.core.EZDG;
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
}`;

  return (
    <div className="space-y-8">
      <section>
        <h3 className="text-lg font-semibold mb-3">설치</h3>
        <div className="rounded-lg border p-4">
          <CodeTabs code={installCode} language="xml" />
        </div>
      </section>

      <section>
        <h3 className="text-lg font-semibold mb-3">설정</h3>
        <div className="rounded-lg border p-4">
          <CodeTabs code={configCode} language="java" />
        </div>
      </section>

      <section>
        <h3 className="text-lg font-semibold mb-3">사용 예제</h3>
        <div className="rounded-lg border p-4">
          <CodeTabs code={usageCode} language="java" />
        </div>
      </section>
    </div>
  );
}
