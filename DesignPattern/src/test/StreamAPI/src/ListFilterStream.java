import java.util.List;
import java.util.stream.Collectors;

public class ListFilterStream {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(12, 4, 5, 3, 2, 6);//this gives immutable list
        //list1.add(7);//gives exception .cannot add new element// Unsupported Exception.
        List<Integer> Streamlist = list1.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        Streamlist.forEach(System.out::println);

        List<String> list2 = Streamlist.stream().map(String::valueOf).collect(Collectors.toList());
        list2.forEach(System.out::println);
    }
}
