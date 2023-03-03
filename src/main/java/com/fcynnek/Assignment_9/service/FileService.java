package com.fcynnek.Assignment_9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
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
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
		for (CSVRecord record : records) {
			Integer cookingMins = Integer.parseInt(record.get("Cooking Minutes")) ;
		    Boolean dairy = Boolean.parseBoolean(record.get("Dairy Free"));
		    Boolean gluten = Boolean.parseBoolean(record.get("Gluten Free"));
		    String instructions	= record.get("Instructions");
		    String prepMins	= record.get("Preparation Minutes");
		    Double priceServ	= Double.parseDouble(record.get("Price Per Serving"));
		    Integer readyMins	= Integer.parseInt(record.get("Ready In Minutes"));
		    Integer servings	= Integer.parseInt(record.get("Servings"));
		    Double score	= Double.parseDouble(record.get("Spoonacular Score"));
		    String title	= record.get("Title");
		    Boolean vegan	= Boolean.parseBoolean(record.get("Vegan"));
		    Boolean vegetarian	= Boolean.parseBoolean(record.get("Vegetarian"));
		}
		
		return null;
	}
	
	
	
}
