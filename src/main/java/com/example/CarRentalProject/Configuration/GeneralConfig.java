package com.example.CarRentalProject.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("config")
public class GeneralConfig {

    @Bean("mMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
