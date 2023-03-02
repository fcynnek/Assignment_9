package com.fcynnek.Assignment_9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

@Service
public class FileService {
//Ingest a recipe.txt file and store this information in a Java Collection
	
	private String filename;
	
	public FileService() {
		
	}
	
	public List<String> readFile (String filename) throws IOException {
		Reader in = new FileReader("recipes.txt");
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", 
				"Preparation Minutes", "Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan", 
				"Vegetarian").parse(in); 
			
		for (CSVRecord record : records) {
			String cookingMins = record.get("Cooking Minutes");
		    Boolean dairy = record.get("Dairy Free");
		    String firstName = record.get("First Name");
		}
		
		return null;
	}
	
	
	
}
