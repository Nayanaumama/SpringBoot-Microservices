public class Employee {
    String name;
    int Salary;
    Employee(String name, int Salary) {
        this.name = name;
        this.Salary = Salary;
    }

    interface BonusCaluculator
    {
       int BonusCaluculator(Employee e);

    }

    public String getName()
    {
        return this.name;
    }
}
