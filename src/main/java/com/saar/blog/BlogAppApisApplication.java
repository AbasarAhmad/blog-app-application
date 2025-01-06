package com.saar.blog;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner {
	
	/*
	 * Interface: CommandLineRunner is an interface, and to use it, you need to implement its run method.
		run() Method: The run method gets executed automatically when the application starts, and it takes command-line arguments as input.
		*/

	@Autowired
    private  PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(BlogAppApisApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) {
        // Using the PasswordEncoder bean to encode a password
    	System.out.println();
        System.out.println(this.passwordEncoder.encode("alpha"));
        System.out.println();
    }
}