import java.util.ArrayList;

public class Customer extends Person {
    private DataBase dataBase = new DataBase();
    
    private static ArrayList<Customer> customerList = new ArrayList<>();
    public String designation;
    public int salary;

    public Customer() {
        if (customerList.isEmpty()) {
            DataBase dataBase = new DataBase();
            dataBase.selectCustomer();  // Fetch employees from the database
            customerList = dataBase.getCustomer();  // Set the list of employees
        }
    }

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
        Customer cus = new Customer();
        
        // Set the fields of the Employee object
        cus.setName(name);
        cus.setContact(contact);
        // Add the Employee object to the ArrayList
        customerList.add(cus);
    }
    

    public static ArrayList<Customer> getcustomerList() {
        return customerList;
    }

}

