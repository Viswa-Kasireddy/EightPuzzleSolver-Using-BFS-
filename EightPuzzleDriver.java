package eightPuzzle;

/*
 * EightPuzzle is played on a 3-by-3 grid with 8 square blocks labeled 1 through 8 and a blank square represented
 * as zero in this game. The goal is to rearrange the blocks so that they are in order. 
 * it is permitted to slide blocks horizontally or vertically into the blank square which is represented as zero
 * 
 * Problem: Find a path from a start state to a goal state using Breadth First Search (BFS)
 * 
 * Ex:
 *  Start State (Initial Board): 
			 					1 2 3
 *                               4 5 6
 *                               0 7 8
 *                               
 *  End State (Goal State):      
			 					1 2 3
 *                               4 5 6
 *                               7 8 0
 *                               
 * Solution:
 * 1 2 3        1 2 3        1 2 3
 * 4 5 6  ==> 	4 5 6  ==> 	4 5 6
 * 0 7 8         7 0 8       7 8 0   
 * 
 *  Author: Viswanath Kasireddy                  
 */

public class EightPuzzleDriver {
	public static void main(String args[]){
		String intialBoard="182756304"; //Initial State of EightPuzzle
		EightPuzzleSolver  solver = new EightPuzzleSolver(); // New Instance of the EightPuzzleSolver
		solver.addState(intialBoard, null); // Add the Initial  Board 
		while(!solver.queue.isEmpty()) {
			String currentBoard = solver.queue.remove();
			solver.up (currentBoard);  
			solver.down(currentBoard); 
			solver.left(currentBoard); 
			solver.right(currentBoard); 
		}
		System.out.println("Solution doesn't exist");
	}

}
