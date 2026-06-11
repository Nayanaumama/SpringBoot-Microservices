import java.util.Optional;

public class EmployeeOptional {
    int id;
    String name;

    public Optional<EmployeeOptional> getEmployeeOptional() {
        Optional<EmployeeOptional> employeeOptional = Optional.ofNullable(new EmployeeOptional());
        return employeeOptional;
    }
}
