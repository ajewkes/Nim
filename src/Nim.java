import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class Nim {
    private int[] board;
    private Scanner sc;

    public Nim(int[] board){
        this.board = board;
        sc = new Scanner(System.in);
    }

    public void playGame(boolean isPlayerFirst){
        int gameState = 0;

        if(isPlayerFirst) {
            printBoard();
            playerTurn();
        }
        printBoard();

        while(gameState < 1){
            System.out.println("Cpu Turn: ");
            cpuTurn();
            printBoard();
            checkForWinner(false);
            playerTurn();
            printBoard();
            checkForWinner(true);
        }

        sc.close();
    }

    private void printBoard(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i]; j++){
                switch(i){
                    case 0:
                        System.out.print("G");
                        break;
                    case 1:
                        System.out.print("Y");
                        break;
                    case 2:
                        System.out.print("O");
                        break;
                }
            }
            System.out.println();
        }
    }

    private int[] updateBoard(String cChoice, int nChoice){
        switch(cChoice){
            case "G":
                board[0] -= nChoice;
                break;
            case "Y":
                board[1] -= nChoice;
                break;
            case "O":
                board[2] -= nChoice;
                break;
        }
        return board;
    }

    private void playerTurn(){
        System.out.println("Input your color choice, either 'G' 'Y' or 'O': ");
        // Do logic check to make sure they didnt take too many TODO
        String colorInput = sc.nextLine();
        System.out.println("Now input how many you want to take: ");
        int amountInput = sc.nextInt();
        sc.nextLine();
        board = updateBoard(colorInput, amountInput);
    }

    private void cpuTurn(){
        for (int i = 0; i < board.length; i++){
            for (int j = board[i]; j >= 0; j--){
                switch(i){
                    case 0:
                        if ((j^board[1]^board[2]) == 0){
                            updateBoard("G", board[0] - j);
                            return;
                        }
                        break;
                    case 1:
                        if ((j^board[0]^board[2]) == 0){
                            updateBoard("Y", board[1] - j);
                            return;
                        }
                        break;
                    case 2:
                        if ((j^board[0]^board[1]) == 0){
                            updateBoard("O", board[2] - j);
                            return;
                        }
                        break;
                }
            }
        }
        System.out.println("!Line reached");
        randomTurn();
    }

    private int checkForWinner(boolean playerTurn){
        // todo
        if (board[0] + board[1] + board[2] == 0){
            if (playerTurn){
                return 1;
            } else return 2;
        }
        return 0;
    }

    private void randomTurn(){
        Random rand = new Random();
        int colChoice = rand.nextInt(3);
        // bruh moment todo

        int numChoice;
        switch(colChoice){
            case 0:
                numChoice = rand.nextInt(board[colChoice]) + 1;
                updateBoard("G", numChoice);
                break;
            case 1:
                numChoice = rand.nextInt(board[colChoice]) + 1;
                updateBoard("Y", numChoice);
                break;
            case 2:
                numChoice = rand.nextInt(board[colChoice]) + 1;
                updateBoard("O", numChoice);
                break;
        }


    }


}
