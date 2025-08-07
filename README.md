# Product Comparison App - Full Stack

A modern full-stack web application for comparing products across different categories with authentication, built using React.js frontend and Spring Boot backend with MySQL database.

## 🚀 Features

### Frontend (React.js)
- **User Authentication**: Login/Register with JWT token-based authentication
- **Product Catalog**: Browse 18+ products across 3 categories (Phones, TVs, Laptops)
- **Category Filtering**: Filter products by category with visual indicators
- **Product Comparison**: Side-by-side comparison of up to 4 products
- **Indian Rupee Pricing**: All prices displayed in ₹ with proper formatting
- **Responsive Design**: Modern UI that works on all devices
- **Real-time Updates**: Dynamic product selection and comparison

### Backend (Spring Boot)
- **RESTful API**: Complete REST API for products and authentication
- **JWT Security**: Secure authentication with JSON Web Tokens
- **MySQL Database**: Persistent data storage with JPA/Hibernate
- **Role-based Access**: User and Admin role management
- **CORS Configuration**: Proper cross-origin resource sharing setup
- **Data Initialization**: Automatic database seeding with sample data

## 🏗️ Project Structure

```
projectspring/
├── frontend/                    # React.js Frontend
│   ├── public/
│   │   ├── index.html
│   │   └── manifest.json
│   ├── src/
│   │   ├── components/
│   │   │   ├── Header.jsx       # Navigation header
│   │   │   ├── Login.jsx        # Login form
│   │   │   ├── Register.jsx     # Registration form
│   │   │   ├── ProductList.jsx  # Product listing with filters
│   │   │   ├── ProductCard.jsx  # Individual product card
│   │   │   └── ComparisonView.jsx # Product comparison table
│   │   ├── context/
│   │   │   └── AuthContext.js   # Authentication context
│   │   ├── services/
│   │   │   ├── api.js           # Axios configuration
│   │   │   ├── authService.js   # Authentication API calls
│   │   │   └── productService.js # Product API calls
│   │   ├── App.jsx              # Main application component
│   │   ├── App.css              # Application styles
│   │   └── index.js             # Application entry point
│   └── package.json             # Frontend dependencies
│
└── backend/                     # Spring Boot Backend
    ├── src/main/java/com/productcomparison/
    │   ├── controller/
    │   │   ├── AuthController.java      # Authentication endpoints
    │   │   └── ProductController.java   # Product CRUD endpoints
    │   ├── entity/
    │   │   ├── User.java               # User entity
    │   │   ├── Role.java               # Role entity
    │   │   ├── Product.java            # Product entity
    │   │   └── ERole.java              # Role enum
    │   ├── repository/
    │   │   ├── UserRepository.java     # User data access
    │   │   ├── RoleRepository.java     # Role data access
    │   │   └── ProductRepository.java  # Product data access
    │   ├── security/
    │   │   ├── JwtUtils.java           # JWT token utilities
    │   │   ├── UserDetailsImpl.java    # User details implementation
    │   │   ├── AuthTokenFilter.java    # JWT authentication filter
    │   │   └── AuthEntryPointJwt.java  # JWT entry point
    │   ├── service/
    │   │   ├── ProductService.java     # Product business logic
    │   │   └── DataInitializationService.java # Database seeding
    │   ├── dto/
    │   │   ├── LoginRequest.java       # Login request DTO
    │   │   ├── SignupRequest.java      # Signup request DTO
    │   │   ├── JwtResponse.java        # JWT response DTO
    │   │   └── MessageResponse.java    # Generic message DTO
    │   ├── config/
    │   │   └── WebSecurityConfig.java  # Security configuration
    │   └── ProductComparisonApplication.java # Main application class
    ├── src/main/resources/
    │   └── application.properties      # Application configuration
    └── pom.xml                         # Backend dependencies
```

## 🛠️ Technologies Used

### Frontend
- **React.js 18** - Modern JavaScript library for building user interfaces
- **Axios** - HTTP client for API requests
- **Context API** - State management for authentication
- **CSS3** - Modern styling with flexbox and grid
- **Responsive Design** - Mobile-first approach

