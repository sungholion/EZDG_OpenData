import axios from "axios"

const api = axios.create({
  baseURL: process.env.NEXT_PUBLIC_BASE_URL,
  timeout: 10000,
});

api.interceptors.request.use(
  (config) => {
    return config
  },
  (error) => {
    return Promise.reject(error)
  }
)

api.interceptors.response.use(
  (response) => response,
  (error) => {
    return Promise.reject(error);
  }
);

export default api