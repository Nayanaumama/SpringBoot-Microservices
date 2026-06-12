//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        School<String> sc=new School<>("elementory","branchburg");
        sc.getBothNameAndArea(sc.getName(), sc.getArea());
        System.out.println(sc);
        }
    }
