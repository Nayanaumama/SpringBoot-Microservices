import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String s=null;
        Optional<String> opt=Optional.ofNullable(s);//create an optional from s.If s is real null make it empty
        System.out.println(opt);
        opt.ifPresent(System.out::println);
       System.out.print(opt.orElse("empty String"));
       Optional<String> opt1=Optional.ofNullable(opt.orElse("empty String"));

        }
    }
