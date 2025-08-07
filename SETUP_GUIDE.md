# Complete Setup Guide - Product Comparison App

This guide will help you set up the full-stack Product Comparison App with both frontend and backend components.

## 🎯 Quick Start (Frontend Only)

If you want to quickly see the app in action with mock data:

1. **Install Node.js dependencies:**
   ```bash
   npm install
   ```

2. **Start the frontend:**
   ```bash
   npm start
   ```

3. **Open your browser:**
   - The app will run on `http://localhost:3001`
   - All features work with mock data (18 products, authentication simulation)

## 🚀 Full Stack Setup (Frontend + Backend + Database)

### Prerequisites

- **Java 17+** (for Spring Boot backend)
- **Node.js 16+** (for React frontend)
- **MySQL 8+** (for database)
- **Maven 3.6+** (for building backend)

### Step 1: Database Setup

1. **Install MySQL 8+** and start the MySQL service

2. **Create database:**
   ```sql
   CREATE DATABASE product_comparison_db;
   ```

3. **Create MySQL user (optional):**
   ```sql
   CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'apppassword';
   GRANT ALL PRIVILEGES ON product_comparison_db.* TO 'appuser'@'localhost';
   FLUSH PRIVILEGES;
   ```

### Step 2: Backend Configuration

1. **Update database credentials** in `backend/src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=root
   spring.datasource.password=your_mysql_password
   ```

2. **Install Maven** (if not already installed):
   - Download from: https://maven.apache.org/download.cgi
   - Add to system PATH

### Step 3: Start Backend Server

1. **Navigate to backend directory:**
   ```bash
   cd backend
   ```

2. **Build and run:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. **Verify backend is running:**
   - Backend runs on `http://localhost:8080`
   - Check: `http://localhost:8080/api/products`

### Step 4: Start Frontend

1. **Navigate to project root:**
   ```bash
   cd ..
   ```

2. **Install dependencies:**
   ```bash
   npm install
   ```

3. **Start frontend:**
   ```bash
   npm start
   ```

4. **Access the app:**
   - Frontend runs on `http://localhost:3001`
   - Full integration with backend APIs

## 🔧 Troubleshooting

### Common Issues

#### 1. MySQL Connection Error: "Public Key Retrieval is not allowed"
**Solution:** The application.properties already includes the fix:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/product_comparison_db?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC
```

#### 2. Maven not found
**Solutions:**
- Install Maven: https://maven.apache.org/install.html
- Or use your IDE's built-in Maven
- Or use Spring Boot CLI: `spring run`

#### 3. Port already in use
**Frontend (3001):**
```bash
# Kill process on port 3001
netstat -ano | findstr :3001
taskkill /PID <PID> /F
```

**Backend (8080):**
```bash
# Kill process on port 8080
netstat -ano | findstr :8080
taskkill /PID <PID> /F
```

#### 4. Database connection refused
- Ensure MySQL service is running
- Check username/password in application.properties
- Verify database exists: `SHOW DATABASES;`

### Alternative Backend Startup Methods

#### Method 1: Using IDE
- Import `backend` folder in IntelliJ IDEA or Eclipse
- Run `ProductComparisonApplication.java`

#### Method 2: Using JAR file
```bash
cd backend
mvn clean package
java -jar target/product-comparison-backend-0.0.1-SNAPSHOT.jar
```

#### Method 3: Using Spring Boot CLI
```bash
cd backend
spring run src/main/java/com/productcomparison/ProductComparisonApplication.java
```

## 📊 Demo Data

The backend automatically initializes with:

### Demo User Account
- **Email:** demo@example.com
- **Password:** demo123
- **Role:** USER

### Sample Products (18 total)
- **8 Phones:** iPhone, Samsung, Google Pixel, OnePlus, etc.
- **4 TVs:** Samsung QLED, LG OLED, Sony LED, TCL QLED
- **6 Laptops:** MacBook Pro, Dell XPS, HP Spectre, ASUS ROG, etc.

## 🌐 API Endpoints

### Authentication
- `POST /api/auth/signin` - User login
- `POST /api/auth/signup` - User registration
- `POST /api/auth/signout` - User logout

### Products
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `GET /api/products/category/{category}` - Get products by category
- `GET /api/products/search?name={name}` - Search products
- `GET /api/products/categories` - Get all categories

## 🎨 Features Available

### With Backend (Full Features)
✅ Real user authentication with JWT  
✅ Persistent user sessions  
✅ Database-driven product catalog  
✅ Real-time product filtering  
✅ Secure API endpoints  
✅ Role-based access control  

### Frontend Only (Mock Data)
✅ Product browsing and comparison  
✅ Category filtering  
✅ Simulated authentication  
✅ Responsive design  
✅ All UI components functional  
⚠️ No data persistence  
⚠️ Simulated login only  

## 🚀 Production Deployment

### Backend Deployment
1. **Build production JAR:**
   ```bash
   mvn clean package -Pprod
   ```

2. **Deploy to cloud:**
   - AWS Elastic Beanstalk
   - Heroku
   - Google Cloud Platform
   - Azure App Service

### Frontend Deployment
1. **Build production bundle:**
   ```bash
   npm run build
   ```

2. **Deploy to:**
   - Netlify
   - Vercel
   - AWS S3 + CloudFront
   - GitHub Pages

### Database Deployment
- AWS RDS (MySQL)
- Google Cloud SQL
- Azure Database for MySQL
- PlanetScale
- Railway

## 📞 Support

If you encounter issues:

1. **Check logs:** Backend logs show detailed error messages
2. **Verify prerequisites:** Java 17+, Node.js 16+, MySQL 8+
3. **Test connectivity:** Can you connect to MySQL manually?
4. **Port conflicts:** Ensure ports 3001 and 8080 are available
5. **Firewall:** Check if firewall is blocking connections

## 🎯 Next Steps

Once everything is running:

1. **Explore the app:** Browse products, compare features
2. **Test authentication:** Register new user, login/logout
3. **Try filtering:** Filter by category (Phones, TVs, Laptops)
4. **Compare products:** Select multiple products for comparison
5. **Check responsive design:** Test on mobile devices

---

**Happy coding! 🚀**
