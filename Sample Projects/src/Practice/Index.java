import java.util.*;
public class Index {
    public static void main(String[] args) {
        Scanner x = new Scanner (System.in);
        
        int size = 0;
        int arr[] = new int [10];
        
        for (int i = 0; i >= 0; i++) {
            
            if (size==10) {
                break;
            }
            
            System.out.println("Enter number 1-10: ");
            int num = x.nextInt();
            
            if (num<1 || num>10) {
                System.out.println("Invalid input!");
            }else{
                arr[size] = num;
                size++;
            }
            
        }
        
        
        for (int i = 0; i >= 0; i++) {
            
            System.out.println("Enter number to search: ");
            int num2 = x.nextInt();
            
            if (num2>0 || num2<10) {
                
                for (int j = 0; j < arr.length; j++) {
                    
                    if (arr[j]==num2) {
                        System.out.println("You have found it in index "+j);
                        System.exit(0);
                    }
                }
                
            }else if (num2<1 || num2> 10){
                System.out.println("Number not found!");
            }
        }
        
        
        
    }
}
