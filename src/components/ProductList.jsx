import React from 'react';
import ProductCard from './ProductCard';

const ProductList = ({ products, selectedProducts, onProductSelect, selectedCategory, onCategoryChange }) => {
  const categories = ['All', 'Phone', 'TV', 'Laptop'];
  
  // Import mockProducts to get full product list for counting
  const { mockProducts } = require('../data/mockData');
  
  const getCategoryCount = (category) => {
    if (category === 'All') return mockProducts.length;
    return mockProducts.filter(product => product.category === category).length;
  };
  
  return (
    <div>
      <div className="text-center mb-20">
        <h2>Select Products to Compare</h2>
        <p>Click the "Select" button on products to add them to comparison (max 4 products)</p>
        
        {/* Category Filter Buttons */}
        <div className="category-filters">
          {categories.map(category => (
            <button
              key={category}
              className={`category-btn ${selectedCategory === category ? 'active' : ''}`}
              onClick={() => onCategoryChange(category)}
            >
              {category === 'All' ? `All Products (${getCategoryCount(category)})` : 
               category === 'Phone' ? `📱 Phones (${getCategoryCount(category)})` :
               category === 'TV' ? `📺 TVs (${getCategoryCount(category)})` :
               `💻 Laptops (${getCategoryCount(category)})`}
            </button>
          ))}
        </div>
        {selectedProducts.length > 0 && (
          <div className="selection-status">
            <strong>{selectedProducts.length} product{selectedProducts.length !== 1 ? 's' : ''} selected:</strong>
            {selectedProducts.map(product => (
              <span key={product.id} className="selected-product-tag">
                {product.name}
              </span>
            ))}
          </div>
        )}
      </div>
      
      {/* Current Category Display */}
      <div className="current-category">
        <h3>
          {selectedCategory === 'All' ? 
            `Showing All Products (${products.length})` :
            `Showing ${selectedCategory === 'Phone' ? '📱 Phones' : 
                      selectedCategory === 'TV' ? '📺 TVs' : 
                      '💻 Laptops'} (${products.length})`
          }
        </h3>
      </div>
      
      <div className="product-grid">
        {products.map(product => (
          <ProductCard
            key={product.id}
            product={product}
            isSelected={selectedProducts.some(p => p.id === product.id)}
            onSelect={() => onProductSelect(product)}
          />
        ))}
      </div>
    </div>
  );
};

export default ProductList;
