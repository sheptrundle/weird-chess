package Game.Features;

import java.util.Objects;

public class Position {
    private int row;
    private int column;


    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {return row;}
    public void setRow(int row) {this.row = row;}
    public int getColumn() {return column;}
    public void setColumn(int column) {this.column = column;}
    public boolean isOnBoard(){
        return row > -1 && row < 8 && column > -1 && column < 8;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Position)) return false;
        Position other = (Position) obj;
        return row == other.row && column == other.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}
