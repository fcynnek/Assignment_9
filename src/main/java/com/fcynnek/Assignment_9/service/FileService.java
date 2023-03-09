package com.fcynnek.Assignment_9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.fcynnek.Assignment_9.repository.Recipe;

@Service
public class FileService {
//Ingest a recipe.txt file and store this information in a Java Collection
	
	private String filename = "recipes.txt";
	List<Recipe> recipes = new ArrayList<>();

	
	public FileService() {
		
	}
	
	public List<Recipe> readFile (String filename) throws IOException {
		Reader in = new FileReader(filename);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withEscape('\\').withIgnoreSurroundingSpaces().withFirstRecordAsHeader().parse(in);
		for (CSVRecord record : records) {
			
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
	
	public List<Recipe> allRecipes() throws IOException  {
		readFile(filename);
		return recipes;
	}
	
	public List<Recipe> dairyFree() throws IOException {
		readFile(filename);
		List<Recipe> dairyFreeRecipes = new ArrayList<>();
		
		for (Recipe recipe : recipes) {
			if (recipe.getDairyFree() == true) {
				dairyFreeRecipes.add(recipe);
			}
		}
		return dairyFreeRecipes;
	}
	
	public List<Recipe> glutenFree() throws IOException {
		readFile(filename);
		List<Recipe> glutenFreeRecipes = new ArrayList<>();
		
		for (Recipe recipe : recipes) {
			if (recipe.getGlutenFree() == true) {
				glutenFreeRecipes.add(recipe);
			}
		}
		return glutenFreeRecipes;
	}
	
	public List<Recipe> veganAndGlutenFree() throws IOException {
		readFile(filename);
		List<Recipe> veganAndGFRecipes = new ArrayList<>();
		
		for (Recipe recipe : recipes) {
			if ((recipe.getVegan() == true) && (recipe.getGlutenFree() == true)) {
				veganAndGFRecipes.add(recipe);
			}
		}
		return veganAndGFRecipes;
	}
	
	public List<Recipe> vegan() throws IOException {
		readFile(filename);
		List<Recipe> veganRecipes = new ArrayList<>();
		
		for (Recipe recipe : recipes) {
			if (recipe.getVegan() == true) {
				veganRecipes.add(recipe);
			}
		}
		return veganRecipes;
	}
	
	public List<Recipe> vegetarian() throws IOException {
		readFile(filename);
		List<Recipe> vegetarianRecipes = new ArrayList<>();
		
		for (Recipe recipe : recipes) {
			if (recipe.getVegetarian() == true) {
				vegetarianRecipes.add(recipe);
			}
		}
		return vegetarianRecipes;
	}
}
