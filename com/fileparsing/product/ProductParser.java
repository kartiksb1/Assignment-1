package com.fileparsing.product;

import java.util.Arrays;

public class ProductParser {

	public static Product parse(String line) throws InvalidProductFormatException {
		final int PRODUCT_LINE_LENGTH = 4;
		String[] parts = line.split(",");

		if (parts.length < PRODUCT_LINE_LENGTH) {
			throw new InvalidProductFormatException("invalid product data " + line);
		}

		// resizing the product array
		resizeProductDetailsArray(parts);

		try {
			int id = Integer.parseInt(parts[0].trim());
			String name = parts[1].trim();
			double price = Double.parseDouble(parts[2].trim());
			String category = parts[3].trim();

			return new Product(id, name, price, category);

		} catch (NumberFormatException e) {
			throw new InvalidProductFormatException("Invalid number format: " + line);
		}
	}

	private static void resizeProductDetailsArray(String[] parts) {
		if(parts.length==4)return;
		String name="";
		for(int i=1;i<parts.length-2;i++)name+=parts[i];
		parts[1]=name;
		parts[2]=parts[parts.length-2];
		parts[3]=parts[parts.length-1];
	}
}
