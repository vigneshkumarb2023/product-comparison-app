package com.productcomparison.service;

import com.productcomparison.entity.ERole;
import com.productcomparison.entity.Product;
import com.productcomparison.entity.Role;
import com.productcomparison.entity.User;
import com.productcomparison.repository.ProductRepository;
import com.productcomparison.repository.RoleRepository;
import com.productcomparison.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class DataInitializationService implements CommandLineRunner {
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        initializeRoles();
        initializeDemoUser();
        initializeProducts();
    }
    
    private void initializeRoles() {
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role(ERole.ROLE_USER));
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
            System.out.println("Roles initialized successfully!");
        }
    }
    
    private void initializeDemoUser() {
        if (!userRepository.existsByEmail("demo@example.com")) {
            User demoUser = new User();
            demoUser.setFirstName("Demo");
            demoUser.setLastName("User");
            demoUser.setEmail("demo@example.com");
            demoUser.setPassword(passwordEncoder.encode("demo123"));
            
            Set<Role> roles = new HashSet<>();
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
            demoUser.setRoles(roles);
            
            userRepository.save(demoUser);
            System.out.println("Demo user created successfully!");
        }
    }
    
    private void initializeProducts() {
        if (productRepository.count() == 0) {
            // Initialize Phones
            initializePhones();
            
            // Initialize TVs
            initializeTVs();
            
            // Initialize Laptops
            initializeLaptops();
            
            System.out.println("Products initialized successfully!");
        }
    }
    
    private void initializePhones() {
        // iPhone 14 Pro
        Map<String, String> iphone14Features = new HashMap<>();
        iphone14Features.put("Screen Size", "6.1 inches");
        iphone14Features.put("Storage", "128GB");
        iphone14Features.put("Camera", "48MP Triple");
        iphone14Features.put("Battery", "3200mAh");
        iphone14Features.put("RAM", "6GB");
        iphone14Features.put("OS", "iOS 16");
        iphone14Features.put("5G", "Yes");
        iphone14Features.put("Wireless Charging", "Yes");
        
        Product iphone14 = new Product("iPhone 14 Pro", 82999.0, "Phone", iphone14Features);
        productRepository.save(iphone14);
        
        // Samsung Galaxy S23
        Map<String, String> galaxyS23Features = new HashMap<>();
        galaxyS23Features.put("Screen Size", "6.1 inches");
        galaxyS23Features.put("Storage", "256GB");
        galaxyS23Features.put("Camera", "50MP Triple");
        galaxyS23Features.put("Battery", "3900mAh");
        galaxyS23Features.put("RAM", "8GB");
        galaxyS23Features.put("OS", "Android 13");
        galaxyS23Features.put("5G", "Yes");
        galaxyS23Features.put("Wireless Charging", "Yes");
        
        Product galaxyS23 = new Product("Samsung Galaxy S23", 74999.0, "Phone", galaxyS23Features);
        productRepository.save(galaxyS23);
        
        // Google Pixel 7
        Map<String, String> pixel7Features = new HashMap<>();
        pixel7Features.put("Screen Size", "6.3 inches");
        pixel7Features.put("Storage", "128GB");
        pixel7Features.put("Camera", "50MP Dual");
        pixel7Features.put("Battery", "4355mAh");
        pixel7Features.put("RAM", "8GB");
        pixel7Features.put("OS", "Android 13");
        pixel7Features.put("5G", "Yes");
        pixel7Features.put("Wireless Charging", "Yes");
        
        Product pixel7 = new Product("Google Pixel 7", 58999.0, "Phone", pixel7Features);
        productRepository.save(pixel7);
        
        // OnePlus 11
        Map<String, String> onePlus11Features = new HashMap<>();
        onePlus11Features.put("Screen Size", "6.7 inches");
        onePlus11Features.put("Storage", "256GB");
        onePlus11Features.put("Camera", "50MP Triple");
        onePlus11Features.put("Battery", "5000mAh");
        onePlus11Features.put("RAM", "12GB");
        onePlus11Features.put("OS", "Android 13");
        onePlus11Features.put("5G", "Yes");
        onePlus11Features.put("Wireless Charging", "Yes");
        
        Product onePlus11 = new Product("OnePlus 11", 62999.0, "Phone", onePlus11Features);
        productRepository.save(onePlus11);
        
        // iPhone 13
        Map<String, String> iphone13Features = new HashMap<>();
        iphone13Features.put("Screen Size", "6.1 inches");
        iphone13Features.put("Storage", "128GB");
        iphone13Features.put("Camera", "12MP Dual");
        iphone13Features.put("Battery", "3240mAh");
        iphone13Features.put("RAM", "4GB");
        iphone13Features.put("OS", "iOS 16");
        iphone13Features.put("5G", "Yes");
        iphone13Features.put("Wireless Charging", "Yes");
        
        Product iphone13 = new Product("iPhone 13", 58999.0, "Phone", iphone13Features);
        productRepository.save(iphone13);
        
        // Xiaomi 13
        Map<String, String> xiaomi13Features = new HashMap<>();
        xiaomi13Features.put("Screen Size", "6.36 inches");
        xiaomi13Features.put("Storage", "256GB");
        xiaomi13Features.put("Camera", "50MP Triple");
        xiaomi13Features.put("Battery", "4500mAh");
        xiaomi13Features.put("RAM", "8GB");
        xiaomi13Features.put("OS", "Android 13");
        xiaomi13Features.put("5G", "Yes");
        xiaomi13Features.put("Wireless Charging", "Yes");
        
        Product xiaomi13 = new Product("Xiaomi 13", 54999.0, "Phone", xiaomi13Features);
        productRepository.save(xiaomi13);
        
        // Samsung Galaxy A54
        Map<String, String> galaxyA54Features = new HashMap<>();
        galaxyA54Features.put("Screen Size", "6.4 inches");
        galaxyA54Features.put("Storage", "128GB");
        galaxyA54Features.put("Camera", "50MP Triple");
        galaxyA54Features.put("Battery", "5000mAh");
        galaxyA54Features.put("RAM", "6GB");
        galaxyA54Features.put("OS", "Android 13");
        galaxyA54Features.put("5G", "Yes");
        galaxyA54Features.put("Wireless Charging", "No");
        
        Product galaxyA54 = new Product("Samsung Galaxy A54", 37999.0, "Phone", galaxyA54Features);
        productRepository.save(galaxyA54);
        
        // Nothing Phone 2
        Map<String, String> nothingPhone2Features = new HashMap<>();
        nothingPhone2Features.put("Screen Size", "6.7 inches");
        nothingPhone2Features.put("Storage", "256GB");
        nothingPhone2Features.put("Camera", "50MP Dual");
        nothingPhone2Features.put("Battery", "4700mAh");
        nothingPhone2Features.put("RAM", "8GB");
        nothingPhone2Features.put("OS", "Android 13");
        nothingPhone2Features.put("5G", "Yes");
        nothingPhone2Features.put("Wireless Charging", "Yes");
        
        Product nothingPhone2 = new Product("Nothing Phone 2", 49999.0, "Phone", nothingPhone2Features);
        productRepository.save(nothingPhone2);
    }
    
    private void initializeTVs() {
        // Samsung 55" QLED 4K TV
        Map<String, String> samsungTVFeatures = new HashMap<>();
        samsungTVFeatures.put("Screen Size", "55 inches");
        samsungTVFeatures.put("Resolution", "4K UHD");
        samsungTVFeatures.put("Display Type", "QLED");
        samsungTVFeatures.put("Smart TV", "Yes");
        samsungTVFeatures.put("HDR", "HDR10+");
        samsungTVFeatures.put("Refresh Rate", "120Hz");
        samsungTVFeatures.put("Audio", "Dolby Atmos");
        samsungTVFeatures.put("Connectivity", "WiFi, Bluetooth");
        
        Product samsungTV = new Product("Samsung 55\" QLED 4K TV", 108999.0, "TV", samsungTVFeatures);
        productRepository.save(samsungTV);
        
        // LG 65" OLED 4K TV
        Map<String, String> lgTVFeatures = new HashMap<>();
        lgTVFeatures.put("Screen Size", "65 inches");
        lgTVFeatures.put("Resolution", "4K UHD");
        lgTVFeatures.put("Display Type", "OLED");
        lgTVFeatures.put("Smart TV", "Yes");
        lgTVFeatures.put("HDR", "Dolby Vision");
        lgTVFeatures.put("Refresh Rate", "120Hz");
        lgTVFeatures.put("Audio", "Dolby Atmos");
        lgTVFeatures.put("Connectivity", "WiFi, Bluetooth");
        
        Product lgTV = new Product("LG 65\" OLED 4K TV", 159999.0, "TV", lgTVFeatures);
        productRepository.save(lgTV);
        
        // Sony 50" LED 4K TV
        Map<String, String> sonyTVFeatures = new HashMap<>();
        sonyTVFeatures.put("Screen Size", "50 inches");
        sonyTVFeatures.put("Resolution", "4K UHD");
        sonyTVFeatures.put("Display Type", "LED");
        sonyTVFeatures.put("Smart TV", "Yes");
        sonyTVFeatures.put("HDR", "HDR10");
        sonyTVFeatures.put("Refresh Rate", "60Hz");
        sonyTVFeatures.put("Audio", "DTS Digital Surround");
        sonyTVFeatures.put("Connectivity", "WiFi, Bluetooth");
        
        Product sonyTV = new Product("Sony 50\" LED 4K TV", 74999.0, "TV", sonyTVFeatures);
        productRepository.save(sonyTV);
        
        // TCL 43" QLED 4K TV
        Map<String, String> tclTVFeatures = new HashMap<>();
        tclTVFeatures.put("Screen Size", "43 inches");
        tclTVFeatures.put("Resolution", "4K UHD");
        tclTVFeatures.put("Display Type", "QLED");
        tclTVFeatures.put("Smart TV", "Yes");
        tclTVFeatures.put("HDR", "HDR10");
        tclTVFeatures.put("Refresh Rate", "60Hz");
        tclTVFeatures.put("Audio", "Dolby Audio");
        tclTVFeatures.put("Connectivity", "WiFi, Bluetooth");
        
        Product tclTV = new Product("TCL 43\" QLED 4K TV", 54999.0, "TV", tclTVFeatures);
        productRepository.save(tclTV);
    }
    
    private void initializeLaptops() {
        // MacBook Pro 14"
        Map<String, String> macbookFeatures = new HashMap<>();
        macbookFeatures.put("Screen Size", "14.2 inches");
        macbookFeatures.put("Processor", "Apple M2 Pro");
        macbookFeatures.put("RAM", "16GB");
        macbookFeatures.put("Storage", "512GB SSD");
        macbookFeatures.put("Graphics", "Integrated");
        macbookFeatures.put("Battery Life", "17 hours");
        macbookFeatures.put("Weight", "3.5 lbs");
        macbookFeatures.put("OS", "macOS");
        
        Product macbook = new Product("MacBook Pro 14\"", 169999.0, "Laptop", macbookFeatures);
        productRepository.save(macbook);
        
        // Dell XPS 13
        Map<String, String> dellXPSFeatures = new HashMap<>();
        dellXPSFeatures.put("Screen Size", "13.4 inches");
        dellXPSFeatures.put("Processor", "Intel i7-1360P");
        dellXPSFeatures.put("RAM", "16GB");
        dellXPSFeatures.put("Storage", "512GB SSD");
        dellXPSFeatures.put("Graphics", "Intel Iris Xe");
        dellXPSFeatures.put("Battery Life", "12 hours");
        dellXPSFeatures.put("Weight", "2.6 lbs");
        dellXPSFeatures.put("OS", "Windows 11");
        
        Product dellXPS = new Product("Dell XPS 13", 108999.0, "Laptop", dellXPSFeatures);
        productRepository.save(dellXPS);
        
        // HP Spectre x360
        Map<String, String> hpSpectreFeatures = new HashMap<>();
        hpSpectreFeatures.put("Screen Size", "13.5 inches");
        hpSpectreFeatures.put("Processor", "Intel i7-1255U");
        hpSpectreFeatures.put("RAM", "16GB");
        hpSpectreFeatures.put("Storage", "1TB SSD");
        hpSpectreFeatures.put("Graphics", "Intel Iris Xe");
        hpSpectreFeatures.put("Battery Life", "10 hours");
        hpSpectreFeatures.put("Weight", "3.0 lbs");
        hpSpectreFeatures.put("OS", "Windows 11");
        
        Product hpSpectre = new Product("HP Spectre x360", 95999.0, "Laptop", hpSpectreFeatures);
        productRepository.save(hpSpectre);
        
        // ASUS ROG Zephyrus G14
        Map<String, String> asusROGFeatures = new HashMap<>();
        asusROGFeatures.put("Screen Size", "14 inches");
        asusROGFeatures.put("Processor", "AMD Ryzen 9");
        asusROGFeatures.put("RAM", "32GB");
        asusROGFeatures.put("Storage", "1TB SSD");
        asusROGFeatures.put("Graphics", "RTX 4060");
        asusROGFeatures.put("Battery Life", "8 hours");
        asusROGFeatures.put("Weight", "3.6 lbs");
        asusROGFeatures.put("OS", "Windows 11");
        
        Product asusROG = new Product("ASUS ROG Zephyrus G14", 134999.0, "Laptop", asusROGFeatures);
        productRepository.save(asusROG);
        
        // Lenovo ThinkPad X1 Carbon
        Map<String, String> thinkpadFeatures = new HashMap<>();
        thinkpadFeatures.put("Screen Size", "14 inches");
        thinkpadFeatures.put("Processor", "Intel i7-1365U");
        thinkpadFeatures.put("RAM", "16GB");
        thinkpadFeatures.put("Storage", "512GB SSD");
        thinkpadFeatures.put("Graphics", "Intel Iris Xe");
        thinkpadFeatures.put("Battery Life", "15 hours");
        thinkpadFeatures.put("Weight", "2.5 lbs");
        thinkpadFeatures.put("OS", "Windows 11");
        
        Product thinkpad = new Product("Lenovo ThinkPad X1 Carbon", 117999.0, "Laptop", thinkpadFeatures);
        productRepository.save(thinkpad);
        
        // Microsoft Surface Laptop 5
        Map<String, String> surfaceFeatures = new HashMap<>();
        surfaceFeatures.put("Screen Size", "13.5 inches");
        surfaceFeatures.put("Processor", "Intel i7-1255U");
        surfaceFeatures.put("RAM", "16GB");
        surfaceFeatures.put("Storage", "256GB SSD");
        surfaceFeatures.put("Graphics", "Intel Iris Xe");
        surfaceFeatures.put("Battery Life", "18 hours");
        surfaceFeatures.put("Weight", "2.8 lbs");
        surfaceFeatures.put("OS", "Windows 11");
        
        Product surface = new Product("Microsoft Surface Laptop 5", 108999.0, "Laptop", surfaceFeatures);
        productRepository.save(surface);
    }
}
