package com.fcynnek.Assignment_9.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FileService {
//Ingest a recipe.txt file and store this information in a Java Collection
	
	private String filename;
	
	public FileService() {
		
	}
	
	public List<String> readFile (String filename) throws IOException {
		return Files.readAllLines(Paths.get(filename));
	}
}
