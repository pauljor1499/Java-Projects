package Practice2;


import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class HowToUseFileWriter {
    //FILEWRITER ANG MAGBUHAT UG FOLDER
    //FILE (KUNG BASAHON ANG TXT)
    //FILEWRITER (KUNG MAGBUTANG UG TXT)
    
    //NOTE : DILI MUREAD ANG FILEWRITER UG FOLDER
    
    /*public static void main(String[] args) { //Creating FileWriter
        try{
    
        FileWriter file1 = new FileWriter ("D:\\Axe\\"+"sample1"+".txt",true);
    
        }catch(Exception e){
            System.out.println("Ewew!");
        }
    }*/
    
    /*public static void main(String[] args) { //Searching a Text in a File
       
        
     File file2 = new File ("D:\\Axe\\FileSample.txt");
     
     try{
         
         Scanner x = new Scanner (file2);
         
         while(x.hasNextInt()){
             
             int num2 = x.nextInt();
             
             System.out.println(num2);
         }
         
         while(x.hasNext()){
             String name2 = x.next();

         }
     }catch(Exception e){
         System.out.println("Wewa!");
     }

    }*/
    
    /*public static void main(String[] args) {//Creating a file (not yet finished)
        
        File file3 = new File("D:\\Axe\\Sample");
        
        Scanner y = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name1 = y.next(); 
        
        try{
            
            Scanner x = new Scanner (file3);
            
            while(x.hasNext()){
                String name2 = x.next();
                
                if (name2.equalsIgnoreCase(name1)) {
                    System.out.println("SorryFiled");
                }else if (!name2.equalsIgnoreCase(name1)) {
                    
                    try{
                        FileWriter write = new FileWriter("D:\\Axe\\Sample\\"+name1+".txt");
                        System.out.println("Success!");
                        
                        write.write("Sampleeeeee!!");
                        write.close();
                        
                    }catch(Exception e){
                        System.out.println("Sorry.");
                    }
                    
                    
                }else{
                    
                }
            }
            
        }catch(Exception e){
            System.out.println("Sorry");
        }
    }*/
    
    public static void main(String[] args) {
        
        Scanner y = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name1 = y.next();
        
        File file1 = new File("D:\\FileSample.txt");
        
        try{
            FileWriter Fwrite2 = new FileWriter ("D:\\FileSample.txt",true); //FILEWRITER DAPAT GAMITON
            Scanner x = new Scanner (file1);
            
            while(x.hasNext()){
                
                String name2 = x.next();
                //System.out.println(name2);
                if (name2.equals(name1)) {
                    System.out.println("SorryPalpakhehe");
                    
                }else if(!name2.equals(name1)){

                    try{
                        //FileWriter Fwrite = new FileWriter ("D:\\Axe\\Sample\\"+name1+".txt",true);
                        System.out.println("Success!");

                        Fwrite2.write(name1);
                        Fwrite2.write(System.getProperty("line.separator"));//Separation
                        Fwrite2.close();
                        
                    }catch(Exception e){
                        System.out.println("Sorry.");
                    }
                    
                }else{
                    
                }
                
            }
            
            //FileWriter Fwrite = new FileWriter ("D:\\Axe\\Sample\\"+"Sample111.txt",true);
            
        }catch(Exception e){
            System.out.println("Wew");
        }
        
        
        
    }
    
}
