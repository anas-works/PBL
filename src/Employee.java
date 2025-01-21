public class Employee extends Person {
    private DataBase employee = new DataBase();

    public String designation;
    public long salary;

    void addEmployee(String name, long contact, String address, String designation, long salary){
        employee.insertEmployee(name, contact, address, designation, salary);
    }


}
