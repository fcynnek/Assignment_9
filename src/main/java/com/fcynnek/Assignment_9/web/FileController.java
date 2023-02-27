package com.fcynnek.Assignment_9.web;

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
	public List<String> readLines() {
		FileService fileService = appContext.getBean(FileService.class);
	}
	
	@GetMapping("/gluten-free") //The “gluten-free” endpoint will only return a subset of the full Collection where glutenFree is true
	@GetMapping("/vegan") //The “vegan” endpoint will only return a subset of the full Collection where vegan is true
	@GetMapping("/vegan-and-gluten-free") //The “vegan-and-gluten-free” endpoint will only return a subset of the full Collection where glutenFree is true and vegan is true
	@GetMapping("/vegetarian") //The “vegetarian” endpoint will only return a subset of the full Collection where vegetarian is true
	@GetMapping("/all-recipes") //The “all-recipes” endpoint will not filter the data at all and should return the full Collection
}
