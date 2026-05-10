package com.marketplace.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

@Configuration
public class GraphicsEnvironmentConfig {

    @Bean
    public GraphicsEnvironment graphicsEnvironment() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment();
    }
}
