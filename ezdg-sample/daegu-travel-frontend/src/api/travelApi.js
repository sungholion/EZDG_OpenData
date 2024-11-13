import axios from 'axios';

export const api = axios.create({
  baseURL: 'http://localhost:8080', // 백엔드 서버 주소
  timeout: 5000,
});

export const fetchTravelCourses = async () => {
  const response = await api.get('/daeguTravel/getAllDaeguTravel');
  return response.data;
};