### Backend
- **Spring Boot 3.2** - Java framework for building REST APIs
- **Spring Security** - Authentication and authorization
- **Spring Data JPA** - Data persistence layer
- **JWT (JSON Web Tokens)** - Stateless authentication
- **MySQL 8** - Relational database
- **Maven** - Dependency management and build tool

## 🚀 Getting Started

### Prerequisites
- **Java 17** or higher
- **Node.js 16** or higher
- **MySQL 8** or higher
- **Maven 3.6** or higher

### Database Setup
1. Install MySQL and create a database:
   ```sql
   CREATE DATABASE product_comparison_db;
   ```

2. Update database credentials in `backend/src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

### Backend Setup
1. Navigate to the backend directory:
   ```bash
   cd backend
   ```

2. Install dependencies and run:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. Backend will start on `http://localhost:8080`

### Frontend Setup
1. Navigate to the frontend directory:
   ```bash
   cd ..
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   npm start
   ```

4. Frontend will start on `http://localhost:3001`

## 🔐 Authentication

### Demo Credentials
- **Email**: demo@example.com
- **Password**: demo123

### API Endpoints

#### Authentication
- `POST /api/auth/signin` - User login
- `POST /api/auth/signup` - User registration
- `POST /api/auth/signout` - User logout

#### Products
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `GET /api/products/category/{category}` - Get products by category
- `GET /api/products/search?name={name}` - Search products by name
- `GET /api/products/price-range?minPrice={min}&maxPrice={max}` - Filter by price
- `GET /api/products/categories` - Get all categories

## 💰 Product Categories & Pricing

### 📱 Phones (8 products)
- iPhone 14 Pro - ₹82,999
- Samsung Galaxy S23 - ₹74,999
- Google Pixel 7 - ₹58,999
- OnePlus 11 - ₹62,999
- iPhone 13 - ₹58,999
- Xiaomi 13 - ₹54,999
- Samsung Galaxy A54 - ₹37,999
- Nothing Phone 2 - ₹49,999

### 📺 TVs (4 products)
- Samsung 55" QLED 4K TV - ₹1,08,999
- LG 65" OLED 4K TV - ₹1,59,999
- Sony 50" LED 4K TV - ₹74,999
- TCL 43" QLED 4K TV - ₹54,999

### 💻 Laptops (6 products)
- MacBook Pro 14" - ₹1,69,999
- Dell XPS 13 - ₹1,08,999
- HP Spectre x360 - ₹95,999
- ASUS ROG Zephyrus G14 - ₹1,34,999
- Lenovo ThinkPad X1 Carbon - ₹1,17,999
- Microsoft Surface Laptop 5 - ₹1,08,999

## 🎯 How to Use

1. **Register/Login**: Create an account or use demo credentials
2. **Browse Products**: View products by category or see all
3. **Select Products**: Click "Select" button on products to compare
4. **Compare**: Switch to comparison view to see detailed comparison
5. **Filter**: Use category filters to find specific types of products
6. **Logout**: Securely logout when done

## 🔧 Configuration

### Backend Configuration (`application.properties`)
```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/product_comparison_db
spring.datasource.username=root
spring.datasource.password=password

# JWT
app.jwt.secret=productComparisonSecretKey2024
app.jwt.expiration=86400000

# CORS
app.cors.allowed-origins=http://localhost:3001
```

### Frontend Configuration (`src/services/api.js`)
```javascript
const API_BASE_URL = 'http://localhost:8080/api';
```

## 🚀 Deployment

### Backend Deployment
1. Build the JAR file:
   ```bash
   mvn clean package
   ```

2. Run the JAR:
   ```bash
   java -jar target/product-comparison-backend-0.0.1-SNAPSHOT.jar
   ```

### Frontend Deployment
1. Build for production:
   ```bash
   npm run build
   ```

2. Deploy the `build` folder to your web server

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## 📝 License

This project is licensed under the MIT License.

## 🆘 Support

For support and questions, please open an issue in the repository.

---

**Built with ❤️ using React.js, Spring Boot, and MySQL**
