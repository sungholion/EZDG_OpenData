// src/api/travelApi.js
import axios from "axios";

export const api = axios.create({
  baseURL: "http://localhost:8080",
  timeout: 5000,
});

export const fetchTourData = async () => {
  const response = await api.get("/daeguTravelDB/getAllDaeguTourismAll");
  return response.data;
};

export const fetchHotelData = async () => {
  const response = await api.get("/daeguTravelDB/getAllDaeguAccommodationAll");
  return response.data;
};

export const fetchFoodData = async () => {
  const response = await api.get("/daeguTravelDB/getAllDaeguRestaurantAll");
  return response.data;
};
