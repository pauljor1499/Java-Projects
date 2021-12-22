import java.util.*;
public class VowelsConsonants {
    public static void main(String[] args) {
        Scanner x = new Scanner (System.in);
        ArrayList sample = new ArrayList();
        sample.add("A");sample.add("a");
        sample.add("E");sample.add("e");
        sample.add("I");sample.add("i");
        sample.add("O");sample.add("o");
        sample.add("U");sample.add("u");
        
        ArrayList sample2 = new ArrayList();
        ArrayList sample3 = new ArrayList();
        
        int cons = 0;
        int vows = 0;
        
        System.out.println("Enter size: ");
        int size = x.nextInt();
        
        String arr[] = new String [size];
        
        for (int i = 0, j=1; i < arr.length;j++, i++) {
            System.out.println("Enter letter"+j);
            arr[i] = x.next();
            
            if (sample.contains(arr[i])) {
                vows++;
                    if(sample2.contains(arr[i])){
                        
                    }else{
                        sample2.add(arr[i]);
                    }
            }else{
                cons++;
                if(sample3.contains(arr[i])){
                        
                    }else{
                        sample3.add(arr[i]);
                    }
            }
        }
        System.out.println("Vowels are: "+sample2);
        System.out.println("Consonants are: "+sample3);
        System.out.println("Vowels: "+vows);
        System.out.println("Consonants: "+cons);
        
        
        
    }
}
