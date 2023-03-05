package com.mino_tavr.configurations;


import com.mino_tavr.broker.ImageBroker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ImageConfigurationBean {
    @Bean
    public ImageBroker imageBroker() throws IOException {
        return new ImageBroker();
    }
}
