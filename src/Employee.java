import java.util.ArrayList;

public class Employee extends Person {
    private DataBase dataBase = new DataBase();
    
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    public String designation;
    public int salary;

    public Employee() {
        if (employeeList.isEmpty()) {
            DataBase dataBase = new DataBase();
            dataBase.selectEmployee();  // Fetch employees from the database
            employeeList = dataBase.getEmployees();  // Set the list of employees
        }
    }

    public String getName() {
        return name;
    }

    public int getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getDesignation() {
        return designation;
    }

    public int getSalary() {
        return salary;
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    void addEmployee(String name, int contact, String address, String designation, int salary){
        dataBase.insertEmployee(name, contact, address, designation, salary);
    }
    

    public static ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

}
