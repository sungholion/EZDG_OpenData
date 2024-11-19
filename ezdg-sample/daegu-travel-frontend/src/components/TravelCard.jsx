import React, { useState } from 'react';
import { MapPin, Phone, Globe } from 'lucide-react';

const TravelCard = ({ item, category }) => {
 const [isExpanded, setIsExpanded] = useState(false);

 const renderTourCard = (data) => (
   <>
     <h3 className="text-xl font-bold mb-1">{data.touristDestination}</h3>
     <p className="text-gray-500 text-sm mb-4">{data.region}</p>
     <div className="mb-6">
       <p className={`text-gray-600 text-sm ${!isExpanded ? 'line-clamp-3' : ''}`}>
         {data.courseDescription}
       </p>
       {data.courseDescription.length > 100 && (
         <button
           onClick={() => setIsExpanded(!isExpanded)}
           className="text-primary-dark text-sm mt-2 hover:underline focus:outline-none"
         >
           {isExpanded ? '접기' : '더 보기'}
         </button>
       )}
     </div>
     <div className="space-y-4 text-sm text-gray-600">
       <div className="flex items-start gap-3">
         <div className="w-8 h-8 bg-primary-light rounded-lg flex items-center justify-center flex-shrink-0">
           <MapPin className="w-4 h-4 text-primary-dark" />
         </div>
         <span className="pt-1">{data.address}</span>
       </div>
       {data.phoneNumber && (
         <div className="flex items-start gap-3">
           <div className="w-8 h-8 bg-primary-light rounded-lg flex items-center justify-center flex-shrink-0">
             <Phone className="w-4 h-4 text-primary-dark" />
           </div>
           <span className="pt-1">{data.phoneNumber}</span>
         </div>
       )}
       {data.homepage && data.homepage !== "없음" && (
         <button
           onClick={() => window.open(data.homepage, '_blank', 'noopener noreferrer')}
           className="flex items-center gap-3 group w-full text-left"
         >
           <div className="w-8 h-8 bg-primary-light rounded-lg flex items-center justify-center flex-shrink-0">
             <Globe className="w-4 h-4 text-primary-dark" />
           </div>
           <span className="text-primary-dark group-hover:underline pt-1">웹사이트 방문</span>
         </button>
       )}
     </div>
   </>
 );

 const renderHotelCard = (data) => (
   <>
     <h3 className="text-xl font-bold mb-1">{data.hotelName}</h3>
     <p className="text-gray-500 text-sm mb-4">{data.region}</p>
     <div className="space-y-4 text-sm text-gray-600">
       <div className="flex items-start gap-3">
         <div className="w-8 h-8 bg-primary-light rounded-lg flex items-center justify-center flex-shrink-0">
           <MapPin className="w-4 h-4 text-primary-dark" />
         </div>
         <span className="pt-1">{data.location}</span>
       </div>
       {data.phoneNumber && (
         <div className="flex items-start gap-3">
           <div className="w-8 h-8 bg-primary-light rounded-lg flex items-center justify-center flex-shrink-0">
             <Phone className="w-4 h-4 text-primary-dark" />
           </div>
           <span className="pt-1">{data.phoneNumber}</span>
         </div>
       )}
     </div>
   </>
 );

 const renderFoodCard = (data) => (
   <>
     <h3 className="text-xl font-bold mb-1">{data.businessName}</h3>
     <p className="text-gray-500 text-sm mb-4">{data.businessType}</p>
     <div className="space-y-4 text-sm text-gray-600">
       <div className="flex items-start gap-3">
         <div className="w-8 h-8 bg-primary-light rounded-lg flex items-center justify-center flex-shrink-0">
           <MapPin className="w-4 h-4 text-primary-dark" />
         </div>
         <span className="pt-1">{data.businessAddress}</span>
       </div>
     </div>
   </>
 );

 return (
   <div className="bg-white rounded-xl shadow-lg p-6 hover:shadow-xl transition-shadow">
     {category === 'tour' && renderTourCard(item)}
     {category === 'hotel' && renderHotelCard(item)}
     {category === 'food' && renderFoodCard(item)}
   </div>
 );
};

export default TravelCard;