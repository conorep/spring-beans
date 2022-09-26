package com.example.springbeans.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
    //we cant mark strings as spring beans, but
    //can return a string as a bean from a method
    @Bean
    @Qualifier("path") //<----- differentiate beans
    public String loggerPath()
    {
        return "log.txt";
    }

    @Bean
    @Qualifier("title")
    public String appTitle()
    {
        return "My Spring App";
    }

}
