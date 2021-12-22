package SampleOOP;


import java.util.*;
import javax.swing.*;
//Pang isa lang ni ka person.
//FINAL
public class NewMain2 {

    public static void main(String[] args) {
        
        Person person = new Person();
        ArrayList <Person> Sample = new ArrayList();
        
        for (;;) {

        String details = "Press 1: Add Person\nPress 2: View Phonebook\nPress 3: Search Person\nPress 4: Close";

        String name = "";
        String address = "";
        int age = 0;
        String phone = "";
        
        String input = JOptionPane.showInputDialog(null, details);
        if (input.equals("1")) {
            name = JOptionPane.showInputDialog(null,"Enter your name: ");
                person.setName(name);
            address = JOptionPane.showInputDialog(null,"Input your address: ");
                person.setAddress(address);
            age = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter your age: "));
                person.setAge(age);
            phone = JOptionPane.showInputDialog(null,"Enter your phone number: ");
                person.setMobilePhone(phone);
            
            Sample.add(person);
                
            JOptionPane.showMessageDialog(null, "Successfully added.");
                
        }else if (input.equals("2")) {//VIEW
            if (Sample.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Person.");
            }else{
                String view = ""; //method para sa initialization
                //for(Person sampleperson : Sample){//kang sir na loop // pwede ra gud wala
                    view = view + "\nName: "+ person.getName()+"\nAddress: "+person.getAddress()
                            +"\nAge: "+person.getAge()+"\nMobile number: "+person.getMobilePhone();
                //}
                JOptionPane.showMessageDialog(null, view);// output sa view
                
            }
            
        }else if (input.equals("3")) {//SEARCH
            String search = JOptionPane.showInputDialog(null,"Search Name: ");
            Person found = null;
            String view = "";
                if (Sample.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Invalid search.");
                }else{
                    for (Person sampleperson : Sample){
                        if (person.getName().toLowerCase().contains(search.toLowerCase())) {
                            found = sampleperson;
                        }
                    }
                    
                    if (found!=null) {
                        view = view + "\nName: "+ person.getName()+"\nAddress: "+person.getAddress()
                            +"\nAge: "+person.getAge()+"\nMobile number: "+person.getMobilePhone();
                        
                        JOptionPane.showMessageDialog(null, view);
                    }else{
                        JOptionPane.showMessageDialog(null, "Person not found.");
                    }
                    
                }
        }else if (input.equals("4")) {//CLOSE
            System.exit(0);
        }else{
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }

        }//Mother loop
        
    }
}
