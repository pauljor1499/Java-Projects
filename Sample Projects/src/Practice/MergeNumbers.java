import java.util.*;
public class MergeNumbers{
    public static void main(String[] args) {
        Scanner x = new Scanner (System.in);
        ArrayList sample = new ArrayList();
        
        System.out.println("Enter size: ");
        int size = x.nextInt();
        String arr[] = new String [size];
        
        for (int i = 0; i <arr.length; i++) {
            System.out.println("Enter index "+i);
            arr[i] = x.next(); 
            
            if(sample.contains(arr[i])){
                
            }else{
                sample.add(arr[i]);
            }
            
        }
        System.out.println(sample);
       
        
    }
}