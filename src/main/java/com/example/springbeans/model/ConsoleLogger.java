package com.example.springbeans.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.Console;

@Component
public class ConsoleLogger implements ILogger
{
    private String appTitle;

    public ConsoleLogger(@Qualifier("title") String appTitle)
    {
        this.appTitle = appTitle;
    }

    @Override
    public void warning(String message)
    {
        System.out.println("WARNING - " + message);
    }

    @Override
    public void error(String message)
    {
        System.out.println("ERROR - " + message);
    }

    @Override
    public void info(String message)
    {
        System.out.println("INFO - " + message);
    }
}
