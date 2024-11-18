// src/components/RegionFilter.jsx
import React from 'react';

const RegionFilter = ({ selectedRegion, setSelectedRegion, activeCategory, items }) => {
  // 맛집 카테고리일 때는 비즈니스 타입으로 필터 생성
  const getFilterOptions = () => {
    if (activeCategory === 'food') {
      const uniqueTypes = ['전체', ...new Set(items.map(item => item.businessStatus))];
      return uniqueTypes.filter(type => type); // null, undefined 제거
    }
    // 관광, 숙박은 기존 지역 필터 사용
    return ['전체', '중구', '동구', '서구', '남구', '북구', '수성구', '달서구', '달성군'];
  };

  const filterOptions = getFilterOptions();

  return (
    <div className="mb-8">
      <h2 className="text-lg font-medium mb-4">
        {activeCategory === 'food' ? '업종별 보기' : '지역별 보기'}
      </h2>
      <div className="flex flex-wrap gap-3">
        {filterOptions.map((option) => (
          <button
            key={option}
            onClick={() => setSelectedRegion(option)}
            className={`
              px-6 py-3 rounded-lg font-medium transition-all
              ${selectedRegion === option 
                ? 'bg-primary-light text-primary-dark shadow-md' 
                : 'bg-white text-gray-600 hover:bg-primary-light border border-gray-100'}
            `}
          >
            {option}
          </button>
        ))}
      </div>
    </div>
  );
};

export default RegionFilter;