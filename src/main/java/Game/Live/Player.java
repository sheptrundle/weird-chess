package Game.Live;

import Game.Pieces.Assets.Color;
import Game.Pieces.Assets.Piece;
import Game.Pieces.Assets.PieceType;
import Game.Pieces.King;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashSet;

public class Player {
    private final ChessClock clock;
    private Color color;
    private HashSet<Piece> pieces;

    public Player(Color color, Duration initialTime) {
        this.color = color;
        this.clock = new ChessClock(initialTime);
        this.pieces = new HashSet<>();
    }

    // Getter for Clock
    public ChessClock getClock() {return clock;}

    // Start/stop counting down this players clock
    public void startTicking() {clock.startTicking();}
    public void stopTicking() {clock.stopTicking();}

    // Access team via player
    public void addPiece(Piece piece) {pieces.add(piece);}
    public void removePiece(Piece piece) {pieces.remove(piece);}
    public HashSet<Piece> getPieces() {return pieces;}

    // Get color
    public Color getColor() {return color;}

    // Return the King
    public King getKing() {
        for (Piece piece : pieces) {
            if (piece.getType().equals(PieceType.KING)) {
                return (King) piece;
            }
        }
        throw new IllegalArgumentException("King not found in pieces: " + pieces.toString());
    }

    // Return a string of all pieces
    public String toString() {
        ArrayList<String> parts = new ArrayList<>();
        for (Piece piece : pieces) {
            parts.add("{" + piece.getType().toString() + " @ " + piece.getPosition().toString() + "} ");
        }
        return parts.toString();
    }

    // Return true if player is currently checkmated
    public boolean isCheckmated() {
        return getKing().getValidMoves().isEmpty() && getKing().isInCheck();

        /*
        Todo: well what if a king has no valid moves but it has a piece that can block?
        Idea: make a method in chessboard that returns a copy of a chessboard after ONE specific move is made
        then run every possible move and see if any of them create a state on the new chessboard where the king is NOT in check
        */

        /*
        Todo: Also, when the king is in check, we cannot allow other pieces to move unless it gets king out of check
         */
    }

}
