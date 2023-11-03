
package model;
//ID, Name, Email, Phone, Address. 
public class csvFile {
    private int ID;
    private String Name;
    private String Email;
    private String Phone;
    private String Address;
    
    public csvFile(){}
    
    public csvFile(int ID, String Name, String Email,String Phone,String Address){
        this.ID = ID;
        this.Name = Name;
        this.Email = Email;
        this.Phone = Phone;
        this.Address = Address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    
}
