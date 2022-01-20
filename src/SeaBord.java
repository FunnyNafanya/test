public class SeaBord {

    private String[][] field;

    public SeaBord() {
        this.field = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.field[i][j] = ".";
            }
        }
    }

    public String[][] getField() {
        return field;
    }

    public void shoot(int line, int column, String issue) {

        int k = 0;
        if (field[line][column].equals(".") == true) {
            if (issue.equals("m") == true)
                field[line][column] = "#";
            if (issue.equals("h") == true)
                field[line][column] = "x";

            if (issue.equals("d") == true) {

                field[line][column] = "x";

//                if (line - 1 >= 0 && )

            }
        }
    }


    public String check(int line, int column) {
        return field[line][column];
    }
}
