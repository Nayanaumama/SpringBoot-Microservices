public class Employee {
    String name;
    int age;
    String address;

    public Employee(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;

    }
    public Employee() {
        this("Default", 0, "Default");
    }
    public String printEmployee() {
        System.out.println("Name: " + name + " Age: " + age + " Address: " + address);
        return "Name: " + name + " Age: " + age + " Address: " + address;
    }
}
