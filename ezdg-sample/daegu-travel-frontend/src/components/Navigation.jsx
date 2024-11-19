import React from 'react';

const Navigation = ({ activeCategory, setActiveCategory }) => {
  const categories = [
    { id: 'tour', name: '관광' },
    { id: 'hotel', name: '숙박' },
    { id: 'food', name: '맛집' },
  ];

  return (
    <nav className="bg-white border-b">
      <div className="container mx-auto px-4">
        <div className="flex items-center h-16">
          <h1 className="text-xl font-bold mr-12">대구의 모든것</h1>
          <div className="flex gap-8">
            {categories.map((category) => (
              <button
                key={category.id}
                onClick={() => setActiveCategory(category.id)}
                className={`font-medium transition-colors focus:outline-none  ${
                  activeCategory === category.id
                    ? 'text-primary border-b-2 border-primary'
                    : 'text-gray-600 hover:text-primary'
                }`}
              >
                {category.name}
              </button>
            ))}
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navigation;