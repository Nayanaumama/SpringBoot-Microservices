public class MethodReferenceClass {

    MethodReferenceClass(){
        System.out.println("MethodReferenceClass");
    }

    public static void task() {
        System.out.println("Hello World");
    }

    public void work() {
        System.out.println("Hello Good Morning");
    }

    public void doStuff()
    {
        for(int i=0;i<10;i++)
        {
            i=i+1;
            System.out.println(i);
        }
        System.out.println("ThreadNAme is "+Thread.currentThread().getName());
    }
}
