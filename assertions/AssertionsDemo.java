package assertions;

import interfaces.Car;
import interfaces.DaewooMatiz;

public class AssertionsDemo {

    @SuppressWarnings("all")
    public static void doAssertions() {
        assert Car.class.isInterface();
        Car daewoo = new DaewooMatiz();

        String[] weekends = {"Friday", "Saturday", "Sunday"};
        assert weekends.length==2 : "There are only 2 weekends in a week";

        String dayOfWeek = "Monday";
        switch (dayOfWeek) {
            case "Sunday":
                break;
            case "Monday":
                break;
            case "Tuesday":
                break;
            case "Wednesday":
                break;
            case "Thursday":
                break;
            case "Friday":
                break;
            case "Saturday":
                break;
            default:
                assert false: dayOfWeek + " is invalid day";
        }

    }

}
