public interface Customer {

    int noOfProduct();
    public default void say(){
        System.out.println("Hello World");
    }

    public static String getName()
    {
        return "Nayana";
    }


}
