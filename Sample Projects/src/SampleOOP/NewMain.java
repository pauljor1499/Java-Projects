package SampleOOP;

//2ND FRAME
import java.util.*;
import javax.swing.*;

public class NewMain {

    
    public static void main(String[] args) {
        
        ArrayList <Person> PersonList = new ArrayList();
        Scanner x = new Scanner (System.in);
        
        String name = "Ako";
        
        Person p = new Person();
        p.setName(name);

        PersonList.add(p);
        
        String view = "";
        for (Person person : PersonList) {
            view = view + "Name: "+ p.getName();
        }
        System.out.println(view);
        
        Person FoundPerson = null;
        String search = x.next();
            for (Person person : PersonList) {
            view = view + "Name: "+ p.getName();
                if (person.getName().toLowerCase().contains(search.toLowerCase())) {
                    FoundPerson = person; //And foundperson kay mahimo nag si person
                    System.out.println("Successful!");
                    break;
                }
            }
            view = "";
            if (FoundPerson != null) {
                view = view +"Name: " + FoundPerson.getName();
                System.out.println(view);
            }
}
}
