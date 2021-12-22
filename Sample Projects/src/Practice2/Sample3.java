package Practice2;

import java.util.*;

public class Sample3 {
    
    public static void main(String[] args) {
        
        String arr[] = {"D","O","G"};
        String name = "";
        
        Random random = new Random();
        
        for (int i = 0; i < arr.length; i++) {
            int value = random.nextInt(2);
            arr[value].equals(name.charAt(i));
        }
        
        if (name.equals("DOG")) {
            System.out.println("You win!");
        }else{
            System.out.println("Better luck next time!");
        }
        
        System.out.println(name);
        
        
    }
    
    
    
}