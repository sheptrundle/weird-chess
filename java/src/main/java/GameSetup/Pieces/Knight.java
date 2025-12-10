package GameSetup.Pieces;
import GameSetup.ChessBoard;
import GameSetup.Color;
import GameSetup.Piece;
import GameSetup.Position;

import java.util.ArrayList;
import java.util.List;

public class Knight implements Piece {
    Position position;
    ChessBoard board;
    Color color;

    public Knight(Position position, ChessBoard board, Color color) {
        this.position = position;
        this.board = board;
        this.color = color;
    }

    public Position getPosition() {return position;}
    public void setPosition(Position position) {this.position = position;}
    public Color getColor() {return color;}

    public List<Position> getValidMoves() {
        int[] dx = { 1,  2,  2,  1, -1, -2, -2, -1 };
        int[] dy = { 2,  1, -1, -2, -2, -1,  1,  2 };
        List<Position> validMoves = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Position newPos = new Position(position.getRow() + dx[i], position.getColumn() + dy[i]);
            if (newPos.isOnBoard()) validMoves.add(newPos);
        }

        return validMoves;
    }
}