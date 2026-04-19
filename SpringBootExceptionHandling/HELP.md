
    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployeesById(@PathVariable int id) {
        try
        {
            for (Employee employee : employees) {
                if (employee.getId() == id) {
                    return new ResponseEntity<>(employee,HttpStatus.CREATED);
                }
            }
            throw new EmployeeNotFoundException("Employee not found");


        } catch (EmployeeNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),"Employee not found");
            return  new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }

    }
This is the traditinal way of handling exception .Here I can see if there is anothe API throws the same exception and then Programmer have to handle the exception manually means again copy the same code in the another API try catch block .. So its biolerplate code .We can handle this using @ExceptionHandler . Define the exception in this handler method .It will handle everywher this exception thrown in the same class

This will handle exception using ExceptionHandle
@ExceptionHandler(EmployeeNotFoundException.class)
public ResponseEntity<?>employeeNotFoundExcpetionhandler(EmployeeNotFoundException ex) {
ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), "Employee not found");
ResponseEntity.notFound().build();
return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
}
}

Here the problem is Exception Handler is only for this controller if the same exception occurs in other controller then it is not handling .So best approch is to use the global exception handler


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> employeeNotFoundExcpetionhandler(EmployeeNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), "Employee not found");
        ResponseEntity.notFound().build();
        return new ResponseEntity<>(errorResponse, HttpStatus.FOUND);
    }

This is the global way of handling excpetion . Create seperate claass annoted that with @Restcontrolleradvice and define the exception in @ExceptionHandler method . We can define as many Excpetion we want in different exception handling method

