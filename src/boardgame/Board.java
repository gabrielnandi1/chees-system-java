package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces; // uma matriz de peças

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException(
                    "Erro na criaçao do tabuleiro é necessario que tenha pelo menos 1 linha e 1 coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // Metodo para retornar um peça dada pela coluna
    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Posiçao nao esta no tabuleiro");
        }
        return pieces[row][column];
    }

    // sobre carga do metodo acima
    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Posiçao nao esta no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("já existe uma peça na posição " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position positon) {
        if (!positionExists(positon)) {
            throw new BoardException("posição fora do tabuleiro");
        }
        if (piece(positon) == null) {
            return null;
        }
        Piece aux = piece(positon);
        aux.position = null;
        pieces[positon.getRow()][positon.getColumn()] = null;
        return aux;
    }

    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());

    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Posiçao nao esta no tabuleiro");
        }
        return piece(position) != null;

    }

}