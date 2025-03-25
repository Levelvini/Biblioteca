package com.levelvini.biblioteca.config;

import com.levelvini.biblioteca.model.DTO.LivroDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {


    @Bean
    public ModelMapper modelMapper(){
       ModelMapper modelMapper = new ModelMapper();
       return modelMapper;
    }
}

