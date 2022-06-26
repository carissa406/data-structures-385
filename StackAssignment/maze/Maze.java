package maze;
public class Maze {

    /**
     * Two dimensional array to represent a maze
     */
    private final char[][] maze;

    private final Position start, end;

    /**
     * Constructor initializing the maze array
     * 
     * @param maze
     */
    public Maze(char[][] maze, Position start, Position end) {
        this.maze = maze;
        
        if (validPosition(start)) {
            this.start = start;
        } else {
            throw new PositionNotValidException("The start position is valid for the maze: " + start);
        }

        if (validPosition(end)) {
            this.end = end;
        } else {
            throw new PositionNotValidException("The stop position is valid for the maze: " + end);
        }
    }

    /**
     * Returns the start position object.
     * 
     * @return The start position.
     */
    public Position getStart() {
        return start;
    }

    /**
     * Returns the stop position object.
     * 
     * @return
     */
    public Position getEnd() {
        return end;
    }

    /**
     * Returns the number of rows the maze has.
     * 
     * @return The number of rows.
     */
    public int numRows() {
        return maze.length;
    }

    /**
     * Returns the number of columns the row of the maze has.
     * 
     * @param row The row to get the length of.
     * @return The length of the row in the maze.
     */
    public int numCols(int row) {
        return maze[row].length;
    }

    /**
     * Tests if row and column are valid within the two dimensional array. Will
     * return true iff row is between 0 and maze.length-1 and column is between 0
     * and maze[row].length - 1.
     * 
     * @param row Represents the array to retrieve from maze.
     * @param col Represents the character to retrieve from the array at maze[row].
     * @return True iff the row and column are valid indices of maze otherwise
     *         false.
     */
    public boolean validPosition(int row, int col) {
        if (row >= 0 && row < maze.length) {
            if (col >= 0 && col < maze[row].length) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tests if the row and column stored in pos are valid. Drops to the
     * validPosition(int row, int col) method.
     * 
     * @param pos The position to test.
     * @return True iff pos is valid inside the maze otherwise false.
     */
    public boolean validPosition(Position pos) {
        return validPosition(pos.getRow(), pos.getColumn());
    }

    /**
     * Returns the character at pos.
     * 
     * @param pos The position to retrieve the character at.
     * @return The character at maze[pos.row][pos.column]
     * @throws PositionNotValidException if the position is now within the maze.
     */
    public char getAt(Position pos) {
        if (validPosition(pos)) {
            return maze[pos.getRow()][pos.getColumn()];
        } else {
            String msg = String.format("The position given is not valid: %s", pos.toString());
            throw new PositionNotValidException(msg);
        }
    }

    /**
     * Retrieves the character at maze[row][column].
     * 
     * @param row    The row to retrieve the character from.
     * @param column The column to retrieve the character from.
     * @return The character at position row, column
     * @throws PositionNotValidException if the row or column are not within bounds.
     */
    public char getAt(int row, int column) {
        if (validPosition(row, column)) {
            return maze[row][column];
        } else {
            String msg = String.format("The row and column given is not valid: row %d col %d", row, column);
            throw new PositionNotValidException(msg);
        }
    }

    /**
     * Sets a character at a specified position.
     * 
     * @param pos The position to set the character at.
     * @param c   The character to set at position.
     * @throws PositionNotValidException if the position passed in is not valid
     *                                   within the maze.
     */
    public void setAt(Position pos, char c) {
        if (validPosition(pos)) {
            setAt(pos.getRow(), pos.getColumn(), c);
        } else {
            String msg = String.format("The position given is not valid: %s", pos.toString());
            throw new PositionNotValidException(msg);
        }
    }

    /**
     * Sets a character at a specified row and column.
     * 
     * @param pos The position to set the character at.
     * @param c   The character to set at position.
     * @throws PositionNotValidException if the position passed in is not valid
     *                                   within the maze.
     */
    public void setAt(int row, int column, char c) {
        if (validPosition(row, column)) {
            maze[row][column] = c;
        } else {
            String msg = String.format("The row and column given is not valid: row %d col %d", row, column);
            throw new PositionNotValidException(msg);
        }
    }

    /*** METHODS NOT NEEDED TO HELP SOLVE THE PROBLEM. ****/
    /*** YOU DO NOT NEED TO USE THESE METHODS AS THEY  ****/
    /*** ARE USED IN THE MAIN CLASS.				   ****/
    public Maze clone() {
        char clone[][] = new char[maze.length][];
        for (int r = 0; r < maze.length; r++) {
            clone[r] = new char[maze[r].length];
            for (int c = 0; c < maze[r].length; c++) {
                clone[r][c] = maze[r][c];
            }
        }
        return new Maze(clone, start, end);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int r = 0; r < maze.length; r++) {
            sb.append(maze[r]);
            sb.append("\n");
        }
        return sb.toString();
    }
}
