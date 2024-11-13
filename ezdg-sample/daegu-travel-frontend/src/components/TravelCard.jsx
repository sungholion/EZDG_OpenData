// src/components/TravelCard.jsx
import React, { useState } from 'react';
import { MapPin, Phone, Globe, ArrowRight } from 'lucide-react';

const TravelCard = ({ course, activeTab }) => {
  const {
    type,
    region,
    spot,
    courseNum,
    courseDescription,
    address,
    phone,
    homepage
  } = course;

  const [isExpanded, setIsExpanded] = useState(false);

  return (
    <div className="bg-card rounded-2xl p-6 hover:shadow-xl shadow-lg transition-all duration-300 border border-gray-200">
      <div className="mb-4 flex justify-between items-start">
        <div>
          <div className="flex gap-2 mb-2">
            <span className="inline-block bg-primary-light text-primary-dark text-sm font-medium px-3 py-1 rounded-full">
              {type}
            </span>
            {activeTab === 'course' && (
              <span className="inline-block bg-primary text-white text-sm font-medium px-3 py-1 rounded-full">
                {courseNum}코스
              </span>
            )}
          </div>
          <h3 className="text-xl font-bold mb-1">{spot}</h3>
          <p className="text-gray-500 text-sm">{region}</p>
        </div>
        {activeTab === 'course' && (
          <ArrowRight className="text-primary transition-transform duration-200 group-hover:translate-x-1" />
        )}
      </div>

      <p className={`text-gray-600 text-sm mb-6 ${!isExpanded ? 'line-clamp-3' : ''}`}>
        {courseDescription}
      </p>
      {courseDescription.length > 100 && (
        <button
          onClick={() => setIsExpanded(!isExpanded)}
          className="text-primary text-sm hover:underline focus:outline-none"
        >
          {isExpanded ? '접기' : '더 보기'}
        </button>
      )}

      <div className="space-y-4 text-sm text-gray-600 mt-4">
        <div className="flex items-start gap-3">
          <div className="w-8 h-8 bg-primary-light rounded-lg flex items-center justify-center flex-shrink-0">
            <MapPin className="w-5 h-5 text-primary-dark" />
          </div>
          <span className="pt-1">{address}</span>
        </div>
        <div className="flex items-start gap-3">
          <div className="w-8 h-8 bg-primary-light rounded-lg flex items-center justify-center flex-shrink-0">
            <Phone className="w-5 h-5 text-primary-dark" />
          </div>
          <span className="pt-1">{phone}</span>
        </div>
        {homepage && homepage !== "없음" && (
          <a
            href={homepage}
            target="_blank"
            rel="noopener noreferrer"
            className="flex items-center gap-3 group"
          >
            <div className="w-8 h-8 bg-primary-light rounded-lg flex items-center justify-center flex-shrink-0">
              <Globe className="w-5 h-5 text-primary-dark" />
            </div>
            <span className="text-primary group-hover:underline pt-1">웹사이트 방문</span>
          </a>
        )}
      </div>
    </div>
  );
};

export default TravelCard;
