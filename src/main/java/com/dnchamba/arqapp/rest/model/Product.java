package com.dnchamba.arqapp.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dayana
 */
@XmlRootElement
public class Product {
    private int id;
    private String name;
    private float cost;
    
    public Product() {
    }
    
    public Product(int id, String name, float cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public int getIid() {
        return id;
    }

    public void setIid(int iid) {
        this.id = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    

    
    
    
}
