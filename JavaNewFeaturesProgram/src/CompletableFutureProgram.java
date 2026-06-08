import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CompletableFutureProgram {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Employee employee = new Employee("nbhag", 25, "Bangalore");
        Employee employee1 = new Employee("nayana", 26, "Mumbai");
        Employee employee2 = new Employee("navya", 27, "Delhi");
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletableFuture.runAsync(() -> System.out.println(employee.printEmployee()), executorService);
        CompletableFuture.runAsync(() -> System.out.println(employee1.printEmployee()), executorService);
        CompletableFuture.runAsync(() -> System.out.println(employee2.printEmployee()), executorService);
        CompletableFuture.supplyAsync(employee::printEmployee,executorService).thenAccept(System.out::println);
        executorService.shutdown();
        System.out.println("Done");
        System.exit(0);
        //CompletableFuture is used for Asynchronus programming.
        //That means you can start a task in the background ,continue other work and get the result later
        //In the normal future . when we call future.get() This is blocking.The current thread waits
        // until result is ready.
        //here in future we cannot say after this task finishes do next task ,
        //if it fails handle etc
        //But Completable future run Async task ,return result kater ,chain next step,handle errors
        //runAsync()-does not return value
        //supplyAsync()-returns a value
        //So when you use suppyAsyncwe can chain other methods like thenSupply(),thenAccept(),then tun() etc




    }
}