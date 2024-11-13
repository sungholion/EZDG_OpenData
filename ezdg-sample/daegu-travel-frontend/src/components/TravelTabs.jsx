// src/components/TravelTabs.jsx
import React from 'react';

const TravelTabs = ({ 
  activeTab, 
  setActiveTab, 
  selectedRegion, 
  setSelectedRegion,
  selectedCourse,
  setSelectedCourse,
  courses 
}) => {
  const regions = ['전체', '중구', '동구', '서구', '남구', '북구', '수성구', '달서구', '달성군'];
  const uniqueCourses = [...new Set(courses.map(course => course.title))];

  return (
    <div className="mb-12">
      {/* 탭 버튼 */}
      <div className="flex gap-4 mb-8">
        <button
          onClick={() => setActiveTab('region')}
          className={`px-6 py-3 rounded-lg font-medium transition-all ${
            activeTab === 'region'
              ? 'bg-primary text-white shadow-lg shadow-primary-light'
              : 'bg-white text-gray-600 hover:bg-primary-light border border-gray-100'
          }`}
        >
          지역별 보기
        </button>
        <button
          onClick={() => setActiveTab('course')}
          className={`px-6 py-3 rounded-lg font-medium transition-all ${
            activeTab === 'course'
              ? 'bg-primary text-white shadow-lg shadow-primary-light'
              : 'bg-white text-gray-600 hover:bg-primary-light border border-gray-100'
          }`}
        >
          코스별 보기
        </button>
      </div>

      {/* 필터 버튼 */}
      <div className="flex flex-wrap gap-3">
        {activeTab === 'region' ? (
          regions.map((region) => (
            <button
              key={region}
              onClick={() => setSelectedRegion(region)}
              className={`
                px-6 py-3 rounded-lg font-medium transition-all
                ${selectedRegion === region 
                  ? 'bg-primary-light text-primary-dark shadow-md' 
                  : 'bg-white text-gray-600 hover:bg-primary-light border border-gray-100'}
              `}
            >
              {region}
            </button>
          ))
        ) : (
          uniqueCourses.map((course) => (
            <button
              key={course}
              onClick={() => setSelectedCourse(course)}
              className={`
                px-6 py-3 rounded-lg font-medium transition-all
                ${selectedCourse === course 
                  ? 'bg-primary-light text-primary-dark shadow-md' 
                  : 'bg-white text-gray-600 hover:bg-primary-light border border-gray-100'}
              `}
            >
              {course}
            </button>
          ))
        )}
      </div>
    </div>
  );
};

export default TravelTabs;
