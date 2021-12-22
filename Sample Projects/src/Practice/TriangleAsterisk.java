//TRIANGLE ASTERISK
public class TriangleAsterisk {
    public static void main(String[] args) {
        
     int top = 1;
     int size = 5;
     int space = size-1;
     
    for (int i=0; i<size; i++){
        
        for (int j=space; j>i; j--){
             System.out.print(" ");
             //left na space sa triangle
        }
        
        for (int k=0; k<top; k++){
         System.out.print("*");
        }
         top += 2;
        System.out.println("");
        //right na space sa triangle
    }
}
}
