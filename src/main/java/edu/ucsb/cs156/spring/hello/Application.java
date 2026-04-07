package edu.ucsb.cs156.spring.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Every Spring Boot application has a main class with a main method 
 * that starts the application.  This always involves calling
 * SpringApplication.run(), passing in the class object for the class
 * containg the main, and any command line arguments.
 */

@SpringBootApplication
public class Application {
    /**
     * Starts the Spring Boot application and returns the application context.
     *
     * @param args command line arguments
     * @return the running application context
     */
    static ConfigurableApplicationContext run(String[] args) {
        return SpringApplication.run(Application.class, args);
    }

    /**
     * main class for Spring Boot application.
     */
    public static void main(String[] args) {
        run(args);
    }
}
