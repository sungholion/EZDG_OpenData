// src/components/TravelList.jsx
import React from 'react';
import TravelCard from './TravelCard';

const TravelList = ({ courses }) => {
  if (courses.length === 0) {
    return (
      <div className="text-center py-12">
        <p className="text-gray-600">해당 지역의 여행 코스가 없습니다.</p>
      </div>
    );
  }

  return (
    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
      {courses.map((course) => (
        <TravelCard key={course.id} course={course} />
      ))}
    </div>
  );
};

export default TravelList;