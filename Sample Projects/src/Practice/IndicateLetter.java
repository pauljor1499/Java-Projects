import java.util.*;
public class IndicateLetter {
    public static void main(String[] args) {
        Scanner x = new Scanner (System.in);
        ArrayList sample = new ArrayList();
       int counts =0;
       
       
        System.out.println("Enter word: ");
        String name = x.next();
        
        char charname = 'b' ;
        char charname2 = 'B';
        
        for(int i=0; i<name.length(); i++){
            if(charname==(name.charAt(i))){
                counts++;
            }else if(charname2==(name.charAt(i))){
                counts++;
            }else{
                
            }
        }
        System.out.println(counts);
        }  
    }
