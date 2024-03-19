import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        // Setting up game variables
        boolean isPlayerFirst = true;
        int[] board = {3, 7, 5};

        // Determining player preference
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to go first (1) or second (2)?");
        boolean invalidInput = true;
        while(invalidInput){
            invalidInput = false;
            int input = sc.nextInt();
            switch (input){
                case 1:
                    break;
                case 2:
                    isPlayerFirst = false;
                    break;
                default:
                    System.out.println("Please enter 1 or 2!");
                    invalidInput = true;
            }
        }

        // Puts scanner to next line so it can take in a new String
        sc.nextLine();

        Nim game = new Nim(board);
        game.playGame(isPlayerFirst);

        sc.close();

    }
}
