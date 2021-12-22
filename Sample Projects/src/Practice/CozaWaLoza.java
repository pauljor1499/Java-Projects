
import java.util.*;
public class CozaWaLoza {
    public static void main(String[] args) {
        Scanner x = new Scanner (System.in);
        
        String name, name2 = "";
        
        System.out.println("Enter name: ");
        name = x.next();
        name2 = name2 + name;
        
        System.out.println(name);
        System.out.println(name2);
        
        String newname = name2.substring(2);
        System.out.println(newname);
        String newname2 = newname.substring(0,2);
        System.out.println(newname2);
        
        
    }
}
