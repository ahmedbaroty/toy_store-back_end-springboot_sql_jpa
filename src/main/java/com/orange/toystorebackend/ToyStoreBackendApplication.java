package com.orange.toystorebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class ToyStoreBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToyStoreBackendApplication.class, args);
    }


    @Bean
    public WebMvcConfigurer corsConfigurer(){

        return new WebMvcConfigurerAdapter(){

            @Override
            public void addCorsMappings(CorsRegistry registry){
                // registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:4200");
                registry
                        .addMapping("/**")
                        .allowedOrigins("http://localhost:4200");
            }
        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

