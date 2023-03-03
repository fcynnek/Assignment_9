package com.fcynnek.Assignment_9.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fcynnek.Assignment_9.service.FileService;

@RestController
public class FileController {
//Create “endpoints” inside of a RestController that will filter data
	
	@Autowired
	private ApplicationContext appContext;
	
	@Autowired
	private FileService fileService;
	
	@GetMapping("/read-lines")
	public List<String> readLines() throws IOException {
		FileService fileService = appContext.getBean(FileService.class);
		return fileService.readFile("recipes.txt");
	}
	
	@GetMapping("/gluten-free") //The “gluten-free” endpoint will only return a subset of the full Collection where glutenFree is true
	public List<Boolean> glutenFree() throws IOException {
//		FileService fileService = appContext.getBean(FileService.class);
		readLines();
//		if (gluten == true)
		return null;
	}
	
	@GetMapping("/vegan") //The “vegan” endpoint will only return a subset of the full Collection where vegan is true
	public List<Boolean> vegan() {
		FileService fileService = appContext.getBean(FileService.class);
		return null;
	}
	@GetMapping("/vegan-and-gluten-free") //The “vegan-and-gluten-free” endpoint will only return a subset of the full Collection where glutenFree is true and vegan is true
	public List<Boolean> veganAndGlutenFree() {
		FileService fileService = appContext.getBean(FileService.class);
		return null;
	}
	
	@GetMapping("/vegetarian") //The “vegetarian” endpoint will only return a subset of the full Collection where vegetarian is true
	public List<Boolean> vegetarian() {
		FileService fileService = appContext.getBean(FileService.class);
		return null;
	}
	
	@GetMapping("/all-recipes") //The “all-recipes” endpoint will not filter the data at all and should return the full Collection
	public List<Boolean> allRecipes() {
		FileService fileService = appContext.getBean(FileService.class);
		return null;
	}
}
