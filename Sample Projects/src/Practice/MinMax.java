
import java.util.Scanner;

class MinMaxExample { 
 
  public static void main(String args[]){
   Scanner x = new Scanner (System.in);
        
        System.out.println("Enter persons: ");
        int size = x.nextInt();
        int arr [] = new int [size];
        
        for(int i=0, p=1; i<arr.length; i++, p++){
        System.out.println("Enter person"+p+"s age: ");
        arr[i] = x.nextInt();
        }
        
        int min = arr[0];
        int max = arr[0];
        
        for(int j=0; j<arr.length; j++){
            if(arr[j]>max){
                max = arr[j];
            }else if(arr[j]<min){
                min = arr[j];
            }
        }
        System.out.println("Oldest: "+max);
        System.out.println("Youngest: "+min);
    }
}