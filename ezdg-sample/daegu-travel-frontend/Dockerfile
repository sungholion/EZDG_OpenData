# 1. Node.js를 사용하여 React 앱 빌드
FROM node:20.15.0 AS build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
