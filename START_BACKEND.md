# How to Start the Backend Server

## Current Status
✅ **Frontend**: Running on http://localhost:3000  
✅ **Database Config**: Updated to use `product_comparison` database with `root/root` credentials  
✅ **CORS**: Configured to allow frontend on port 3000  
⏳ **Backend**: Needs to be started for full integration  

## Why Backend is Important
When you register or login:
- **Without Backend**: Data is only stored temporarily in browser memory (lost on refresh)
- **With Backend**: Data is permanently stored in MySQL database and persists across sessions

## Quick Start Options

### Option 1: Install Maven (Recommended)
1. **Download Maven**: https://maven.apache.org/download.cgi
2. **Extract** to a folder (e.g., `C:\apache-maven-3.9.5`)
3. **Add to PATH**: Add `C:\apache-maven-3.9.5\bin` to your system PATH
4. **Restart terminal** and run:
   ```bash
   cd backend
   mvn spring-boot:run
   ```

### Option 2: Use IDE
1. **Open IntelliJ IDEA or Eclipse**
2. **Import** the `backend` folder as a Maven project
3. **Run** `ProductComparisonApplication.java`

### Option 3: Use Spring Boot CLI
1. **Install Spring Boot CLI**: https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started.installing.cli
2. **Run**:
   ```bash
   cd backend
   spring run src/main/java/com/productcomparison/ProductComparisonApplication.java
   ```

## Database Setup Required

1. **Start MySQL** service on your computer
2. **Create database** (or let the app create it automatically):
   ```sql
   CREATE DATABASE product_comparison;
   ```
3. **Verify connection** with username: `root`, password: `root`

## What Happens When Backend Starts

1. **Database Tables Created**: User, Role, Product tables automatically created
2. **Sample Data Loaded**: 18 products and demo user account loaded
3. **APIs Available**: All REST endpoints become functional
4. **Real Authentication**: JWT tokens for secure login/logout
5. **Data Persistence**: Registration data stored permanently

## Demo Account (Available After Backend Starts)
- **Email**: demo@example.com
- **Password**: demo123

## Testing Full Integration

Once backend is running:
1. **Register** a new user → Data saved to MySQL
2. **Login** with new credentials → JWT token generated
3. **Browse products** → Data loaded from database
4. **Logout and login again** → Your account persists

## Current Fallback Behavior

Right now, your frontend is working with mock data:
- ✅ All UI features work
- ✅ Product comparison works
- ✅ Category filtering works
- ⚠️ Registration/login is simulated only
- ⚠️ Data doesn't persist

## Next Steps

1. **Choose one of the startup options above**
2. **Start the backend server**
3. **Test registration** → You'll see data in MySQL
4. **Enjoy full-stack functionality!**

---

**The app is fully functional right now with mock data, but starting the backend will give you real database persistence and authentication!**
