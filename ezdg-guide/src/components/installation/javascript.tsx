import { CodeTabs } from "./tabs";

export function JavaScriptExample() {
  const installCode = `npm install @ezdg/core

# or with yarn
yarn add @ezdg/core`;

  const configCode = `import { EZDG } from '@ezdg/core';

// Initialize EZDG instance
const ezdg = new EZDG({
  apiKey: 'your-api-key'
});`;

  const usageCode = `// Transform CSV to API
const result = await ezdg.transform({
  source: './data.csv',
  type: 'api'
});

// Get the API endpoint
const apiEndpoint = result.endpoint;

// Use the API
const response = await fetch(apiEndpoint);
const data = await response.json();`;

  return (
    <div className="space-y-8">
      <section>
        <h3 className="text-lg font-semibold mb-3">설치</h3>
        <div className="rounded-lg border p-4">
          <CodeTabs code={installCode} language="bash" />
        </div>
      </section>

      <section>
        <h3 className="text-lg font-semibold mb-3">설정</h3>
        <div className="rounded-lg border p-4">
          <CodeTabs code={configCode} language="javascript" />
        </div>
      </section>

      <section>
        <h3 className="text-lg font-semibold mb-3">사용 예제</h3>
        <div className="rounded-lg border p-4">
          <CodeTabs code={usageCode} language="javascript" />
        </div>
      </section>
    </div>
  );
}
