package SingleArrayExercise;

import java.util.*;
public class Sample1 {
    public static void main(String[] args) {
        Scanner x = new Scanner (System.in);
        double counts =0;
        double counts2 =0;
        double counts3 =0;
        
        System.out.println("Enter number: ");
        double num = x.nextDouble();
        
        while(num>0)
        
            if(num>=1000){
                counts++;
                num-=1000;
            }else if(num>=500){
                counts2++;
                num-=500;
            }else if(num>=0.25){
                counts3++;
                num-=.25;
            }
            
            System.out.println("1000: "+(int)counts);
            System.out.println("500: "+(int)counts2);
            System.out.println(".25: "+counts3);
            
        
        }  
    }
