public class VarKeyword {
    public static void main(String[] args) {
        var a = 10;//since its local variable instead of saying int i can say var
        System.out.println(a);
       // var b;//this is not okay if we dont initialize
        int c;

        var arr=new int[10];
        var arr1= new int[]{1, 2, 4, 5};
        var emp=new Employee();
        //in the var for the local variable instead of defining the variable data type we can just use
        //var keyword but it should be initialized otherwise we get compiletime error
        //var can be used to any datatype


    }
}
