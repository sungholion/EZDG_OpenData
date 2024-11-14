// src/api/travelApi.js
import axios from 'axios';

export const api = axios.create({
 baseURL: 'https://k11d201.p.ssafy.io',
 timeout: 5000,
});

export const fetchTourData = async () => {
 const response = await api.get('/daeguTravelDB/getAllDaeguTourism');
 return response.data;
};

export const fetchHotelData = async () => {
 const response = await api.get('/daeguTravelDB/getAllDaeguAccommodation');
 return response.data;
};

export const fetchFoodData = async () => {
 const response = await api.get('/daeguTravelDB/getAllDaeguRestaurant');
 return response.data;
};