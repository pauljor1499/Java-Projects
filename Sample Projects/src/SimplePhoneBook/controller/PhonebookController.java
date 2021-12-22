
package SimplePhoneBook.controller;

import java.util.ArrayList;
import SimplePhoneBook.model.Person;

/**
 *
 * @author OOP-Jor
 */
public class PhonebookController {
    
    private ArrayList <Person> personlist; //SET SA ARRAYLIST
    
    public PhonebookController(){//SET SA ARRAYLIST
        this.personlist = new ArrayList();
    }
    
    public ArrayList <Person> getPersonlist(){//GET
        return personlist;
    }
    
    public void setPersonlist(ArrayList<Person>personlist){//SET
        this.personlist = personlist;
    }   

    public void addContact(Person p){
        if (personlist != null){
            personlist.add(p);
            //System.out.println("Success!");
        }
    }
    
    public void removeContact(Person p){
        for (Person d: personlist){
            if (d.equals(p)) {
                personlist.remove(p);
                break;
            }
        }
        /*for (int i = 0; i < personlist.size(); i++) {
            if (personlist.get(i).equals(p)) {
                System.out.println(personlist.get(i));
                personlist.remove(personlist.get(i));
                break;
            }
        }*/
        
    }
        
    public void upadteContact(Person oldPerson, Person newPerson){
        for (Person p: personlist){
            if (p.equals(oldPerson)) {
                oldPerson.setName(newPerson.getName());
                oldPerson.setAge(newPerson.getAge());
                oldPerson.setGender(newPerson.getGender());
                oldPerson.setPhonenumber(newPerson.getPhonenumber());
                break;
            }
        }
    }
    
    private Person foundPerson;
    public Person search (String searchKey){
        foundPerson = null;
        searchKey = searchKey.trim().toLowerCase();
        for (Person p: personlist){
            if (p.getName().trim().toLowerCase().contains(searchKey)) {
                foundPerson = p;
                break;
            }
        }
        return foundPerson;
    }
    
    
    
}
