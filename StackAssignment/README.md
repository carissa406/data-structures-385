### Maze Solving With Stacks


# Problem Statement 
Consider a maze made up of rectangular array of squares, such as the following one:

![ ](https://github.com/carissa406/CSC385/blob/main/StackAssignment/Capture.PNG)

The “X” blocks represent a blocked square and form the walls of the maze. Let us consider mazes that have only one entrance and one exit, as in our example. Beginning at the entrance at the top left side of the maze, find a path to the exit at the bottom right side. You can move only up, down, left, or right. Square is either clear or blocked by an X character. 
A maze class has been provided to help abstract traversing a 2-Dimensional array. Use a stack data structure to find a path through the maze. Some mazes might have more than one successful path, while others might have no path.

- The primary consideration is that if you reach a dead end, you need to be able to backtrack along the path to the point where you can try a different path. The stack data structure makes it possible to store the current path and backtrack if necessary.  Every clear position visited in the current path is pushed to the stack and if a dead end is reached, the previous position is popped from the stack to backtrack.  You need to have a loop that begins with the start position and pushes it into the stack then moves to a neighboring cell until either the goal position is reached, or the stack becomes empty.
- Make sure to mark each clear array cell you move to as visited to avoid checking it again and getting stuck in an infinite loop. For example, each array cell can have three different values: “X” for blocked, “V” for visited, and “ “ for clear. 
- A dead end is an array cell whose all neighbors are either blocked or already visited.

- Position.java:   a class to store the position of an array cell. It has two attributes: row and column along with their accessor and mutator methods. It also has an equal’s method that checks for equality of two Position objects. 
- Maze.java:  a class to store a maze.  It has 3 attributes: a two-dimensional character array which represents the maze, a Position object to represent the start location, and another Position object to represent the stop location.   Make sure to read the documentation provided to understand the methods you have access to.
- MazeSolver:  This class contains one static method, solve.  It accepts a maze and returns an array of Positions that is used to traverse the maze if the maze is solvable.  If the maze is not solvable then an empty array is returned.
o	Keep in mind that stacks store objects in reverse order so be sure to return the position array in the correct order.
- Tester:  a sample driver class which asks for a maze file.  Sample maze files have been given called SolvableMaze, UnsolvableMaze, and HugeSolvableMaze.  You may test any other maze files you create.  The test class will ask for a file and test it reporting any disconnected positions in the path or an position that is invalid or any position that runs into a wall.  What it will not do is tell you if there  is a misreporting of whether a maze is solvable but your code returns an empty array which would mean it is unsolvable.  
You only need to implement the solve method in the MazeSolver.java class. This method receives the maze to solve as a parameter and returns an array of Position objects which stores a solution to the maze if such solution exists; otherwise, it returns an empty array.  

You must solve the problem using a Stack.  You may use the built-in stack library or use your own but use of any other data structure is prohibited apart from constructing the final Position array result.

Recursion is not allowed.
