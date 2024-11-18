// import { CodeSection, type CodeExample } from "../code-example";

// const JS_EXAMPLES: CodeExample[] = [
//   {
//     title: "설치",
//     description: "npm 또는 yarn을 사용하여 패키지를 설치합니다.",
//     code: `npm install @ezdg/core

// # or with yarn
// yarn add @ezdg/core`,
//     language: "bash",
//   },
//   {
//     title: "설정",
//     description: "EZDG 인스턴스를 초기화합니다.",
//     code: `import { EZDG } from '@ezdg/core';

// // Initialize EZDG instance
// const ezdg = new EZDG({
//   apiKey: 'your-api-key'
// });`,
//     language: "javascript",
//   },
//   {
//     title: "사용 예제",
//     description: "EZDG를 사용하여 데이터를 변환합니다.",
//     code: `// Transform CSV to API
// const result = await ezdg.transform({
//   source: './data.csv',
//   type: 'api'
// });

// // Get the API endpoint
// const apiEndpoint = result.endpoint;

// // Use the API
// const response = await fetch(apiEndpoint);
// const data = await response.json();`,
//     language: "javascript",
//   },
// ];

// export function JavaScriptExample() {
//   return <CodeSection installations={JS_EXAMPLES} />;
// }
