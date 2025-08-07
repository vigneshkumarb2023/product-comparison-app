import React, { useState, useEffect } from 'react';
import './App.css';
import Header from './components/Header';
import ProductList from './components/ProductList';
import ComparisonView from './components/ComparisonView';
import Login from './components/Login';
import Register from './components/Register';
import { AuthProvider, useAuth } from './context/AuthContext';
import productService from './services/productService';
import { mockProducts } from './data/mockData';

const MainApp = () => {
  const { user, login, register, logout, isAuthenticated, isLoading } = useAuth();
  const [products, setProducts] = useState([]);
  const [selectedProducts, setSelectedProducts] = useState([]);
  const [currentView, setCurrentView] = useState('list'); // 'list' or 'compare'
  const [selectedCategory, setSelectedCategory] = useState('All'); // 'All', 'Phone', 'TV', 'Laptop'
  const [authView, setAuthView] = useState('login'); // 'login' or 'register'

  useEffect(() => {
    // Load products from backend API with fallback to mock data
    const fetchProducts = async () => {
      try {
        const productsData = await productService.getAllProducts();
        setProducts(productsData);
        // Auto-select first 2 products for demonstration
        if (productsData.length >= 2) {
          setSelectedProducts([productsData[0], productsData[1]]);
        }
      } catch (error) {
        console.error('Backend not available, using mock data:', error);
        // Fallback to mock data if backend API fails
        setProducts(mockProducts);
        // Auto-select first 2 products for demonstration
        setSelectedProducts([mockProducts[0], mockProducts[1]]);
      }
    };
    
    fetchProducts();
  }, []);

  const handleProductSelect = (product) => {
    if (selectedProducts.find(p => p.id === product.id)) {
      // Remove if already selected
      setSelectedProducts(selectedProducts.filter(p => p.id !== product.id));
    } else if (selectedProducts.length < 4) {
      // Add if less than 4 products selected
      setSelectedProducts([...selectedProducts, product]);
    } else {
      alert('You can compare up to 4 products at a time');
    }
  };

  const clearSelection = () => {
    setSelectedProducts([]);
  };

  const switchView = (view) => {
    setCurrentView(view);
  };

  const handleCategoryChange = (category) => {
    setSelectedCategory(category);
  };

  // Filter products based on selected category
  const filteredProducts = selectedCategory === 'All' 
    ? products 
    : products.filter(product => product.category === selectedCategory);

  if (isLoading) {
    return (
      <div className="loading-container">
        <div className="loading-spinner"></div>
        <p>Loading...</p>
      </div>
    );
  }

  if (!isAuthenticated) {
    return (
      <div className="App">
        {authView === 'login' ? (
          <Login 
            onLogin={login}
            onSwitchToRegister={() => setAuthView('register')}
          />
        ) : (
          <Register 
            onRegister={register}
            onSwitchToLogin={() => setAuthView('login')}
          />
        )}
      </div>
    );
  }

  return (
    <div className="App">
      <Header 
        selectedCount={selectedProducts.length}
        onViewChange={switchView}
        currentView={currentView}
        onClearSelection={clearSelection}
        user={user}
        onLogout={logout}
      />
      
      <div className="container">
        {currentView === 'list' ? (
          <ProductList 
            products={filteredProducts}
            selectedProducts={selectedProducts}
            onProductSelect={handleProductSelect}
            selectedCategory={selectedCategory}
            onCategoryChange={handleCategoryChange}
          />
        ) : (
          <ComparisonView 
            selectedProducts={selectedProducts}
            onRemoveProduct={handleProductSelect}
          />
        )}
      </div>
    </div>
  );
};

function App() {
  return (
    <AuthProvider>
      <MainApp />
    </AuthProvider>
  );
}

export default App;
