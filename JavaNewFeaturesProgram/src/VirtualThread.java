public class VirtualThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());
        Thread t1 = Thread.startVirtualThread(() -> printHello("Thread-1"));
        Thread t2 = Thread.startVirtualThread(() -> printHello("Thread-2"));//
        //this is lambda for Runnable interface it has run() which is functional interface
        //takes no parameter returns nothing


        t1.join();
        t2.join();
    }

    private static void printHello(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " Hello " + i);
        }

       //here t is virtual thread and it daemon thread which depends on the
        //normal user thread . Here the the user thread is main . So i made the main thread to sleep
        //if it did not sleep it would execute and exit .So once the main thread is cloesd virtual thread will not work .

    }
}
