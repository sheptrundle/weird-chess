package Game;
import Game.Pieces.*;
import Game.Pieces.Features.Color;

public class ChessBoard {
    public Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];
    }

    // Return piece at a position
    public Piece getPieceAt(Position position) {
        return board[position.getRow()][position.getColumn()];
    }

    // Sets a piece at position
    public void setPieceAt(Position position, Piece piece) {
        board[position.getRow()][position.getColumn()] = piece;
    }

    // Initialize a new piece and place it in a position
    public void createAndPlace(Color color, String pieceName, int row, int col) throws IllegalArgumentException{
        Piece piece;
        Position pos = new Position(row,col);
        if (pieceName.equals("pawn")) {
            piece = new Pawn(pos, this, color);
        }
        else if (pieceName.equals("rook")) {
            piece = new Rook(pos, this, color);
        }
        else if (pieceName.equals("knight")) {
            piece = new Knight(pos, this, color);
        }
        else if (pieceName.equals("king")) {
            piece = new King(pos, this, color);
        }
        else if (pieceName.equals("null")) {
            piece = new NullPiece(pos);
        }
        else {
            throw new IllegalArgumentException(pieceName + " is not a valid piece name");
        }
        setPieceAt(pos, piece);
    }

    // Set up the board in standard position
    public void initialize() {
        // Pawns
        for (int col = 1; col < 8; col++) {
            // Place white pawns
            Position whitePawnLoc = new Position(1, col);
            Piece whitePawn = new Pawn(whitePawnLoc, this, Color.WHITE);
            setPieceAt(whitePawnLoc, whitePawn);
            // Place black pawns
            Position blackPawnLoc = new Position(7, col);
            Piece blackPawn = new Pawn(blackPawnLoc, this, Color.BLACK);
            setPieceAt(blackPawnLoc, blackPawn);
        }
        // Kings


    }

    // This will have to get wayyyy more complicated I assume?
    public void movePiece(Position from, Position to) {
        Piece movingPiece = getPieceAt(from);
        movingPiece.setPosition(to);
        setPieceAt(to, movingPiece);
        setPieceAt(from, new NullPiece(from));
    }
}
