
import java.util.*;

public class Diamond{

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        int rows, i, j, space = 1;
        System.out.println("Enter number of rows: ");
        
        rows= x.nextInt();
        
        space = rows-1;
        
        for(j=1; j<=rows; j++){
            
            for(i=1; i<=space; i++){
                System.out.print(" ");
            }
            
            space--;
            
            for(i=1; i<=2*j-1; i++){
                System.out.print("*");
            }
            System.out.println("");
        }
        
        /*
        space=1;
      
        
        for(j=1; j<=rows-1; j++){
            
            for(i=1; i<=space; i++){
                System.out.print(" ");
            }
            
                space++;
                
            for(i=1; i<=2 *(rows-j)-1; i++){
            System.out.print("*");
            }
            
            System.out.println("");
        }
        */
        
    }
}
