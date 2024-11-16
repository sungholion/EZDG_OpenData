# 1. Node.js를 사용하여 React 앱 빌드
FROM node:20.15.0 as build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# 2. Nginx를 사용하여 정적 파일 서빙
FROM nginx:1.25
COPY --from=build-stage /app/build /usr/share/nginx/html
COPY /home/ubuntu/docker-files/default.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
