/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimplePhoneBook.util;

/*import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
*/

import SimplePhoneBook.model.Person;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author OOP-Jor
 */
public class PhonebookUtil {
    
    private static final String DEFAULT__SEPARATOR = ",";
    
    public static void  saveContacts ( Writer w, List<Person> values) throws IOException {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("Name:");
        sb.append(DEFAULT__SEPARATOR);
        sb.append("Gender:");
        sb.append(DEFAULT__SEPARATOR);
        sb.append("Age: ");
        sb.append(DEFAULT__SEPARATOR);
        sb.append("Phone Number:");
        sb.append(DEFAULT__SEPARATOR);
        sb.append("\n");
        
        for ( Person value: values){
            sb.append(value.getName());
            sb.append(DEFAULT__SEPARATOR);
            sb.append(value.getGender());
            sb.append(DEFAULT__SEPARATOR);
            sb.append(value.getAge());
            sb.append(DEFAULT__SEPARATOR);
            sb.append(value.getPhonenumber());
            sb.append("\n");
        }
        
        w.append(sb.toString());

    }
    
    public static ArrayList<Person> loadContacts(String fileName) throws FileNotFoundException{
        
        Scanner scanner = new Scanner (new File(fileName));
        ArrayList<Person> records = new ArrayList<>();
        
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            Person p = getRecordFromLine(str);
            if(p != null){
                records.add(p);
            }
        }
        return records;
        
    }

    private static Person getRecordFromLine(String line) {
        Person p = null;
        try{
            Scanner rowScanner = new Scanner (line);
            rowScanner.useDelimiter(DEFAULT__SEPARATOR);
            while (rowScanner.hasNext()){
                p = new Person();
                p.setName(rowScanner.next());
                p.setGender(rowScanner.next());
                p.setAge(Integer.parseInt(rowScanner.next()));
                p.setPhonenumber(rowScanner.next());
            }
        }catch (Exception ex){
            Logger.getLogger(PhonebookUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
            return p;
    }
    
}//class
