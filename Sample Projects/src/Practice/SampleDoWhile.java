import java.util.*;
public class SampleDoWhile{
    public static void main(String[] args) {
        Scanner x = new Scanner (System.in);
        
        int total = 0;
        int s = 0;
        
        do{
            System.out.println("Input number:");
            s= x.nextInt();
            total += s;
        }while (s != 0);
            System.out.println(total);
            
    }
}
