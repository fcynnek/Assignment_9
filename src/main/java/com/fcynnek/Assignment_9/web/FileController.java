package com.fcynnek.Assignment_9.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fcynnek.Assignment_9.repository.Recipe;
import com.fcynnek.Assignment_9.service.FileService;

@RestController
public class FileController {
//Create “endpoints” inside of a RestController that will filter data
	
	@Autowired
	private ApplicationContext appContext;
	
	@Autowired
	private FileService fileService;
	
	@GetMapping("localhost:8080")
	public List<Recipe> loadRecipes() throws IOException  {
		FileService fileService = appContext.getBean(FileService.class);
		return fileService.readFile("recipes.txt");
	}
	
	// these below will be calling methods that filters for each category from the file service
	
	//The “gluten-free” endpoint will only return a subset of the full Collection where glutenFree is true
	@GetMapping("/gluten-free") 
	public List<Recipe> glutenFree() throws IOException {
		FileService fileService = appContext.getBean(FileService.class);
		fileService.glutenFree().forEach(System.out::println);
		return fileService.glutenFree();
	}
	
	//The “vegan” endpoint will only return a subset of the full Collection where vegan is true
	@GetMapping("/vegan") 
	public List<Recipe> vegan() throws IOException {
		FileService fileService = appContext.getBean(FileService.class);
		fileService.vegan().forEach(System.out::println);
		return fileService.vegan();
	}
	
	//The “vegan-and-gluten-free” endpoint will only return a subset of the full Collection where glutenFree is true and vegan is true
	@GetMapping("/vegan-and-gluten-free") 
	public List<Recipe> veganAndGlutenFree() throws IOException {
		FileService fileService = appContext.getBean(FileService.class);
		fileService.veganAndGlutenFree().forEach(System.out::println);
		return fileService.veganAndGlutenFree();
	}
	
	//The “vegetarian” endpoint will only return a subset of the full Collection where vegetarian is true
	@GetMapping("/vegetarian") 
	public List<Recipe> vegetarian() throws IOException {
		FileService fileService = appContext.getBean(FileService.class);
		fileService.vegetarian().forEach(System.out::println);
		return fileService.vegetarian();
	}
	
	//The “all-recipes” endpoint will not filter the data at all and should return the full Collection
	@GetMapping("/all-recipes") 
	public List<Recipe> allRecipes() throws IOException  {
		FileService fileService = appContext.getBean(FileService.class);
		fileService.allRecipes().forEach(System.out::println);
		return fileService.allRecipes();
	}
}
