package SingleArrayExercise;

import java.util.*;
public class SampleProb2 {
public static void main(String[] args) {
     Scanner x = new Scanner (System.in);
       ArrayList sample = new ArrayList();
       String arr [] = new String[3];
       int num1=0;
       int num2=0;
       int num3=0;
       
       for(int i=0; i<arr.length; i++){
       System.out.println("Input array of word/s: ");
       arr[i] = x.next();
       }
       
       for(int i=0; i<arr[0].length(); i++){
           num1++;
       }
       sample.add(arr[0]);
       
       for(int i=0; i<arr[1].length(); i++){
           num2++;
       }
       sample.add(arr[1]);
       
       for(int i=0; i<arr[2].length(); i++){
           num3++;
       }
       sample.add(arr[2]);
       
       System.out.println("Enter word size to ommit: ");
       int num = x.nextInt();
       
       if(num==num1){
           sample.remove(arr[0]);
           System.out.println(sample);
       }else if(num==num2){
           sample.remove(arr[1]);
           System.out.println(sample);
       }else if(num==num3){
           sample.remove(arr[2]);
           System.out.println(sample);
       }
       
       
    }
}