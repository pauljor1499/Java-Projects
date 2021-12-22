import java.util.*; 
public class CountingNumbers {
public static void main(String[] args){
    
    int[] arr = {5, 7, 2, 4, 9};
	int even = 0;
        int odd = 0;
	System.out.println("Original Array: "+Arrays.toString(arr)); 
	    
    for(int i = 0; i < arr.length; i++) {
        if(arr[i] % 2 == 0){         
          even++;
          
        }else
           odd++;	
        }                 
    System.out.printf("\nNumber of even elements in the array: %d",even);
    
	System.out.printf("\nNumber of odd elements in the array: %d",odd);
	System.out.printf("\n");	
  }
}