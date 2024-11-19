import React, { useState, useEffect } from 'react';
import { useQuery } from '@tanstack/react-query';
import Navigation from '../components/Navigation';
import RegionFilter from '../components/RegionFilter';
import TravelList from '../components/TravelList';
import { fetchTourData, fetchHotelData, fetchFoodData } from '../api/travelApi';
import { MapPin, Hotel, UtensilsCrossed } from 'lucide-react';

const TravelPage = () => {
  const [activeCategory, setActiveCategory] = useState('tour');
  const [selectedRegion, setSelectedRegion] = useState('전체');

  const { data: items = [], isLoading } = useQuery({
    queryKey: [activeCategory],
    queryFn: () => {
      switch (activeCategory) {
        case 'tour':
          return fetchTourData();
        case 'hotel':
          return fetchHotelData();
        case 'food':
          return fetchFoodData();
        default:
          return [];
      }
    }
  });

  const handleCategoryChange = (category) => {
    setActiveCategory(category);
    setSelectedRegion('전체');
  };

  const getFilteredItems = () => {
    if (selectedRegion === '전체') return items;

    return items.filter(item => {
      switch (activeCategory) {
        case 'tour':
          return item.region === selectedRegion;
        case 'hotel':
          return item.region === selectedRegion;
        case 'food':
          return item.businessStatus === selectedRegion;
        default:
          return false;
      }
    });
  };

  const getCategoryContent = () => {
    switch (activeCategory) {
      case 'tour':
        return {
          icon: <MapPin className="w-8 h-8 text-primary" />,
          title: "대구의 명소",
          description: "대구의 역사와 현재가 공존하는 특별한 관광지를 만나보세요.",
          stats: [
            { value: `${items.length}+`, label: "관광 명소" },
            { value: "8+", label: "지역" },
            { value: "4+", label: "테마" }
          ]
        };
      case 'hotel':
        return {
          icon: <Hotel className="w-8 h-8 text-primary" />,
          title: "대구의 숙소",
          description: "편안한 휴식과 특별한 경험을 선사할 대구의 숙소를 찾아보세요.",
          stats: [
            { value: `${items.length}+`, label: "숙박 시설" },
            { value: "8+", label: "지역" },
            { value: "3+", label: "유형" }
          ]
        };
      case 'food':
        return {
          icon: <UtensilsCrossed className="w-8 h-8 text-primary" />,
          title: "대구의 맛집",
          description: "대구의 특색있는 맛집들을 만나보세요.",
          stats: [
            { value: `${items.length}+`, label: "맛집" },
            { value: "10+", label: "음식 종류" },
            { value: "8+", label: "지역" }
          ]
        };
      default:
        return {};
    }
  };

  const useCountUp = (end, duration = 300, shouldAnimate) => {
    const [count, setCount] = useState(shouldAnimate ? 0 : end);
  
    useEffect(() => {
      if (!shouldAnimate) {
        setCount(end);
        return;
      }
  
      let startTimestamp = null;
      const step = (timestamp) => {
        if (!startTimestamp) startTimestamp = timestamp;
        const progress = Math.min((timestamp - startTimestamp) / duration, 1);
        setCount(Math.floor(progress * end));
        
        if (progress < 1) {
          window.requestAnimationFrame(step);
        } else {
          setCount(end);
        }
      };
      
      window.requestAnimationFrame(step);
    }, [end, duration, shouldAnimate]);
  
    return count;
  };
  
  const AnimatedStat = ({ value, label, shouldAnimate }) => {
    const numericValue = parseInt(value);
    const animatedValue = useCountUp(
      isNaN(numericValue) ? 0 : numericValue,
      1000,
      shouldAnimate
    );
  
    return (
      <div className="text-center">
        <div className="text-2xl md:text-3xl font-bold text-primary mb-1">
          {animatedValue}+
        </div>
        <div className="text-sm text-gray-600">
          {label}
        </div>
      </div>
    );
  };

  if (isLoading) return (
    <div className="flex justify-center items-center min-h-screen">
      <div className="animate-spin rounded-full h-12 w-12 border-4 border-primary border-t-transparent"></div>
    </div>
  );

  const filteredItems = getFilteredItems();
  const content = getCategoryContent();

  return (
    <div className="min-h-screen bg-background">
      <Navigation 
        activeCategory={activeCategory} 
        setActiveCategory={handleCategoryChange}
      />
      
      {/* 히어로 섹션 */}
      <div className="bg-gradient-to-b from-primary-light/30 to-background border-b border-primary-light/20">
        <div className="container mx-auto px-4 lg:px-[20%] py-12">
          <div className="flex flex-col items-center text-center">
            <div className="flex items-center gap-3 mb-4">
              {content.icon}
              <h1 className="text-3xl md:text-4xl font-bold text-gray-800">
                {content.title}
              </h1>
            </div>
            <p className="text-lg text-gray-600 mb-8 max-w-2xl">
              {content.description}
            </p>
            <div className="flex justify-center gap-16">
              {content.stats?.map((stat, idx) => (
                <AnimatedStat 
                  key={`${activeCategory}-${idx}`} 
                  value={stat.value.replace('+', '')} 
                  label={stat.label}
                  shouldAnimate={selectedRegion === '전체'}
                />
              ))}
            </div>
          </div>
        </div>
      </div>

      {/* 메인 콘텐츠 */}
      <div className="container mx-auto px-4 lg:px-[20%] py-8">
        <RegionFilter 
          selectedRegion={selectedRegion}
          setSelectedRegion={setSelectedRegion}
          activeCategory={activeCategory}
          items={items}
        />
        <TravelList 
          items={filteredItems}
          category={activeCategory}
        />
      </div>
    </div>
  );
};

export default TravelPage;