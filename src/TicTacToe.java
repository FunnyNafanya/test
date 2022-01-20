public class TicTacToe {


    private String[][] playingField;
    private String player;


    public TicTacToe(String[][] playingField) {
        this.playingField = new String[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                playingField[i][j] = "'-'";
            this.player = "'X'";
    }

    public String checkGame() {

        String check = "";
        for (int i = 0; i < 3; i++)
            check += playingField[i][i];
        if (check.equalsIgnoreCase("'x''x''x'") == true)
            return "Player X won";
        if (check.equalsIgnoreCase("'0''0''0'") == true)
            return "Player 0 won";
        check = "";
        for (int i = 0; i < 3; i++)
            check += playingField[i][2-i];
        if (check.equalsIgnoreCase("'x''x''x'") == true)
            return "Player X won";
        if (check.equalsIgnoreCase("'0''0''0'") == true)
            return "Player 0 won";
        return "";
    }

    public String makeMove(int x, int y) {
        return "Game was ended.";
    }

    public String[][] getPlayingField() {
        return playingField;
    }
}
