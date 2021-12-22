/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Sample1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Scanner x = new Scanner (System.in);
        
        System.out.println("Enter name: ");
        String name = x.next();
        
        FileWriter file = new FileWriter ("D:\\"+name+".txt");
    }
    
}
