import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        int array[] = new int[100];
        int guessCounter=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Let the game begin!");
        Random random = new Random();
        int number = random.nextInt(100);
        while (true) {
            if(scanner.hasNextInt()){
                int guess = scanner.nextInt();
                array[guessCounter++]=guess;
                if (guess == number) {
                    break;
                } else if (guess < number) {
                    System.out.println("Your number is too small. Please, try again.");
                } else {
                    System.out.println("Your number is too big. Please, try again.");
                }
            }
            else{
                System.out.println("Please enter integers only!");
                scanner.next();
            }

        }
        for(int i=0;i<guessCounter;i++){
            for(int j=i+1;j<guessCounter;j++){
                if(array[j]>array[i]){
                    int swapper=array[i];
                    array[i]=array[j];
                    array[j]=swapper;
                }
            }
        }
        for(int i=0;i<guessCounter;i++){
            System.out.println(array[i]);
        }
        System.out.println("Congratulations, " + name + "!");
    }
}
