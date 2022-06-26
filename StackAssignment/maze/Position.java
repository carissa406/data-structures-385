package maze;
/**
 * A class to store a position in a maze
 * 
 * @author esahe2
 *
 */
public class Position {

    /***************************
     * Attributes
     ****************************/
    private int row;
    private int column;

    /***************************
     * Constructor
     * 
     * @param row
     * @param column
     ***************************/
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**************************
     * Checks two positions for equality. Two positions are equal if the have the
     * same row and column numbers.
     *************************/
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Position)) {
            return false;
        }

        Position otherPosition = (Position) obj;
        return (otherPosition.row == row && otherPosition.column == column);
    }

    public String toString() {
        return "row:" + row + " column:" + column;
    }

    /**************************
     * Getter and Setter methods
     * 
     * @return
     */
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}