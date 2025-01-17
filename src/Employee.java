public class Employee extends Person {
    private DataBase employee = new DataBase();

    private String designation;
    private int salary;

    void addEmployee(String name, int contact, String address, String designation, int salary){
        employee.insertEmployee(name, contact, address, designation, salary);
    }


}
