public class SwitchExpression {
    public static void main(String[] args) {


        String day = "Saturday";
        String result="";
        switch (day) {
           // Older way of defining cases
//            case "Saturday":
//            case"Sunday":
//                System.out.println("Weekend");
//                break;
//                default:
//                    System.out.println("Weekday");
//This is also changed in later version
//            case "Saturday", "Sunday":
//                System.out.println("Weekend");
//                break;
//            default:
//                System.out.println("Weekday");

                //But java 11 onwards its been introduced Switch expression .its different way of writing
                //switch .No need of break this will resolve fall break .
            //instead of colon just use the arrow no need of break
            //switch expression

                case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"->result="Weekday";

            case "Saturday", "sunday" -> result="Weekend";
            }
            System.out.println(result);

        //more clean expression way is

        result=switch (day)
        {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"-> "Weekday";
            case "Saturday", "sunday" -> "Weekend";
            default -> "Weekday";
        };
        System.out.println(result);

        result=switch (day)
        {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" :yield  "Weekday";
            case "Saturday", "sunday" :yield  "Weekend";
            default :  throw new IllegalArgumentException("Invalid day");
        };
        System.out.println(result);
    }

}

