/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SampleProject1;

/**
 *
 * @author admin
 */
public class Product {

//    @Override
//    public String toString() {
//        
//    }

    public Product(String name, int price) { //CONSTRUCTOR
        this.name = name;
        this.price = price;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
    public String Print(){
        
        System.out.println("HAHAHA");  //SAMPLE CODE RA NI
        return null;
        
    }
    
    
    private String name;
    private int price;
    
    
}
