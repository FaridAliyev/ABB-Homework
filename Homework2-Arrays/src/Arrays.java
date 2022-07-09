import java.util.Random;
import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        char[][] matrix = { {'-','-','-','-','-'},{'-','-','-','-','-'},{'-','-','-','-','-'},{'-','-','-','-','-'},{'-','-','-','-','-'} };
        Scanner scanner = new Scanner(System.in);
        Random random=new Random();
        int row= random.nextInt(4);
        int column = random.nextInt(4);
        System.out.println("All set. Get ready to rumble!");
        printMatrix(matrix);
        while(true){
            int rowGuess=0;
            int colGuess=0;
            System.out.println("Enter the row:");
            if(scanner.hasNextInt()) {
                rowGuess = scanner.nextInt();
                if(rowGuess<1||rowGuess>5){
                    System.out.println("Please enter a number between 1 and 5!");
                    continue;
                }
            }
            else{
                System.out.println("Please enter a number between 1 and 5!");
                scanner.next();
                continue;
            }
            System.out.println("Enter the column:");
            if(scanner.hasNextInt()) {
                colGuess = scanner.nextInt();
                if(colGuess<1||colGuess>5){
                    System.out.println("Please enter a number between 1 and 5!");
                    continue;
                }
            }
            else{
                System.out.println("Please enter a number between 1 and 5!");
                scanner.next();
                continue;
            }
            boolean won=false;
            if(rowGuess-1==row&&colGuess-1==column){
                matrix[rowGuess-1][colGuess-1]='x';
                won=true;
            }
            else{
                matrix[rowGuess-1][colGuess-1]='*';
            }
            printMatrix(matrix);
            if(won){
                break;
            }
        }

        System.out.println("You have won!");

    }

    public static void printMatrix(char[][] matrix){
        for(int i=0;i< matrix.length;i++){
            if(i==0){
                for (int j=0;j<=5;j++){
                    System.out.print(j+" ");
                }
                System.out.println();
            }
            for(int j=0;j< matrix[i].length;j++){
                if(j==0){
                    System.out.print(i+1+" ");
                }
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
