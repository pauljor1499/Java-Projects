/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice2;

/**
 *
 * @author admin
 */
public class sampleMenu {

    public sampleMenu(String n, int p){
        name = n;
        price = p;
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
    
    private String name;
    private int price;
    

    
}
