package Calculator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class ClassCal2 {
    /**
     * @return the Total
     */
    public double getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(double Total) {
        this.Total = Total;
    }
    
    private double Total;
    
    public double Add(double num1, double num2){
        setTotal(num1+num2);
        return num1+num2;
    }
    
    public double Subtract(double num1, double num2){
        setTotal(num1-num2);
        return num1-num2;
    }
    
    public double Multiply(double num1, double num2){
        setTotal(num1*num2);
        return num1*num2;
    }
    
    public double Divide(double num1, double num2){
        setTotal(num1/num2);
        return num1/num2;
    }
    
    public double Remainder(double num1){
        setTotal(num1*0.1);
        return num1;
    }
    
    public static String Remove(String name){
        
        //String result = StringUtils.substring(name,0,name.length()-1);
        return name;
    }

}
