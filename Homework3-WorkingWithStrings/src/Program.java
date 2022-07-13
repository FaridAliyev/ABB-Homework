import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] schedule = new String[7][2];

        schedule[0][0] = "Sunday";
        schedule[0][1] = "Do homework";
        schedule[1][0] = "Monday";
        schedule[1][1] = "Go to course";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "Watch a film";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "Exercise";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "Rest";
        schedule[5][0] = "Friday";
        schedule[5][1] = "Do some coding";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "Clean your room";

        loop: while (true){
            System.out.println("Please, input the day of the week:");
            String input = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
            switch(input){
                case "sunday":
                    System.out.println(String.format("Your tasks for %s: %s.",input,schedule[0][1]));
                    break;
                case "monday":
                    System.out.println(String.format("Your tasks for %s: %s.",input,schedule[1][1]));
                    break;
                case "tuesday":
                    System.out.println(String.format("Your tasks for %s: %s.",input,schedule[2][1]));
                    break;
                case "wednesday":
                    System.out.println(String.format("Your tasks for %s: %s.",input,schedule[3][1]));
                    break;
                case "thursday":
                    System.out.println(String.format("Your tasks for %s: %s.",input,schedule[4][1]));
                    break;
                case "friday":
                    System.out.println(String.format("Your tasks for %s: %s.",input,schedule[5][1]));
                    break;
                case "saturday":
                    System.out.println(String.format("Your tasks for %s: %s.",input,schedule[6][1]));
                    break;
                case "exit":
                    break loop;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");
                    break;
            }
        }
    }
}
