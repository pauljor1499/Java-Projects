
import java.util.Scanner;

public class OrderingSystem {
    public static void main(String args[]){
    
        Scanner s = new Scanner(System.in);
            
            String A = "Tanduay", B = "Red Horse", C = "Emperador", order, confirm1;
            int quantity, quantitynew = 0;
            double a1, b1, c1, total, totalnew = 0.00;
            
            System.out.println("------------------ MENU -----------------");
            System.out.println("*                                       *");
            System.out.println("*  Code    Item                 Price   *");
            System.out.println("*                                       *");
            System.out.println("*   A.     Tanduay          PHP 100.00  *");
            System.out.println("*   B.     Red Horse         PHP 90.00  *");
            System.out.println("*   C.     Emperador        PHP 105.00  *");
            System.out.println("*                                       *");
            System.out.println("-----------------------------------------");
            System.out.println("Please enter the code of your Order");
            order = s.next();
            
            for(int i = 0; i >= 0 ; i++){
            
            switch(order){
            
                case"A":
                    a1 = 100;                    
                    System.out.println("How much would you like to buy?");
                    quantity = s.nextInt();
                    total = quantity * a1;
                    quantitynew = quantitynew += quantity;
                    totalnew = totalnew += total;
                    System.out.println("You Ordered "+quantity+"x "+A+" For PHP "+ total);
                    System.out.println("Total : PHP "+totalnew);
                    System.out.println("Any Additional Order? Y/N");
                    confirm1 = s.next();
                    
                    
                        
                        switch(confirm1){
                              
                            case"Y":
                                
                                System.out.println("What would you like to add?");
                                order = s.next();
                                break;
                               
                            case"N":
                                
                                for(int x = 0; x >= 0 ; x++){
                                
                                System.out.println("Please Enter Your Cash");
                                double cash = s.nextDouble();
                                double change = cash - totalnew;
                                
                                    
                                    
                                    if(cash >= totalnew){
                                        System.out.println("----------------------------------");
                                        System.out.println("Total Number of Items : " + quantitynew);
                                        System.out.println("Total Amount of Items : " + totalnew);
                                        System.out.println("Cash                  : " + cash);
                                        System.out.println("Change                : " + change);
                                        System.out.println("----------------------------------");
                                        System.exit(0);
                                    }else if(totalnew > cash){
                                        System.out.println("Insufficient Cash! Please try again.");
                                    } 
                   
                            }
                        }
                break;
                        
                case"B":
                    b1 = 90;                    
                    System.out.println("How much would you like to buy?");
                    quantity = s.nextInt();
                    total = quantity * b1;
                    quantitynew = quantitynew += quantity;
                    totalnew = totalnew += total;
                    System.out.println("You Ordered "+quantity+"x "+B+" For PHP "+total);
                    System.out.println("Total : PHP "+totalnew);
                    System.out.println("Any Additional Order? Y/N");
                    confirm1 = s.next();
  
                        switch(confirm1){
                              
                            case"Y":
                                
                                System.out.println("What would you like to add?");
                                order = s.next();
                                break;
                               
                            case"N":
                                
                                for(int x = 0; x >= 0 ; x++){
                                
                                System.out.println("Please Enter Your Cash");
                                double cash = s.nextDouble();
                                double change = cash - totalnew;
                                
                                    
                                    
                                    if(cash >= totalnew){
                                        System.out.println("----------------------------------");
                                        System.out.println("Total Number of Items : " + quantitynew);
                                        System.out.println("Total Amount of Items : " + totalnew);
                                        System.out.println("Cash                  : " + cash);
                                        System.out.println("Change                : " + change);
                                        System.out.println("----------------------------------");
                                        System.exit(0);
                                    }else if(totalnew > cash){
                                        System.out.println("Insufficient Cash! Please try again.");
                                    } 
                   
                            }
                        }
                break;
                        
                case"C":
                    c1 = 105;                    
                    System.out.println("How much would you like to buy?");
                    quantity = s.nextInt();
                    total = quantity * c1;
                    quantitynew = quantitynew += quantity;
                    totalnew = totalnew += total;
                    System.out.println("You Ordered "+quantity+"x "+C+" For PHP "+total);
                    System.out.println("Total : PHP "+totalnew);
                    System.out.println("Any Additional Order? Y/N");
                    confirm1 = s.next();
             
     
                        switch(confirm1){
                              
                            case"Y":
                                
                                System.out.println("What would you like to add?");
                                order = s.next();
                                break;
                               
                            case"N":
                                
                                for(int x = 0; x >= 0 ; x++){
                                
                                System.out.println("Please Enter Your Cash");
                                double cash = s.nextDouble();
                                double change = cash - totalnew;
                                
                                    
                                    
                                    if(cash >= totalnew){
                                        System.out.println("----------------------------------");
                                        System.out.println("Total Number of Items : " + quantitynew);
                                        System.out.println("Total Amount of Items : " + totalnew);
                                        System.out.println("Cash                  : " + cash);
                                        System.out.println("Change                : " + change);
                                        System.out.println("----------------------------------");
                                        System.exit(0);
                                    }else if(totalnew > cash){
                                        System.out.println("Insufficient Cash! Please try again.");
                                    } 
                   
                            }
                        }        
            
                break;
                
            default:
            System.out.println("Invalid Input!");
            System.exit(0);
            
            }
   
        }
            
    }
    
}