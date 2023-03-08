package com.fcynnek.Assignment_9.service;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.fcynnek.Assignment_9.repository.Recipe;

@Service
public class FileService {
//Ingest a recipe.txt file and store this information in a Java Collection
	
	private String filename;
	List<Recipe> recipes = new ArrayList<>();
	
	public FileService() {
		
	}
	
	public List<Recipe> readFile (String filename) throws IOException {
		Reader in = new FileReader(filename);
//		Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
		Stream<CSVRecord> stream() {
		for (CSVRecord record : records) {
			
			List<String> headers = records.iterator().next().getParser().getHeaderNames();
			System.out.println(headers);
			
			Boolean dairy = Boolean.parseBoolean(record.get("Dairy Free"));
			Boolean gluten = Boolean.parseBoolean(record.get("Gluten Free"));
			Boolean vegan	= Boolean.parseBoolean(record.get("Vegan"));
			Boolean vegetarian	= Boolean.parseBoolean(record.get("Vegetarian"));
			
			String title	= record.get("Title");
			Double score	= Double.parseDouble(record.get("Spoonacular Score"));
			Integer servings	= Integer.parseInt(record.get("Servings"));
			Double priceServ	= Double.parseDouble(record.get("Price Per Serving"));
			Double prepMins	= Double.parseDouble(record.get("Preparation Minutes"));
			Integer cookingMins = Integer.parseInt(record.get("Cooking Minutes")) ;
			Integer readyMins	= Integer.parseInt(record.get("Ready In Minutes"));
			String instructions	= record.get("Instructions");
			
			Recipe recipe = new Recipe(title, score, servings, priceServ, prepMins, cookingMins, readyMins, instructions);
			recipe.setDairyFree(dairy);
			recipe.setGlutenFree(gluten);
			recipe.setVegan(vegan);
			recipe.setVegetarian(vegetarian);

			recipes.add(recipe);
		}	
		return recipes;
	}
	
	public List<Recipe> dairyFree() {
		List<Recipe> dairyFreeRecipes = new ArrayList<>();
		
		for (Recipe recipe : recipes) {
			if (recipe.getDairyFree() == true) {
//				recipe.getTitle();
//				recipe.getSpoonacularScore();
//				recipe.getServings();
//				recipe.getPricePerServing();
//				recipe.getPreparationMinutes();
//				recipe.getCookingMinutes();
//				recipe.getReadyInMinutes();
//				recipe.getInstructions();
				dairyFreeRecipes.add(recipe);
			}
//			Recipe dairyFree = new Recipe(recipe.getTitle(), recipe.getSpoonacularScore(), recipe.getServings(), 
//					recipe.getPricePerServing(), recipe.getPreparationMinutes(), recipe.getCookingMinutes(), recipe.getReadyInMinutes(), 
//					recipe.getInstructions());
//			recipe.toString();
		}
		return dairyFreeRecipes;
		
	}
	
}
