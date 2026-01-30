package com.fileparsing.product;

public class Product {
	 	private int productId;
	    private String name;
	    private double price;
	    private String category;

	    public Product(int productId, String name, double price, String category) {
	    		if(productId<1) throw new ProductParsingRuntimeException("product id can't be negative"+productId);
	    		if(price<1) throw new ProductParsingRuntimeException("price can't be negative"+price);
	        this.productId = productId;
	        this.name = name;
	        this.price = price;
	        this.category = category;
	    }

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		@Override
		public String toString() {
			return productId + "|" + name + "|" + price + "|" + category;
		}
		
	    
}
