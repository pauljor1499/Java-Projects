import java.util.*;
    public class ScrambledLetters{
        public static void main(String[] args) {
            Scanner x = new Scanner (System.in);
            Random random = new Random();
            ArrayList newWord = new ArrayList();
            
            ArrayList array1 = new ArrayList ();
            array1.add("A");array1.add("a");
            array1.add("E");array1.add("e");
            array1.add("I");array1.add("i");
            array1.add("U");array1.add("o");
            array1.add("O");array1.add("u");
            
            ArrayList vows2 = new ArrayList();
            ArrayList cons2 = new ArrayList();
            ArrayList vows = new ArrayList();
            int countvows =0;
            ArrayList cons = new ArrayList();
            int countcons =0;
            ArrayList arrname = new ArrayList();
            String name = "";
 
            System.out.println("Enter size: ");
            int size = x.nextInt();

            for (int i = 0; i < size; i++) {
                System.out.println("Enter letter "+i);
                name = x.next();
                arrname.add(name);
                
                if (array1.contains(name)) {
                    countvows++;
                    vows.add(name);
                    vows2.add(name);
                }else{
                    countcons++;
                    cons.add(name);
                    cons2.add(name);
                }
            }
            
            
            for (int i = 0; i>=0; i++) {

                if (countvows == 0 || countcons == 0) {
                    System.exit(0);
                }
                
            int value = random.nextInt(size);
            newWord.add(arrname.get(value));
            arrname.remove(arrname.get(value));
            size--;
            
            if (vows.contains(newWord.get(newWord.size()-1))) {
                vows.remove(newWord.get(newWord.size()-1));
                countvows--;
                
                int value2 = random.nextInt(countcons);
                newWord.add(cons.get(value2));

                if (cons2.contains(newWord.get(newWord.size()-1))) {
                    newWord.remove(newWord.get(newWord.size()-1));
                    
                }else if(vows2.contains(newWord.get(newWord.size()-1))){
                    cons.remove(cons.get(value2));
                    countcons--;
                    size--;
                    
                }///
                
            }else if (cons.contains(newWord.get(newWord.size()-1))) {
                cons.remove(newWord.get(newWord.size()-1));
                countcons--;
                
                int value3 = random.nextInt(countvows);
                newWord.add(vows.get(value3));

                if (vows2.contains(newWord.get(newWord.size()-1))) {
                    newWord.remove(newWord.get(newWord.size()-1));
                    
                }else if(cons2.contains(newWord.get(newWord.size()-1))){//Mao ni basta Arraylist or LinkedList
                   
                    vows.remove(vows.get(value3));
                    countvows--;
                    size--;
                    
                }
                
            }else if (newWord.get(newWord.size()-1).equals(newWord.get(newWord.size()-2))) {
                    newWord.remove(newWord.get(newWord.size()-1));
                }

            System.out.println(newWord);
            }

            //System.out.println(arrname);
            
            //System.out.println(newWord.get(newWord.size()-1));
            //System.out.println(size);
            
        }
    }