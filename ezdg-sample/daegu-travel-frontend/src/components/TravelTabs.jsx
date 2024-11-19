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
 
 // 새로운 데이터 구조에 맞게 수정
 const uniqueCourses = [...new Set(courses.map(course => course.courseTitle))].filter(Boolean);
 
 // 각 코스의 설명 정보를 가져오는 함수
 const getCourseDescription = (courseTitle) => {
   const course = courses.find(c => c.courseTitle === courseTitle);
   return course?.courseTopic || '';
 };

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
     <div className="space-y-6">
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
           uniqueCourses.map((courseTitle) => (
             <div key={courseTitle} className="flex flex-col w-full">
               <button
                 onClick={() => setSelectedCourse(courseTitle)}
                 className={`
                   px-6 py-3 rounded-lg font-medium transition-all w-full
                   ${selectedCourse === courseTitle 
                     ? 'bg-primary-light text-primary-dark shadow-md' 
                     : 'bg-white text-gray-600 hover:bg-primary-light border border-gray-100'}
                 `}
               >
                 <div className="flex flex-col items-start gap-1">
                   <span className="text-base">{courseTitle}</span>
                   <span className="text-sm text-gray-500 font-normal">
                     {getCourseDescription(courseTitle)}
                   </span>
                 </div>
               </button>
             </div>
           ))
         )}
       </div>
       
       {/* 선택된 코스 설명 */}
       {activeTab === 'course' && selectedCourse && (
         <div className="bg-white/50 backdrop-blur-sm p-4 rounded-lg">
           <p className="text-sm text-gray-600">
             {getCourseDescription(selectedCourse)}
           </p>
         </div>
       )}
     </div>
   </div>
 );
};

export default TravelTabs;