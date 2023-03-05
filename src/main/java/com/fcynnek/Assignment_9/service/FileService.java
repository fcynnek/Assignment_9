package com.fcynnek.Assignment_9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.fcynnek.Assignment_9.repository.RecipeRepository;

@Service
public class FileService {
//Ingest a recipe.txt file and store this information in a Java Collection
	
	private String filename;
	
	public FileService() {
		
	}
	
	public List<RecipeRepository> readFile (String filename) throws IOException {
		Reader in = new FileReader(filename);
		List<RecipeRepository> recipes = new ArrayList<>();
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
		for (CSVRecord record : records) {
			Boolean dairy = Boolean.parseBoolean(record.get("Dairy Free"));
			Boolean gluten = Boolean.parseBoolean(record.get("Gluten Free"));
			Boolean vegan	= Boolean.parseBoolean(record.get("Vegan"));
			Boolean vegetarian	= Boolean.parseBoolean(record.get("Vegetarian"));
			if ((dairy == true) || (gluten == true) || (vegan == true) || (vegetarian == true)) {				
//				RecipeRepository recipe = new RecipeRepository();
				String title	= record.get("Title");
				Double score	= Double.parseDouble(record.get("Spoonacular Score"));
				Integer servings	= Integer.parseInt(record.get("Servings"));
				Double priceServ	= Double.parseDouble(record.get("Price Per Serving"));
				Double prepMins	= Double.parseDouble(record.get("Preparation Minutes"));
				Integer cookingMins = Integer.parseInt(record.get("Cooking Minutes")) ;
				Integer readyMins	= Integer.parseInt(record.get("Ready In Minutes"));
				String instructions	= record.get("Instructions");
				
				RecipeRepository recipe = new RecipeRepository(readyMins, instructions, priceServ, priceServ, readyMins, readyMins, priceServ, instructions);
				recipe.setTitle(title);
				recipe.setSpoonacularScore(score);
				recipe.setServings(servings);
				recipe.setPricePerServing(priceServ);
				recipe.setPreparationMinutes(prepMins);
				recipe.setCookingMinutes(cookingMins);
				recipe.setReadyInMinutes(readyMins);
				recipe.setInstructions(instructions);
				recipes.add(recipe);
			}
		}
		
		return recipes;
	}
	
	public RecipeRepository[] dairyFree() {
		
		
		return null;
		
	}
	
}
