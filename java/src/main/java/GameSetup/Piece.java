package GameSetup;

import java.util.List;

public interface Piece {
    public Color getColor();
    public Position getPosition();
    public void setPosition(Position position);
    public List<Position> getValidMoves();
}
