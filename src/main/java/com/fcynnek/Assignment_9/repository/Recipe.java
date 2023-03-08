package com.fcynnek.Assignment_9.repository;

public class Recipe {

	private Boolean dairyFree;
	private Boolean glutenFree;
	private Boolean vegan;
	private Boolean vegetarian;
	private String title;
	private Double spoonacularScore;
	private Integer servings;
	private Double pricePerServing;
	private Double preparationMinutes;
	private Integer cookingMinutes;
    private Integer readyInMinutes;
    private String instructions;
	
    
    
    
	public Recipe(String title, Double spoonacularScore, Integer servings, Double pricePerServing,  
			 Double preparationMinutes, Integer cookingMinutes, Integer readyInMinutes, String instructions) {
		super();
		this.title = title;
		this.spoonacularScore = spoonacularScore;
		this.servings = servings;
		this.pricePerServing = pricePerServing;
		this.preparationMinutes = preparationMinutes;
		this.cookingMinutes = cookingMinutes;
		this.readyInMinutes = readyInMinutes;
		this.instructions = instructions;
	}
	
	


	@Override
	public String toString() {
		return "Recipe [dairyFree=" + dairyFree + ", glutenFree=" + glutenFree + ", vegan=" + vegan + ", vegetarian="
				+ vegetarian + ", title=" + title + ", spoonacularScore=" + spoonacularScore + ", servings=" + servings
				+ ", pricePerServing=" + pricePerServing + ", preparationMinutes=" + preparationMinutes
				+ ", cookingMinutes=" + cookingMinutes + ", readyInMinutes=" + readyInMinutes + ", instructions="
				+ instructions + "]";
	}




	public Integer getCookingMinutes() {
		return cookingMinutes;
	}
	public Boolean getDairyFree() {
		return dairyFree;
	}
	public Boolean getGlutenFree() {
		return glutenFree;
	}
	public String getInstructions() {
		return instructions;
	}
	public Double getPreparationMinutes() {
		return preparationMinutes;
	}
	public Double getPricePerServing() {
		return pricePerServing;
	}
	public Integer getReadyInMinutes() {
		return readyInMinutes;
	}
	public Integer getServings() {
		return servings;
	}
	public Double getSpoonacularScore() {
		return spoonacularScore;
	}
	public String getTitle() {
		return title;
	}
	public Boolean getVegan() {
		return vegan;
	}
	public Boolean getVegetarian() {
		return vegetarian;
	}
	
	
	
	
	public void setCookingMinutes(Integer cookingMinutes) {
		this.cookingMinutes = cookingMinutes;
	}
	public void setDairyFree(Boolean dairyFree) {
		this.dairyFree = dairyFree;
	}
	public void setGlutenFree(Boolean glutenFree) {
		this.glutenFree = glutenFree;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public void setPreparationMinutes(Double preparationMinutes) {
		this.preparationMinutes = preparationMinutes;
	}
	public void setPricePerServing(Double pricePerServing) {
		this.pricePerServing = pricePerServing;
	}
	public void setReadyInMinutes(Integer readyInMinutes) {
		this.readyInMinutes = readyInMinutes;
	}
	public void setServings(Integer servings) {
		this.servings = servings;
	}
	public void setSpoonacularScore(Double spoonacularScore) {
		this.spoonacularScore = spoonacularScore;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setVegan(Boolean vegan) {
		this.vegan = vegan;
	}
	public void setVegetarian(Boolean vegetarian) {
		this.vegetarian = vegetarian;
	}
    
}
