package SingleArrayExercise;

import java.util.*;
public class Problem3 {
    public static void main(String[] args) {
        Scanner x = new Scanner (System.in);
        ArrayList sample = new ArrayList();
        
        int arr[]=new int[5];
        int counts = 0;
        
        System.out.println("Enter an array of numbers: ");
        for(int i=0; i<arr.length; i++){
            arr[i]= x.nextInt();
        }
        
        System.out.println("Enter count of even numbers: ");
        int count = x.nextInt();    
        
        for(int j=0; j<arr.length; j++){
        if(arr[j]%2==0){
            sample.add(arr[j]);
                    counts++;
                            if(counts==count){
                                System.out.println(sample);
                                break;
                            }
        }
        }
        
        
    }
}
