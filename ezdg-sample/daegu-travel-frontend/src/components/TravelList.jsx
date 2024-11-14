// src/components/TravelList.jsx
import React from 'react';
import TravelCard from './TravelCard';

const TravelList = ({ items, category }) => {
  if (!items || items.length === 0) {
    return (
      <div className="text-center py-12">
        <p className="text-gray-600">해당하는 정보가 없습니다.</p>
      </div>
    );
  }

  return (
    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
      {items.map((item, index) => (
        <TravelCard 
          key={`${category}-${item.id}-${index}`}  // 카테고리와 인덱스를 포함한 고유한 키 생성
          item={item} 
          category={category}
        />
      ))}
    </div>
  );
};

export default TravelList;