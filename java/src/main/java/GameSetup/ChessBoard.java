package GameSetup;
import java.util.ArrayList;

public class ChessBoard {
    public Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];
    }

    public Piece getPieceAt(Position position) {
        return board[position.getRow()][position.getColumn()];
    }
    public void setPieceAt(Position position, Piece piece) {
        board[position.getRow()][position.getColumn()] = piece;
    }

    // This will have to get wayyyy more complicated I assume
    public void movePiece(Position from, Position to) {
        Piece movingPiece = getPieceAt(from);
        movingPiece.setPosition(to);
    }

}
