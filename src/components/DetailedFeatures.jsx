import React from 'react';
import './DetailedFeatures.css';

const DetailedFeatures = ({ product, onClose }) => {
  const getCategoryIcon = (category) => {
    switch (category.toLowerCase()) {
      case 'phone': return '📱';
      case 'tv': return '📺';
      case 'laptop': return '💻';
      default: return '📦';
    }
  };

  const getFeatureIcon = (featureName) => {
    const name = featureName.toLowerCase();
    if (name.includes('display') || name.includes('screen')) return '🖥️';
    if (name.includes('processor') || name.includes('cpu')) return '⚡';
    if (name.includes('camera')) return '📷';
    if (name.includes('battery')) return '🔋';
    if (name.includes('storage')) return '💾';
    if (name.includes('ram') || name.includes('memory')) return '🧠';
    if (name.includes('audio') || name.includes('speaker')) return '🔊';
    if (name.includes('connectivity') || name.includes('ports')) return '🔌';
    if (name.includes('wireless') || name.includes('wifi') || name.includes('5g')) return '📶';
    if (name.includes('os') || name.includes('platform')) return '💿';
    if (name.includes('gaming')) return '🎮';
    if (name.includes('hdr')) return '🌈';
    if (name.includes('weight')) return '⚖️';
    if (name.includes('color')) return '🎨';
    if (name.includes('biometric') || name.includes('security')) return '🔐';
    if (name.includes('charging')) return '⚡';
    if (name.includes('water')) return '💧';
    return '⭐';
  };

  const formatPrice = (price) => {
    return new Intl.NumberFormat('en-IN', {
      style: 'currency',
      currency: 'INR',
      maximumFractionDigits: 0,
    }).format(price);
  };

  return (
    <div className="detailed-features-overlay">
      <div className="detailed-features-modal">
        <div className="detailed-features-header">
          <div className="product-title">
            <span className="category-icon">{getCategoryIcon(product.category)}</span>
            <div>
              <h2>{product.name}</h2>
              <p className="product-price">{formatPrice(product.price)}</p>
            </div>
          </div>
          <button className="close-btn" onClick={onClose}>✕</button>
        </div>
        
        <div className="detailed-features-content">
          <h3>Complete Specifications</h3>
          <div className="features-grid">
            {Object.entries(product.features).map(([key, value]) => (
              <div key={key} className="feature-item">
                <div className="feature-header">
                  <span className="feature-icon">{getFeatureIcon(key)}</span>
                  <span className="feature-name">{key}</span>
                </div>
                <div className="feature-value">{value}</div>
              </div>
            ))}
          </div>
        </div>
        
        <div className="detailed-features-footer">
          <button className="btn-primary" onClick={onClose}>
            Close Details
          </button>
        </div>
      </div>
    </div>
  );
};

export default DetailedFeatures;
