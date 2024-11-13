/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      fontFamily: {
        sans: ['Pretendard', 'system-ui', 'sans-serif'],
      },
      colors: {
        background: '#f3f4f6',
        card: '#ffffff',
        primary: {
          DEFAULT: '#7c3aed', // 보라색 메인 색상
          light: '#e9d5ff',   // 보라색의 밝은 버전
          dark: '#5b21b6',    // 보라색의 어두운 버전
        }
      }
    },
  },
  plugins: [],
}
