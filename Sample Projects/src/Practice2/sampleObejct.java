package Practice2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class sampleObejct {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        sampleController sample = new sampleController();

        sampleMenu candies = new sampleMenu("Candy",10);
        sampleMenu chips = new sampleMenu("Chips",20);

        
        sample.update(candies,"Yogurt",30);
        sample.product(chips);
    }
    
    
}
