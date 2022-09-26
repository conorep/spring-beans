package com.example.springbeans.model;

public interface ILogger
{
    void warning(String message);
    void error(String message);
    void info(String message);
}
