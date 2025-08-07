import React from 'react';

const ComparisonView = ({ selectedProducts, onRemoveProduct }) => {
  if (selectedProducts.length === 0) {
    return (
      <div className="empty-comparison">
        <h2>No Products Selected</h2>
        <p>Go back to the product list and select products to compare</p>
      </div>
    );
  }

  // Get all unique features from selected products
  const allFeatures = [...new Set(
    selectedProducts.flatMap(product => Object.keys(product.features))
  )];

  return (
    <div>
      <div className="text-center mb-20">
        <h2>Product Comparison</h2>
        <p>Compare features and prices side by side</p>
      </div>

      <div className="comparison-table">
        <div className="comparison-grid">
          {/* Header row */}
          <div className="comparison-cell feature-label">Product</div>
          {selectedProducts.map(product => (
            <div key={product.id} className="comparison-cell product-header">
              <div className="product-name">{product.name}</div>
              <div className="product-price">₹{product.price.toLocaleString('en-IN')}</div>
              <button 
                className="remove-btn"
                onClick={() => onRemoveProduct(product)}
              >
                Remove
              </button>
            </div>
          ))}

          {/* Price row */}
          <div className="comparison-cell feature-label">Price</div>
          {selectedProducts.map(product => (
            <div key={`${product.id}-price`} className="comparison-cell">
              <strong>₹{product.price.toLocaleString('en-IN')}</strong>
            </div>
          ))}

          {/* Feature rows */}
          {allFeatures.map(feature => (
            <React.Fragment key={feature}>
              <div className="comparison-cell feature-label">{feature}</div>
              {selectedProducts.map(product => (
                <div key={`${product.id}-${feature}`} className="comparison-cell">
                  {product.features[feature] || 'N/A'}
                </div>
              ))}
            </React.Fragment>
          ))}
        </div>
      </div>
    </div>
  );
};

export default ComparisonView;
