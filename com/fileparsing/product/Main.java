package com.fileparsing.product;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try {
            List<Product> products =
                ProductFileReader.readProducts("PRODUCTS.csv");

       
            // Most expensive product per category
            Map<String, Product> mostExpensiveByCategory =
                products.stream()
                        .collect(Collectors.groupingBy(
                            Product::getCategory,
                            Collectors.collectingAndThen(
                                Collectors.maxBy(
                                    Comparator.comparingDouble(Product::getPrice)
                                ),
                                Optional::get
                            )
                        ));
            
            // Print result
            mostExpensiveByCategory.forEach((k, v) ->
                System.out.println(k + " -> " + v)
            );

        } catch (InvalidProductFormatException e) {
            System.err.println("CSV data error: " + e.getMessage());
        } catch(ProductParsingRuntimeException e) {
        	System.err.println("NoSuchFileException:"+e.getMessage());
        }
    }
}
