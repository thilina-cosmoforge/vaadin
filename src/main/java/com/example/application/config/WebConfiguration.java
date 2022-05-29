package com.example.application.config;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfiguration.class);

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setSkipNullEnabled(true).setPropertyCondition(Conditions.isNotNull());
        return modelMapper;
    }
}
