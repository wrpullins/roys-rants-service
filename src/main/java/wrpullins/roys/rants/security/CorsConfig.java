package wrpullins.roys.rants.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")          // Match all endpoints
                .allowedOriginPatterns("*") // Allow all origins cleanly
                .allowedMethods("*")        // Allow all HTTP methods (GET, POST, PUT, etc.)
                .allowedHeaders("*")        // Allow all request headers
                .allowCredentials(true);    // Allow cookies/auth headers if needed
    }
}