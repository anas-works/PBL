public class Employee extends Person {
    private DataBase employee = new DataBase();

    public String designation;
    public long salary;

    void addEmployee(String name, int contact, String address, String designation, long salary){
        employee.insertEmployee(name, contact, address, designation, salary);
    }


    void viewEmployee(String name, long contact, String address, String designation, long salary){
        employee.selectEmployee(name, contact, address, designation, salary);
        this.name = employee.name;
        this.contact = employee.contact;
        this.address = employee.address;
        this.designation = employee.designation;
        this.salary = employee.salary;
    }


}
