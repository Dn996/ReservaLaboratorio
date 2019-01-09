package com.dnchamba.arqapp.rest.dao;

import com.dnchamba.arqapp.rest.database.DatabaseClass;
import com.dnchamba.arqapp.rest.model.Product;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Dayana
 */
public class ProductDAO {
    private static List<Product> products= DatabaseClass.getProducts();

    public ProductDAO() {
        products.add(new Product(1, "Pasta", 50));
        products.add(new Product(2, "Aceite", 40));
        products.add(new Product(3, "Atun", 30));
        products.add(new Product(4, "Sal", 70));
        products.add(new Product(5, "Azúcar", 20));
        products.add(new Product(6, "Sardina", 80));
        products.add(new Product(7, "Té", 10));
    }
    
    public List<Product> getProducts(){
        return products;
    }
    
    public Product getProduct(int id){
        Optional<Product> optProduct= products.stream().filter(p -> id == p.getIid()).findFirst();
              
         
        return optProduct.isPresent() ? optProduct.get() : null;
        
    }
    
    public Product addProduct(Product product) {
            product.setIid(getMax());
            products.add(product);
            return product;
    }
    
    private int getMax(){
        int size=products.size();
        if (size > 0) {
            return products.get(size-1).getIid()+1;          
        }else{
            return 1;
        }
    }
    
    public Product updateProduct(Product product){
        int pos = getPos(product.getIid());
        
        try {
            products.set(pos, product);
        } catch (Exception e) {
            return null;
        }
        return product;
    }
    
    private int getPos(int id){
        for (int i = 0; i< products.size(); i++){
            if (products.get(i).getIid()==id) {
                return i;
                
            }
        }
        return -1;
    }
    
    public boolean deleteProduct(int id){
        int pos = getPos(id);
        if(pos !=-1){
            products.remove(pos);
            return true;
        }
        return false;
    }
    
   /* public Product deleteProduct(int id){
        Optional<Product> optProduct= products.stream().filter(p -> id == p.getIid()).findFirst();
        return optProduct.
    }*/
}
