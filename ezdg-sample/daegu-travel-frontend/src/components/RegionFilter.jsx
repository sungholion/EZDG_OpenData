// src/components/RegionFilter.jsx
import React from 'react';

const RegionFilter = ({ selectedRegion, onRegionChange }) => {
  const regions = ['전체', '중구', '동구', '서구', '남구', '북구', '수성구', '달서구', '달성군'];

  return (
    <div className="flex flex-wrap gap-3">
      {regions.map((region) => (
        <button
          key={region}
          onClick={() => onRegionChange(region)}
          className={`
            px-6 py-3 rounded-xl font-medium transition-all
            ${selectedRegion === region 
              ? 'bg-violet-600 text-white shadow-lg shadow-violet-200' 
              : 'bg-white text-gray-600 hover:bg-violet-50 border border-gray-100'}
          `}
        >
          {region}
        </button>
      ))}
    </div>
  );
};

export default RegionFilter;