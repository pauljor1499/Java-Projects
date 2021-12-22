package Practice2;


import java.util.*;
public class Sample1 {
    public static void main(String[] args) {
        
        Scanner x = new Scanner (System.in);
        
        int arr[] = new int[10];
        int sum = 0;
        
        System.out.println("Enter numbers 1-100 :");
        for (int j = 0; j <arr.length; j++) {
            
            int num = x.nextInt();
            
            if (num<100) {
                arr[j] = num;
                sum+=arr[j];
            }else if (num<1){
                j--;
                System.out.println("Number out of range!");
            }else{
                j--;
                System.out.println("Number out of range!");
            }

        }
        System.out.println("Sum : "+sum);
        System.out.println("Average : "+(double)sum/10);
        
    }
}
