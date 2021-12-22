package Practice2;


public class SampleLoadingScreen {

    
    public static void main(String[] args) {
        try{
            
        for (int i = 0; i < 100; i++) {
            Thread.sleep(100);//Kapaspason mahuman ang loop
            System.out.println(i+"%");
            if (i==100) {
                System.exit(0);
            }
        }
        
        }catch(Exception e){
            
        }
    }
    
}
