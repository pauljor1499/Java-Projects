
package Practice2;

import java.io.*;
import java.util.*;

public class Basic_Data_Basing {

    public static void main(String[] args) {
        
        Scanner x = new Scanner (System.in);
        
        String name;
        
        System.out.println("Enter name: ");
        name = x.next();
        
        try{
    
        File sample = new File("D:\\SampleDataBase\\"+name+".txt");// Text file for new person
        File sample3 = new File("D:\\SampleDataBase");//Folder for my List
        
            if (sample.exists()) {
                System.out.println("This file is already existed.");
            }else if (!sample.exists()) {
                FileWriter sample2 = new FileWriter("D:\\SampleDataBase\\"+name+".txt"); 
            }

            for (int i = 0; i < sample3.listFiles().length; i++) {//Numbers of file existed
                System.out.println(i);
            }
            
        }catch(Exception e){
            
        }
        
        
        
    }
    
}
