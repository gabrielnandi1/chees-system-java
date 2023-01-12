package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces; // uma matriz de peças

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

}