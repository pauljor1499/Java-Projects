package SingleArrayExercise;

import java.util.*;
public class Problem4 {
    public static void main(String[] args) {
        Scanner x = new Scanner (System.in);
        
        String arr[] = new String [4];
        String arr2[] = new String [4];
        int totalscore = 0;
        
        System.out.println("Enter answer key: ");
        for(int i=0; i<arr.length; i++){
            arr[i]= x.next();
        }
        
        System.out.println("Enter student's answer: ");
        for(int j=0; j<arr2.length; j++){
            arr2[j] = x.next();
            
            if(arr2[j].equals(arr[j])){
                totalscore+=4;
            }else if(!arr2[j].equals(arr[j])){
                totalscore+=-1;
            }else if(arr2[j].equals("?")){
                totalscore+=0;
            }
        }
        System.out.println("The score is: "+ totalscore);
        
        
    }
}
