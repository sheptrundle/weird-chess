package Game.Features;

import Game.Logic.MoveLogic;
import Game.Pieces.Pawn;
import Game.Pieces.Piece;
import java.util.HashSet;

public class Team {
    private HashSet<Piece> pieces;
    private HashSet<Position> allTargets;

    public Team() {
        pieces = new HashSet<>();
    }

    public void add(Piece piece) {pieces.add(piece);}
    public void remove(Piece piece) {pieces.remove(piece);}

    public boolean targets(Position position) {
        return allTargets.contains(position);
    }

    // Return all current targets
    public HashSet<Position> getAllTargets() {return allTargets;}

    public void calcAllTargets() {
        for (Piece piece : pieces) {
            /*
            TargetLogic targetLogic = new TargetLogic();
            allTargets.addAll(targetLogic.getTargets(piece))
             */
        }
    }
}
