package com.fcynnek.Assignment_9.service;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fcynnek.Assignment_9.repository.Recipe;

@Service
public class FileService {
//Ingest a recipe.txt file and store this information in a Java Collection
	
	private String filename;
	
	List<Recipe> recipes = new ArrayList<>();
//	Collection<Recipe> recipes = new ArrayList<>();
	
	public FileService() {
		
	}
	
	public List<Recipe> readFile (String filename) throws IOException {
//	public Collection<Recipe> readFile (String filename) throws IOException {
		Reader in = new FileReader(filename);
//		Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(in);
//		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().parse(in);
//		Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("Cooking Minutes", "Dairy Free", "Gluten Free", 
//				"Instructions", "Preparation Minutes", "Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan", 
//				"Vegetarian").parse(in);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withEscape('\\').withIgnoreSurroundingSpaces().withFirstRecordAsHeader().parse(in);
		for (CSVRecord record : records) {
			
//			List<String> headers = records.iterator().next().getParser().getHeaderNames();
//			System.out.println(headers);
			
//			Boolean dairy = Boolean.parseBoolean(record.get("Dairy Free"));
//			Boolean gluten = Boolean.parseBoolean(record.get("Gluten Free"));
//			Boolean vegan	= Boolean.parseBoolean(record.get("Vegan"));
//			Boolean vegetarian	= Boolean.parseBoolean(record.get("Vegetarian"));
//			
//			String title	= record.get("Title");
//			Double score	= Double.parseDouble(record.get("Spoonacular Score"));
//			Integer servings	= Integer.parseInt(record.get("Servings"));
//			Double priceServ	= Double.parseDouble(record.get("Price Per Serving"));
//			Double prepMins	= Double.parseDouble(record.get("Preparation Minutes"));
//			Integer cookingMins = Integer.parseInt(record.get("Cooking Minutes")) ;
//			Integer readyMins	= Integer.parseInt(record.get("Ready In Minutes"));
//			String instructions	= record.get("Instructions");
			
			Boolean dairy = Boolean.parseBoolean(record.get(1));
			Boolean gluten = Boolean.parseBoolean(record.get(2));
			Boolean vegan	= Boolean.parseBoolean(record.get(10));
			Boolean vegetarian	= Boolean.parseBoolean(record.get(11));
			
			String title	= record.get(9);
			Double score	= Double.parseDouble(record.get(8));
			Integer servings	= Integer.parseInt(record.get(7));
			Double priceServ	= Double.parseDouble(record.get(5));
			Double prepMins	= Double.parseDouble(record.get(4));
			Integer cookingMins = Integer.parseInt(record.get(0)) ;
			Integer readyMins	= Integer.parseInt(record.get(6));
			String instructions	= record.get(3);
			
			Recipe recipe = new Recipe(title, score, servings, priceServ, prepMins, cookingMins, readyMins, instructions);
			recipe.setDairyFree(dairy);
			recipe.setGlutenFree(gluten);
			recipe.setVegan(vegan);
			recipe.setVegetarian(vegetarian);

			recipes.add(recipe);
		}	
		return recipes;
	}
	
	public List<Recipe> allRecipes() {
//	public Collection<Recipe> allRecipes() {
		return recipes;
	}
	
	public List<Recipe> dairyFree() {
		List<Recipe> dairyFreeRecipes = new ArrayList<>();
		
		for (Recipe recipe : recipes) {
			if (recipe.getDairyFree() == true) {
				dairyFreeRecipes.add(recipe);
			}
		}
		return dairyFreeRecipes;
	}
	
	public List<Recipe> glutenFree() {
		List<Recipe> glutenFreeRecipes = new ArrayList<>();
		
		for (Recipe recipe : recipes) {
			if (recipe.getGlutenFree() == true) {
				glutenFreeRecipes.add(recipe);
			}
		}
		return glutenFreeRecipes;
	}
	
	public List<Recipe> veganAndGlutenFree() {
		List<Recipe> veganAndGFRecipes = new ArrayList<>();
		
		for (Recipe recipe : recipes) {
			if ((recipe.getVegan() == true) && (recipe.getGlutenFree() == true)) {

				veganAndGFRecipes.add(recipe);
			}
		}
		return veganAndGFRecipes;
	}
	
	public List<Recipe> vegan() {
		List<Recipe> veganRecipes = new ArrayList<>();
		
		for (Recipe recipe : recipes) {
			if (recipe.getVegan() == true) {

				veganRecipes.add(recipe);
			}
		}
		return veganRecipes;
	}
	
	public List<Recipe> vegetarian() {
		List<Recipe> vegetarianRecipes = new ArrayList<>();
		
		for (Recipe recipe : recipes) {
			if (recipe.getVegetarian() == true) {

				vegetarianRecipes.add(recipe);
			}
		}
		return vegetarianRecipes;
	}
}
