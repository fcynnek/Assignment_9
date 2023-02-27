package com.fcynnek.Assignment_9.repository;

public class Recipe {

	private Integer cookingMinutes;
    private Boolean dairyFree;
    private Boolean glutenFree;
    private String instructions;
    private Double preparationMinutes;
    private Double pricePerServing;
    private Integer readyInMinutes;
    private Integer servings;
    private Double spoonacularScore;
    private String title;
    private Boolean vegan;
    private Boolean vegetarian;
	
    
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
