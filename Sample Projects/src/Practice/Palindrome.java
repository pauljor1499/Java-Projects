import java.util.*;
public class Palindrome {
    public static void main(String[] args) {
        Scanner x = new Scanner (System.in);
        String name,name1 = "";
        
        System.out.println("Enter word: ");
        name = x.next();
        
        int counts = name.length();
        
        for(int i= counts-1; i>=0; i--){
            name1 = name1 + name.charAt(i);
        }
        
        if(name.equalsIgnoreCase(name1)){
            System.out.println("The word is Palindrome.");
        }else{
            System.out.println("The word is not Palindrome.");
        }
        
        System.out.println(counts);
        System.out.println(name1);
    }
}
