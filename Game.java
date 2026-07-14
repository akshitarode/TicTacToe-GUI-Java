import java.util.*;

public class Game {
    Board board;
    String turn;
    Scanner in;

    Game() {
        board = new Board();
        turn = "X";
        in = new Scanner(System.in);
    }

    void play() {
        String winner = null;
        board.printBoard();
        System.out.println("X will play first.");

        while(winner == null) {
            System.out.println(turn + "'s turn. Enter slot 1-9:");
            int num = in.nextInt();

            if(board.makeMove(num-1, turn)) {
                board.printBoard();
                winner = board.checkWinner();
                turn = turn.equals("X")? "O" : "X";
            } else {
                System.out.println("Slot taken. Try again.");
            }
        }

        if(winner.equals("draw")) System.out.println("It's a draw!");
        else System.out.println("Congratulations! " + winner + " wins!");
    }
} 
    

