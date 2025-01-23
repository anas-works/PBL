import java.util.ArrayList;

public class Customer extends Person {
    private DataBase dataBase = new DataBase();
    
    public String designation;
    public int salary;

    public String getName() {
        return name;
    }

    public int getContact() {
        return contact;
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }


    void addCustomer(String name, int contact){
        dataBase.insertCustomers(name, contact);
    }

}

