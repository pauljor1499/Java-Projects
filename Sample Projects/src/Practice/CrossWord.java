
import java.util.*;
public class CrossWord {
    public static void main(String[] args) {
        Scanner x = new Scanner (System.in);
            
            String name1 = "";
            String name2 = "";
            

            for (int i = 0; i >=0 ; i++) {
                
            System.out.println("Enter a String1: ");
            String string1 = x.next();
            
                    if (string1.equalsIgnoreCase("STOP")) {
                    break;
                    
                    }else{        
                        name1 = name1 + string1;
                    }
            
            }

            for (int i = 0; i >=0 ; i++) {
                
                System.out.println("Enter a String2: ");
                String string2 = x.next();
                
                    if (string2.equalsIgnoreCase("STOP")) {
                    break;
                    
                    }else{        
                        name2 = name2 + string2;
                    }
            }
            
            for (int i = 0; i < name1.length(); i++) {
                
                if (name2.charAt(0)==name1.charAt(i)) {
                    System.out.println(name2);
                    String newname = name1.substring(i+1);//MAHAL/HALIK (SA 'H' KUTOB ANG COUNT SA i)
                    
                    for (int j = 0; j < newname.length(); j++) {
                        System.out.println(newname.charAt(j));
                    }
                    
                    System.exit(0);
                    
                }else{
                System.out.println(name1.charAt(i));
                }
            }
            
            
            
    }
}
