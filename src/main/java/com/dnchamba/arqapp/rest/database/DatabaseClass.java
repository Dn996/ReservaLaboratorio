package com.dnchamba.arqapp.rest.database;
import com.dnchamba.arqapp.rest.model.Product;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dayana
 */
public class DatabaseClass {
    private static List<Product> products = new ArrayList<Product>();
    
    public static List<Product> getProducts(){
        return products;
    }
}
