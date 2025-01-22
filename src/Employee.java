import java.util.ArrayList;

public class Employee extends Person {

    public String designation;
    public int salary;

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
        DataBase dataBase = new DataBase();
        dataBase.insertEmployee(name, contact, address, designation, salary);
    }


    void viewEmployee(){
        DataBase dataBase = new DataBase();
        
        // Step 2: Fetch employees from the database and store in the ArrayList
        dataBase.selectEmployee();
        
        // Step 3: Get the ArrayList of Employee objects from DataBase
        ArrayList<Employee> employeeList = dataBase.getEmployees();
        
        // Step 4: Loop through the ArrayList and display each employee's data
        for (Employee emp : employeeList) {
            emp.show();
            System.out.println("------------------------------");
        }
    }

    void show() {
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Designation: " + getDesignation());
        System.out.println("Salary: " + getSalary());
    }



    public static void main(String[] args) {
       Employee e = new Employee();
       e.viewEmployee();
    }
}
