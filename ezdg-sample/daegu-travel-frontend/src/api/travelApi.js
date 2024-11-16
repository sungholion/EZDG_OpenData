// src/api/travelApi.js
import axios from "axios";

export const api = axios.create({
  baseURL: "43.202.254.160:8080",
  timeout: 5000,
});

export const fetchTourData = async () => {
  const response = await api.get("/daeguTravelDB/getAllDaeguTourism");
  return response.data;
};

export const fetchHotelData = async () => {
  const response = await api.get("/daeguTravelDB/getAllDaeguAccommodation");
  return response.data;
};

export const fetchFoodData = async () => {
  const response = await api.get("/daeguTravelDB/getAllDaeguRestaurant");
  return response.data;
};
