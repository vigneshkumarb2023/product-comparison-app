import React from 'react';

const Header = ({ selectedCount, onViewChange, currentView, onClearSelection, user, onLogout }) => {
  return (
    <header className="header">
      <div className="header-content">
        <h1>Product Comparison App</h1>
        
        <div className="header-controls">
          {user && (
            <div className="user-info">
              <span className="user-greeting">Welcome, {user.name}!</span>
            </div>
          )}
          
          <div className="selected-count">
            {selectedCount} product{selectedCount !== 1 ? 's' : ''} selected
          </div>
          
          <div className="view-toggle">
            <button 
              className={currentView === 'list' ? 'active' : ''}
              onClick={() => onViewChange('list')}
            >
              Product List
            </button>
            <button 
              className={currentView === 'compare' ? 'active' : ''}
              onClick={() => onViewChange('compare')}
              disabled={selectedCount === 0}
            >
              Compare ({selectedCount})
            </button>
          </div>
          
          {selectedCount > 0 && (
            <button 
              className="btn btn-secondary"
              onClick={onClearSelection}
            >
              Clear Selection
            </button>
          )}
          
          {user && (
            <button 
              className="btn btn-logout"
              onClick={onLogout}
            >
              Logout
            </button>
          )}
        </div>
      </div>
    </header>
  );
};

export default Header;
