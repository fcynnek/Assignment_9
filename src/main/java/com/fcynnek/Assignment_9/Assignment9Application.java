package com.fcynnek.Assignment_9;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fcynnek.Assignment_9.repository.Recipe;
import com.fcynnek.Assignment_9.service.FileService;

@SpringBootApplication
public class Assignment9Application {

	public static void main(String[] args) throws IOException {
//		SpringApplication.run(Assignment9Application.class, args);
		
		FileService fs = new FileService();
		
		System.out.println(fs.readFile("recipes.txt"));
		
		System.out.println(fs.dairyFree());
		
		
		
	}

}
