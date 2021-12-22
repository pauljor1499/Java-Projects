//FIRST FRAME
package SampleOOP;

public class Person {
    
    private String Name;
    private String Address;
    private int age;
    private String MobilePhone;

    public Person(String Name, String Address, int age, String MobilePhone) {
        this.Name = Name;
        this.Address = Address;
        this.age = age;
        this.MobilePhone = MobilePhone;
    }

    Person() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the MobilePhone
     */
    public String getMobilePhone() {
        return MobilePhone;
    }

    /**
     * @param MobilePhone the MobilePhone to set
     */
    public void setMobilePhone(String MobilePhone) {
        this.MobilePhone = MobilePhone;
    }
    
    
    
}
