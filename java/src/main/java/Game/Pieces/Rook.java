package Game.Pieces;

import Game.ChessBoard;
import Game.Pieces.Features.Color;
import Game.Pieces.Features.MoveLogic;
import Game.Pieces.Features.PieceType;
import Game.Position;

import java.util.ArrayList;
import java.util.List;

public class Rook implements Piece {
    Position position;
    ChessBoard board;
    Color color;

    public Rook(Position position, ChessBoard board, Color color) {
        this.position = position;
        this.board = board;
        this.color = color;
    }

    public Position getPosition() {return position;}
    public void setPosition(Position position) {this.position = position;}
    public Color getColor() {return color;}
    public boolean exists() {return true;}
    public PieceType getType() {return PieceType.ROOK;}

    public List<Position> getValidMoves() {
        int[] dxy = {1, -1};
        List<Position> validMoves = new ArrayList<>();
        Position current;

        // Expand left/right
        for (int i : dxy) {
            current = position;
            current.setColumn(current.getColumn() + i);
            MoveLogic moveLogic = new MoveLogic();
            while (moveLogic.isValidMove(this, board, current)) {
                validMoves.add(current);
                current.setColumn(current.getColumn() + i);
            }
        }
        // Expand up/down
        for (int i : dxy) {
            current = position;
            current.setRow(current.getRow() + i);
            MoveLogic moveLogic = new MoveLogic();
            while (moveLogic.isValidMove(this, board, current)) {
                validMoves.add(current);
                current.setRow(current.getRow() + i);
            }
        }
        return validMoves;
    }
}
