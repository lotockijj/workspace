package com.main.fx;

import java.util.ArrayList;

public class Inventory {
	ArrayList<Product> products;
	
	protected void addProduct(Product product){
		products.add(product);
	}
	
	protected boolean removeProduct(int id){
		if(products.size() > id){
			products.remove(id);
			return true;
		} else {
			return false;
		}
	}
	
	protected Product lookUp(int id){
		return products.get(id);
	}

	protected void updateProduct(int id){
	}
}
