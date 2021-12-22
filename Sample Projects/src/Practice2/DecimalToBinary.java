
package Practice2;

import java.util.*;
public class DecimalToBinary {
    //MALI NI OY

    public static void main(String[] args) {

        Scanner x = new Scanner (System.in);
        
        System.out.println("Enter Decimal: ");
        int num = x.nextInt();
        
        for(;;){
            if (num>1) {
                System.out.print(num%2);
                num = num/2;
            }else{
                System.exit(0);
            }

        }

        
        
        }
}
