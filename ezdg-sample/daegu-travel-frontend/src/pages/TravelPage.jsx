// src/pages/TravelPage.jsx
import React, { useState } from 'react';
import { useQuery } from '@tanstack/react-query';
import { fetchTravelCourses } from '../api/travelApi';
import TravelList from '../components/TravelList';
import TravelTabs from '../components/TravelTabs';

const TravelPage = () => {
  const [activeTab, setActiveTab] = useState('region'); 
  const [selectedRegion, setSelectedRegion] = useState('전체');
  const [selectedCourse, setSelectedCourse] = useState('대구 Best of Best');
  
  const { data: courses = [], isLoading, error } = useQuery({
    queryKey: ['travelCourses'],
    queryFn: fetchTravelCourses
  });

  if (isLoading) return (
    <div className="flex justify-center items-center min-h-screen bg-background">
      <div className="animate-spin rounded-full h-12 w-12 border-4 border-violet-200 border-t-violet-600"></div>
    </div>
  );

  if (error) return (
    <div className="flex justify-center items-center min-h-screen bg-background">
      <div className="text-red-500 bg-red-50 px-6 py-4 rounded-lg">
        에러가 발생했습니다: {error.message}
      </div>
    </div>
  );

  const filteredCourses = courses.filter(course => {
    if (activeTab === 'region') {
      return selectedRegion === '전체' ? true : course.region === selectedRegion;
    } else {
      return course.title === selectedCourse;
    }
  });

  if (activeTab === 'course') {
    filteredCourses.sort((a, b) => a.courseNum - b.courseNum);
  }

  return (
    <div className="min-h-screen bg-background px-[20%]">
      {/* 히어로 섹션 */}
      <div className="py-16">
        <div className="container mx-auto text-center">
          <h1 className="text-5xl font-bold mb-4">
            대구 여행의 모든 것
          </h1>
          <p className="text-gray-600 max-w-2xl mx-auto">
          역사와 현대가 어우러진 대구에서 잊지 못할 여행을 시작해보세요. 전통이 숨 쉬는 골목길부터 
  트렌디한 핫플레이스까지, 대구가 품은 특별한 이야기와 숨겨진 명소들을 만나보세요. 당신만의 
  여행을 만들어줄 맞춤형 추천 코스와 다양한 정보가 준비되어 있습니다.
          </p>

          {/* 총계 섹션 */}
          <div className="flex justify-center gap-8 mt-12">
            <div className="text-center">
              <div className="text-3xl font-bold text-violet-600">8</div>
              <div className="text-gray-600">지역</div>
            </div>
            <div className="text-center">
              <div className="text-3xl font-bold text-violet-600">{courses.length}</div>
              <div className="text-gray-600">여행코스</div>
            </div>
            <div className="text-center">
              <div className="text-3xl font-bold text-violet-600">30+</div>
              <div className="text-gray-600">관광명소</div>
            </div>
          </div>
        </div>
      </div>

      {/* 메인 콘텐츠 */}
      <div className="container mx-auto py-8">
        <TravelTabs 
          activeTab={activeTab}
          setActiveTab={setActiveTab}
          selectedRegion={selectedRegion}
          setSelectedRegion={setSelectedRegion}
          selectedCourse={selectedCourse}
          setSelectedCourse={setSelectedCourse}
          courses={courses}
        />
        <TravelList 
          courses={filteredCourses} 
          activeTab={activeTab}
        />
      </div>
    </div>
  );
};

export default TravelPage;
