import javax.swing.*;
import java.util.*;

public class Number1to50{

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        
    try{         
        int num1= Integer.parseInt(JOptionPane.showInputDialog(null,"Enter 1st Number: "));
            int num2= Integer.parseInt(JOptionPane.showInputDialog(null,"Enter 2nd Number: "));
            
    if(num1>=1 || num2>=1 || num1<=50 || num2<=50){  
  
    for(int i=num2; i>=num1; i--){
        System.out.println(i);
    }
    
    }else{
        System.out.println("Error");
        System.exit(0);
    
    }        
        
    }catch(Exception e){
        System.out.println("Error!");
    }   
        
    
    }
}
