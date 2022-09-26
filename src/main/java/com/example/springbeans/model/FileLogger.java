package com.example.springbeans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

//@EnableAutoConfiguration
@Component
@Primary //this will break ties if there's a request for an ILogger bean (if there's an option, this is the primary one you should choose)
public class FileLogger implements ILogger
{
//    private static final String PATH = "log.txt";
    private PrintWriter writer;
    private MyRandom random;

    public FileLogger(@Qualifier("path") String path) throws FileNotFoundException
    {
        writer = new PrintWriter(new FileOutputStream(path));
    }

    //this should use dependency-based injection
    @Autowired
    public void SetRandom(MyRandom random)
    {
        this.random = random;
    }

    @Override
    public void warning(String message)
    {
        writer.println("WARNING - " + message);
        writer.flush();
    }

    @Override
    public void error(String message)
    {
        writer.println("ERROR - " + message);
        writer.flush();
    }

    @Override
    public void info(String message)
    {
        writer.println("INFO - " + message);
        writer.flush();
    }
}
