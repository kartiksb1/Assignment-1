package com.fileparsing.product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProductFileReader {

	public static List<Product> readProducts(String filePath)
			throws InvalidProductFormatException, ProductParsingRuntimeException {

		Path path = Paths.get(filePath);
		List<Product> products = new ArrayList<>();

		try (Stream<String> lines = Files.lines(path)) {

			boolean isHeader = true;

			for (String line : (Iterable<String>) lines::iterator) {

				if (isHeader) {
					isHeader = false;
					continue;
				}

				Product product = ProductParser.parse(line);
				products.add(product);
			}

		} catch (IOException e) {
			throw new ProductParsingRuntimeException("Failed to read file");
		}

		return products;
	}
}
