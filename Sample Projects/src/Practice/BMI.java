import java.util.*;
public class BMI {
    public static void main(String[] args) {
        Scanner x = new Scanner (System.in);
        
        for(int i=0; i>=0; i++){
            System.out.println("~•~•~•~•~•~•~•~•~•~•~•~•~•~•~•~•~");
        System.out.println("Enter your weight in kilograms: ");
        double weight = x.nextDouble();
        
        System.out.println("Enter height in meters: ");
        double height = x.nextDouble();
        
        double totalheight = height*height;
        double BMI = weight/totalheight;
        
        System.out.println("Your BMI: "+(int)BMI);
            
            for(int j=i; j<=i; j++){
            System.out.println("Do you want to try again? [Y/N]");
            String name = x.next();
            
                if(name.equalsIgnoreCase("N")){
                System.exit(0);
                }else if(name.equalsIgnoreCase("Y")){
                break;
                }else{
                    System.out.println("Error!");
                    System.exit(0);
                }
            }  
    }
        
        
}
}