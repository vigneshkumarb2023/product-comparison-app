import api from './api';

const authService = {
  // Login user
  login: async (email, password) => {
    try {
      const response = await api.post('/auth/signin', {
        email,
        password
      });
      
      if (response.data.token) {
        const userData = {
          token: response.data.token,
          email: response.data.email,
          name: response.data.name,
          id: response.data.id,
          roles: response.data.roles
        };
        localStorage.setItem('user', JSON.stringify(userData));
        return userData;
      }
      
      return response.data;
    } catch (error) {
      throw new Error(error.response?.data?.message || 'Login failed');
    }
  },

  // Register user
  register: async (firstName, lastName, email, password) => {
    try {
      const response = await api.post('/auth/signup', {
        firstName,
        lastName,
        email,
        password
      });
      
      // After successful registration, automatically log in
      if (response.data.message === 'User registered successfully!') {
        return await authService.login(email, password);
      }
      
      return response.data;
    } catch (error) {
      throw new Error(error.response?.data?.message || 'Registration failed');
    }
  },

  // Logout user
  logout: async () => {
    try {
      await api.post('/auth/signout');
    } catch (error) {
      console.error('Logout error:', error);
    } finally {
      localStorage.removeItem('user');
    }
  },

  // Get current user from localStorage
  getCurrentUser: () => {
    const user = localStorage.getItem('user');
    return user ? JSON.parse(user) : null;
  },

  // Check if user is authenticated
  isAuthenticated: () => {
    const user = authService.getCurrentUser();
    return user && user.token;
  }
};

export default authService;
