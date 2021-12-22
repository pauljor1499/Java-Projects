package Practice2;

import java.io.File;
import java.util.*;

public class Sample {
    public static void main(String[] args) {
        
        File file = new File ("C:\\Axe\\File2.txt");
        
        ArrayList sample = new ArrayList();
        
        ArrayList sample2 = new ArrayList();
        sample2.add(1);   sample2.add(2);
        sample2.add(3);   sample2.add(4);
        sample2.add(5);   sample2.add(6);
        sample2.add(7);   sample2.add(8);
        sample2.add(9);  
        
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int count = 0;

        try{
            Scanner x = new Scanner (file);
            
            while(x.hasNextInt()){
                int num = x.nextInt();
                
                if (num == 0) {
                break;

                }else{
                sample.add(num);
                count++;
                }
            }
            
        int min = (int) sample.get(0);
        int max = (int) sample.get(0);
        int max2 = max;
        
            for (int i = 0; i < count; i++) {
                
                if ((int) sample.get(i)>max) {
                    max = (int) sample.get(i);
                }else if((int) sample.get(i)<min){
                    min = (int) sample.get(i);
                }

                        if (sample2.contains(sample.get(i))) {

                            num2 = (int) sample.get(i);
                            num4 = i+1;
            
                            for (int j = num4; j < num2+num4; j++) {  
                                num3 += (int) sample.get(j);
                            }
                            System.out.println("Total: "+num3);
                            System.out.println("Average: "+num3/num2);
                            num2 = 0;
                            num3 = 0;
                            num4 = 0;
                        }
                    }
            System.out.println("Maximun number is: "+max);
            System.out.println("Minimum number is: "+min);
            
        }catch(Exception e){
            System.out.println("Error!");
        }
        
        
    }
}
