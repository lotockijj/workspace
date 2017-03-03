package com.main.fx;

import java.util.ArrayList;

public class Product {
	private ArrayList<Part> parts;
	private int productID;
	private String name;
	private double price;
	private int instock;
	private int min;
	private int max;
	
	public ArrayList<Part> getParts() {
		return parts;
	}
	public int getProductID() {
		return productID;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getInstock() {
		return instock;
	}
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public void setParts(ArrayList<Part> parts) {
		this.parts = parts;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setInstock(int instock) {
		this.instock = instock;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	protected void addPart(Part part){
		
	}
	
	protected boolean removePart(int id){
		return false;
	}
	
	protected Part lookupPart(int id){
		return null;
	}
	
	protected void updatePart(int id){
		
	}
	
}
