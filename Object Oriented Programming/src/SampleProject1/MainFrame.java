/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SampleProject1;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class MainFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner x = new Scanner (System.in);
        
        Product sample1 = new Product ("Pepsi",10);
        Product sample2 = new Product ("Coke", 11);
        
        System.out.println(sample1.getName()+" "+sample1.getPrice());
        sample2.Print();
        
    }
    
}
