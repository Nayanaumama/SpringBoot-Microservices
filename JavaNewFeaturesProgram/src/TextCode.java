public class TextCode {
    public static void main(String[] args) {
        String data = "My name is nayana." + " " + "\n" +
                "I am working in CITI corporate as PErmanent Employee";
        System.out.println(data);

        String EmployeeDetails = """
                Name:nayana
                Age:36
                Address:New Jersey
                
                """;
        System.out.println(EmployeeDetails);


        String firstName = "nayana";
        String lastName = "hegde";
        String name = firstName + " " + lastName;
        String name1 = firstName.concat(" " + lastName);
        String name2 = String.format("%s %s", firstName, lastName);
        String name3 = String.join(" ", firstName, lastName);
//         example of text block where we can write string in """ """ quotes .no need to add next extra line and + symbol
        String name5 = """       
                nayana hegde
                """;

System.out.println("name is "+ "" +name);
System.out.println(name1);
System.out.println(name2);
System.out.println(name3);
System.out.println("name5 is "+" "+name5);
    }
}
