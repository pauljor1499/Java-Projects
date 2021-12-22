package SampleOOP;

import java.util.*;
import javax.swing.JOptionPane;

public class Sample {
    
    public static void main(String[] args) {

        ArrayList Sample = new ArrayList();
        ArrayList names = new ArrayList();
        
        for (;;) {
            
        String details = "Press 1: Add Person\nPress 2: View Phonebook\nPress 3: Search Person\nPress 4: Delete\nPress 5: Close";

        String name = "";
        String address = "";
        int age = 0;
        String phone = "";
        String list = "";
        
        String input = JOptionPane.showInputDialog(null, details);
        if (input.equals("1")) {
                name = JOptionPane.showInputDialog(null,"Enter your name: ");
            address = JOptionPane.showInputDialog(null,"Input your address: ");
            age = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter your age: "));
            phone = JOptionPane.showInputDialog(null,"Enter phone number: ");
            list = list + "\nName: "+name+ "\nAddress: "+address+ "\nAge: "+age+"\nPhone number: "+phone;
            
            Sample.add(list);
            names.add(name);
            
            JOptionPane.showMessageDialog(null, "Successfully added.");

        }else if (input.equals("2")) {//VIEW
            if (Sample.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Person.");
            }else{
                
                for (int i = 0, j=1 ; i < Sample.size(); i++, j++) {
                    JOptionPane.showMessageDialog(null,"Person ("+j+")\n"+Sample.get(i));
                }
                
            }
            
        }else if (input.equals("3")) {//SEARCH
            String search = JOptionPane.showInputDialog(null,"Search Complete Name: ");

                if (Sample.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No contacts.");
                    
                }else{
                    
                    for (int i = 0; i < names.size(); i++) {
                        if (names.get(i).equals(search.toLowerCase())) {
                            JOptionPane.showMessageDialog(null,Sample.get(i));
                            break;
                        }else{
                            JOptionPane.showMessageDialog(null, "Invalid input.");
                            break;
                        }
                    }
                    
                }
        }else if (input.equals("4")) {//CLOSE
            String delete = JOptionPane.showInputDialog(null,"Enter name to delete: ");
            if (names.contains(delete.toLowerCase())) {
                names.remove(delete);
                Sample.remove(delete.toLowerCase());
            }else{
                JOptionPane.showMessageDialog(null, "Invalid input.");
            }
        }else if (input.equals("5")){
            System.exit(0);
        }else{
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }

        }//Mother loop
    
}
}
