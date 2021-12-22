/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice2;

import java.util.ArrayList;
import Practice2.sampleController;
/**
 *
 * @author admin
 */
public class sampleController {
    
    private ArrayList <sampleMenu> productList;
    
    public sampleController(){//SET SA ARRAYLIST
        this.productList = new ArrayList();
    }
    
    public void product(sampleMenu m){
        
        System.out.println(m.getName()+"    "+m.getPrice());
    }
    
    public void update(sampleMenu oldProduct, String newProduct, int newPrice){
        
        for(sampleMenu p: productList){
            if (p.equals(oldProduct)) {
                p.setName(newProduct);
                p.setPrice(newPrice);
                
                break;
            }
        }
//        System.out.println(oldProduct.s);
    }
    
//    public static void main(String args[]){
//        
//            ArrayList<sampleMenu>list = new ArrayList();
//        
//            for(sampleMenu p: list){
//            
//                System.out.println(p);
//            }
//        
//        }
    
}
