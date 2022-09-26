package com.example.springbeans;

import com.example.springbeans.model.FileLogger;
import com.example.springbeans.model.ILogger;
import com.example.springbeans.model.MyRandom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.FileNotFoundException;

@SpringBootApplication
public class SpringBeansApplication
{

    public static void main(String[] args) throws FileNotFoundException
    {
        /*return call returns applicationContext (this is an example of inversion of control)*/
        ApplicationContext context = SpringApplication.run(SpringBeansApplication.class, args);

        /*this is using Spring's reflection features to inspect what the class looks like (using generics)*/
        /*"I want an instance of this class. Context will return the instance."*/
        MyRandom random = context.getBean(MyRandom.class); //ask for the bean that Spring created for us
        System.out.println(random);
        System.out.println(random.between(1, 100));

        // will this give us the same or diff object? answer: same
        //MyRandomInterface anotherRandom = context.getBean(MyRandom.class);
        //System.out.println(anotherRandom);
        //System.out.println(anotherRandom.between(1, 100));


        ILogger log = context.getBean(ILogger.class);
        System.out.println(log);
        log.error("file not found");
        log.info("Hello, world.");

//        FileLogger logger = new FileLogger("log.txt");

        for (String beanName : context.getBeanDefinitionNames())
        {
            System.out.println(beanName);
        }
    }
}
