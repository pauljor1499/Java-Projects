package SampleOOP;


import java.util.ArrayList;
import java.util.Scanner;
import jdk.nashorn.internal.runtime.JSType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Sample2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner x = new Scanner (System.in);
        System.out.println("Enter: ");
        int num = x.nextInt();
        
        if (JSType.isNumber(num)) {
            System.out.println("Number");
        }else{
            System.out.println("Not");
        }
        
    }
    
}
