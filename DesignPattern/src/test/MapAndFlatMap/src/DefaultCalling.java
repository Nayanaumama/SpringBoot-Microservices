public class DefaultCalling {
    public static void main(String[] args) {
        Customer customer=new Customer() {
            @Override
            public int noOfProduct() {
                return 10;
            }
            @Override
            public   void say()
            {
                System.out.println("I like summer");
            }


        };
        System.out.println(customer.noOfProduct());
        customer.say();
        System.out.println(Customer.getName());
    }
}
