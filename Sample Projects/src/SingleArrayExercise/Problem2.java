package SingleArrayExercise;


import java.util.*;
public class Problem2{
    public static void main( String[] args ) {
       Scanner x = new Scanner (System.in);
     ArrayList sample = new ArrayList();
     
     String arr[] = new String [3];
     
     System.out.println("Input array of words: ");
     for(int i=0; i<arr.length; i++){
         arr[i]=x.next();
         sample.add(arr[i]);
     }
     
     System.out.println("Input word size to ommit: ");
     String ommit = x.next();
     
     if(ommit==arr[0]){
         sample.remove(arr[0]);
         System.out.println(sample);
     }else if (ommit == arr[1]){
         sample.remove(arr[1]);
         System.out.println(sample);
     }else if (ommit == arr[2]);
         sample.remove(arr[2]);
         System.out.println(sample);
         
         
    }
}
