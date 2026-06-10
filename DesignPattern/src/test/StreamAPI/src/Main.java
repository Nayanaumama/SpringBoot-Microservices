import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (Integer i : list) {
            System.out.println(i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);

        }
        System.out.println("List size is " + "" + list.size());
        List<Integer> list1 = list.stream().map((a) -> a + 5).collect(Collectors.toList());
        for (Integer i : list1) {
            System.out.println(i);
        }
        list.stream().filter((a) -> a >= 5).forEach(System.out::println);

        MethodReferenceInterface me = MethodReferenceClass::task;
        me.doTask();

        MethodReferenceClass obj1 = new MethodReferenceClass();
        MethodReferenceInterface me1 = obj1::work;// this is instance refernece
        //created object of the class and then refering to the instance method for that interface method
        //implementation

        me1.doTask();

        Runnable r = obj1::doStuff;

        r.run();//this just calls the doStuff method in the main thread itself
        Thread thread = new Thread(r);
        thread.start();//creates new thread and runs the method
        //this is static method reference
        //here refering to the static method of class MethodReferenceClass .
        //for the method reference the rule is to have the same argument
        //return type can be different in interface method and refering method

        MethodReferenceInterface me2=MethodReferenceClass::new;//this is the constructor reference
        me2.doTask();

    }

    }
