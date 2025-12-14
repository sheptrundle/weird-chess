package Game.Pieces;

import Game.ChessBoard;
import Game.Pieces.Features.Color;
import Game.Pieces.Features.PieceType;
import Game.Position;

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

    }
}
