package maze;
import java.util.Stack;

/**
 * Notes:
 * 
 * The start and end position are contained within the maze object. Use the
 * getStart() and getEnd() methods.
 * 
 * @author Brian Rogers
 *
 */
public class MazeSolver {
	
	private static boolean found = false;
	
    /**
     * You need to implement this method
     * 
     * @param maze: The maze to be solved.
     * @return An array of Position which stores a solution to the maze. If a
     *         solution is not found a null value should be returned.
     */
    public static Position[] solve(Maze maze) {
    	found = false;
    	Stack<Position> solution = new Stack<>();
    	solution.push(maze.getStart());
    	solveRecurse(maze, solution, maze.getStart(), maze.getEnd());
    	if(found) {
    		Position[] result = new Position[solution.size()];
    		result = solution.toArray(result);
    		return result;
    	}
    	return null;
    }
    
    public static void solveRecurse(Maze maze, Stack<Position> solution, Position start, Position end) {
    	Position current = solution.peek();
    	Position above = new Position(current.getRow() + 1, current.getColumn());
    	Position right = new Position(current.getRow(), current.getColumn() + 1);
    	Position left = new Position(current.getRow(), current.getColumn() - 1);
    	Position below = new Position(current.getRow() - 1, current.getColumn());
    	
    	maze.setAt(current, 'V');
    	
    	if (current.equals(end)) {
    		found = true;
    		return;
    	} 
    	
    	if (maze.validPosition(above) && maze.getAt(above) == ' ' && !found) {
    		solution.push(above);
    		solveRecurse(maze, solution, start, end);
    	}
    	
    	if(maze.validPosition(right) && maze.getAt(right) == ' ' && !found) {
    		solution.push(right);
    		solveRecurse(maze, solution, start, end);
    	}
    	
    	if(maze.validPosition(left) && maze.getAt(left) == ' ' && !found) {
    		solution.push(left);
    		solveRecurse(maze, solution, start, end);
    	}
    	
    	if(maze.validPosition(below) && maze.getAt(below) == ' ' && !found) {
    		solution.push(below);
    		solveRecurse(maze, solution, start, end);
    	}
    	
    	if (!found) {
    		solution.pop();
    	} 	
    }
    
    
}















