import React, { useState } from 'react';
import DetailedFeatures from './DetailedFeatures';

const ProductCard = ({ product, isSelected, onSelect }) => {
  const [showDetails, setShowDetails] = useState(false);
  // Determine icon based on product type
  const getProductIcon = (productName) => {
    if (productName.toLowerCase().includes('tv')) return '📺';
    if (productName.toLowerCase().includes('macbook') || 
        productName.toLowerCase().includes('laptop') ||
        productName.toLowerCase().includes('thinkpad') ||
        productName.toLowerCase().includes('surface') ||
        productName.toLowerCase().includes('xps') ||
        productName.toLowerCase().includes('spectre') ||
        productName.toLowerCase().includes('zephyrus')) return '💻';
    return '📱'; // default for phones
  };

  return (
    <div className={`product-card ${isSelected ? 'selected' : ''}`}>
      <div className="product-image">
        {getProductIcon(product.name)}
      </div>
      
      <div className="product-info">
        <h3 className="product-name">{product.name}</h3>
        <div className="product-price">₹{product.price.toLocaleString('en-IN')}</div>
        
        <ul className="product-features">
          {Object.entries(product.features).slice(0, 4).map(([key, value]) => (
            <li key={key}>
              <span className="feature-name">{key}:</span>
              <span className="feature-value">{value}</span>
            </li>
          ))}
        </ul>
        
        <div className="selection-controls">
          <div className="card-actions">
            <button 
              className="details-btn"
              onClick={() => setShowDetails(true)}
            >
              View Details
            </button>
            <button 
              className={`select-btn ${isSelected ? 'selected' : ''}`}
              onClick={() => onSelect(product)}
            >
              {isSelected ? 'Selected ✓' : 'Select'}
            </button>
          </div>
        </div>
        
        {isSelected && (
          <div className="selection-badge">
            ✓
          </div>
        )}
      </div>
      
      {showDetails && (
        <DetailedFeatures 
          product={product} 
          onClose={() => setShowDetails(false)} 
        />
      )}
    </div>
  );
};

export default ProductCard;
