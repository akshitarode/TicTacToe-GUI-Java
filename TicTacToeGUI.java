import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame implements ActionListener {

    JButton[] buttons = new JButton[9]; // 9 button banenge
    Board board = new Board(); // purani Board class use karenge
    String turn = "X";

    TicTacToeGUI() {
        setTitle("Tic Tac Toe Game");
        setSize(300, 300);
        setLayout(new GridLayout(3, 3)); // 3x3 ka grid
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 9 button bana do
        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 50));
            buttons[i].addActionListener(this); // click sunega
            add(buttons[i]);
        }
        setVisible(true);
    }

    // jab button pe click hoga to ye chalega
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 9; i++) {
            if(e.getSource() == buttons[i]) {
                if(board.makeMove(i, turn)) { // Board class se poocho move valid hai?
                    buttons[i].setText(turn);
                    buttons[i].setEnabled(false); // dubara click na ho

                    String winner = board.checkWinner();
                    if(winner!= null) {
                        if(winner.equals("draw"))
                            JOptionPane.showMessageDialog(this, "It's a Draw!");
                        else
                            JOptionPane.showMessageDialog(this, winner + " Wins!");
                        System.exit(0);
                    }
                    turn = turn.equals("X")? "O" : "X"; // turn change
                }
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}