package com.example.reservation_app;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Configure l'application Spring Boot pour le déploiement sur un conteneur de servlets (comme Tomcat)
        return application.sources(ReservationAppApplication.class);
    }
}
