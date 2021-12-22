package Practice2;

import java.util.*;
public class Sample2 {
    public static void main(String[] args) {
     
        Scanner x = new Scanner (System.in);
        
        int size = 0;
        int count = 0;
        
        int arr[] = new int[size];
        int max = arr[0];
        int min = arr[0];
        
        for (int i = 0; i >= 0; i++) {
            String name = x.next();
            
            if (name.equalsIgnoreCase("stop")) {
                break;
            }else{
                size++;
                for (int j = 0; j < name.length(); j++) {
                    count++;
                }
                
                arr[i] = count;
                if (arr[i]>max) {
                    max = arr[i];
                }else if(arr[i]<min){
                    min = arr[i];
                }
            }
            
        }
        System.out.println(max);
        System.out.println(min);
        
    } 
}
