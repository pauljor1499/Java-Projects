import java.util.*;
public class IncreasingDecreasing {
    public static void main(String[] args) {
     Scanner x = new Scanner (System.in);
        System.out.println("Enter array size: ");
        int size = x.nextInt();
        int arr[] = new int[size];
        
        for(int i=0; i<arr.length; i++){
            System.out.println("Enter index "+i);
            arr[i]= x.nextInt();
        }
        
        if(arr[arr.length-1]>arr[arr.length-2]){
            System.out.println("The number are increasing");
        }else if(arr[arr.length-1]>arr[arr.length-2]){
            System.out.println("The number are decreasing");
        }else if(arr[0] == arr[arr.length]){
            System.out.println("The number are stable");
        }
        
    }
}
