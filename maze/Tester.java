package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFileChooser;

import maze.Maze;
import maze.MazeSolver;
import maze.Position;

/**
 * Driver class to test students solution. The printed result should be a path
 * from the start to the finish where the path is represented by asterisks.
 * 
 * The Solvable and Unsolvable mazes were generated using
 * https://www.dcode.fr/maze-generator
 * 
 * @author Brian Rogers
 *
 */
public class Tester {

	private static Maze loadMaze(File file) {
		char maze[][] = null;
		Position start = null, stop = null;
		try {
			Scanner filein = new Scanner(file);
			// Load Header
			// First number is how many rows.
			// Second and third number are the row and column to start at.
			// Fourth and fifth number are the row and column to stop at.
			int row = filein.nextInt();
			start = new Position(filein.nextInt(), filein.nextInt());
			stop = new Position(filein.nextInt(), filein.nextInt());
			filein.nextLine();
			// End Header

			maze = new char[row][];

			int currRow = 0;
			while (filein.hasNextLine()) {
				maze[currRow++] = filein.nextLine().replace("\n", "").toCharArray();
			}

			filein.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		} catch (Exception e) {
			System.out.println("Something bad happened. See exception message");
			e.printStackTrace();
			System.exit(2);
		}

		return new Maze(maze, start, stop);
	}

	private static void walkPath(Maze maze, Position traversal[]) {
		Position previous = null;
		char path = '@';
		for (Position p : traversal) {
			if (maze.getAt(p) == ' ') {
				maze.setAt(p, path);
			} else if (maze.getAt(p) == path) {
				System.out.println("-------MISTAKE----------");
				System.out.println("There is a repeated position " + p);
				System.exit(3);
			} else {
				System.out.println("-------MISTAKE----------");
				System.out.println("There is an obstacle at position " + p);
				System.out.println(maze);
				System.exit(3);
			}

			// Check to make sure path is connected.
			if (previous != null) {
				int prevRow = previous.getRow();
				int prevCol = previous.getColumn();
				int curRow = p.getRow();
				int curCol = p.getColumn();

				boolean isPathConnected = false;
				if (curRow - 1 == prevRow || curRow + 1 == prevRow) {
					isPathConnected = curCol == prevCol;
				} else if (curCol - 1 == prevCol || curCol + 1 == prevCol) {
					isPathConnected = curRow == prevRow;
				}

				if (!isPathConnected) {
					System.out.println("\n\n-----Path not connected-------\n");
					System.out.println("From: " + previous);
					System.out.println("To: " + p);
					maze.setAt(previous, '?');
					maze.setAt(p, '?');
					System.out.println(maze);
					System.exit(3);
				}
			}
			previous = p;
		}
	}

	public static void main(String[] args) {
		Maze clone;
		Position solution[];
		JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.showOpenDialog(null);
		File selectedFile = chooser.getSelectedFile();
        if(selectedFile != null) {
			Maze solvableMaze = loadMaze(selectedFile);
			clone = solvableMaze.clone();
			System.out.println("Testing Maze");
			System.out.println("Starts at " + clone.getStart());
			System.out.println("Ends at " + clone.getEnd());
			System.out.println(clone);
	
			solution = MazeSolver.solve(clone);
			
			if (solution != null && solution.length != 0) {
				walkPath(solvableMaze, solution);
				System.out.println("\nSOLUTION");
				System.out.println(solvableMaze);
			} else {
				System.out.println("NO SOLUTION\n");
			}
        }

	}

}
