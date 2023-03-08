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
		SpringApplication.run(Assignment9Application.class, args);
		
//		FileService fs = new FileService();
//		fs.readFile("recipes.txt");
//		System.out.println("ALL");
//		System.out.println(fs.allRecipes());
//		System.out.println("DAIRY FREE");
//		System.out.println(fs.dairyFree());
//		System.out.println("VEGETARIAN");
//		System.out.println(fs.vegetarian());
//		System.out.println("VEGAN AND GF");
//		System.out.println(fs.veganAndGlutenFree());
		
		
	}

}
