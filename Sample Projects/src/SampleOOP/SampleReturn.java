
public class SampleReturn {

    public static void main(String[] args) {
        Message();
        int num2 = Add(4);
    }
    
    public static void Message(){
        System.out.println("This is my message!");
    }
    
    public static int Add(int num){
        int num1 = num+10;
        System.out.println(num1);
        
        return num;
    }
    
    public int walk(int num3){
        int num = 5+num3;
        System.out.println(num);
        return num3;
    }
}
