public class Board {
    String[] cells = new String[9];

    Board() {
        for(int i=0; i<9; i++) {
            cells[i] = String.valueOf(i+1);
        }
    }

    void printBoard() {
        System.out.println("| " + cells[0] + " | " + cells[1] + " | " + cells[2] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + cells[3] + " | " + cells[4] + " | " + cells[5] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + cells[6] + " | " + cells[7] + " | " + cells[8] + " |");
    }

    boolean makeMove(int pos, String turn) {
        if(cells[pos].equals(String.valueOf(pos+1))) {
            cells[pos] = turn;
            return true;
        }
        return false;
    }

    String checkWinner() {
        // rows
        for(int i=0; i<9; i=i+3)
            if(cells[i].equals(cells[i+1]) && cells[i+1].equals(cells[i+2])) return cells[i];
        // cols
        for(int i=0; i<3; i++)
            if(cells[i].equals(cells[i+3]) && cells[i+3].equals(cells[i+6])) return cells[i];
        // diagonals
        if(cells[0].equals(cells[4]) && cells[4].equals(cells[8])) return cells[0];
        if(cells[2].equals(cells[4]) && cells[4].equals(cells[6])) return cells[2];

        // draw
        boolean draw = true;
        for(String s : cells) if(!s.equals("X") &&!s.equals("O")) draw = false;
        if(draw) return "draw";

        return null;
    }
} 