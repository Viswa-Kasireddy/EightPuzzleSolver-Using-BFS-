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


import java.util.*;
public class EightPuzzleSolver {
public String GoalStateBoard = "123456780";
	
	Queue<String> queue = new LinkedList<String>();//Use of Queue for Storing All the Nodes in BFS.
	Map<String,Integer> treeDepth = new HashMap<String, Integer>(); // HashMap is used to ignore repeated nodes
	Map<String,String> stateLog = new HashMap<String,String>(); // relates each State Board position to its predecessor
	
	//Add method to add the new string to the Map and Queue
			void addState(String newBoard, String oldBoard){
			    if (!treeDepth.containsKey(newBoard)){
			    	int BranchPosition;
			    	if (oldBoard == null){
			    		BranchPosition = 0;
			    	}else 
			    	{
			    		BranchPosition = treeDepth.get(oldBoard) + 1;
			    	}
			    	treeDepth.put(newBoard, BranchPosition);
			        queue.add(newBoard);
			        stateLog.put(newBoard, oldBoard);
	     		}
			}
			
			void up(String CurrentBoard){

			   int spacePos = CurrentBoard.indexOf("0");
			   if(spacePos>2){
			    String ChangedBoard = 
				CurrentBoard.substring(0,spacePos-3)+"0"+CurrentBoard.substring(spacePos-2,spacePos)+CurrentBoard.charAt(spacePos-3)+
				CurrentBoard.substring(spacePos+1);
	    		check(CurrentBoard, ChangedBoard);
	    		}
			}
			void down(String CurrentBoard){
	    		int spacePos = CurrentBoard.indexOf("0");
	    		if(spacePos<6){
	              String ChangedBoard = 
			      CurrentBoard.substring(0,spacePos)+CurrentBoard.substring(spacePos+3,spacePos+4)+
			      CurrentBoard.substring(spacePos+1,spacePos+3)+"0"+
	              CurrentBoard.substring(spacePos+4);
	        	  check(CurrentBoard, ChangedBoard);
	    		}
			}

			void left(String CurrentBoard){
			     int spacePos = CurrentBoard.indexOf("0");
	        	 if (spacePos!=0 && spacePos!=3 && spacePos!=6){
			        String ChangedBoard = CurrentBoard.substring(0,spacePos-1)+"0"+CurrentBoard.charAt(spacePos-1)+
			        		CurrentBoard.substring(spacePos+1);
			        check(CurrentBoard, ChangedBoard);
	   		     }
			}

			void right(String CurrentBoard){
	   		     int spacePos = CurrentBoard.indexOf("0");
			     if (spacePos!=2 && spacePos!=5 && spacePos!=8){
			        String ChangedBoard = CurrentBoard.substring(0,spacePos)+CurrentBoard.charAt(spacePos+1)+"0"+
			        CurrentBoard.substring(spacePos+2);
			        check(CurrentBoard, ChangedBoard);
			     }
			}

			 void check(String oldStateBoard, String newStateBoard) {
			             addState(newStateBoard, oldStateBoard);
			             if (newStateBoard.equals(GoalStateBoard)) {
			                System.out.println("Solution Exists at branch "+treeDepth.get(newStateBoard)+" of the tree");
			                String traceStateBoard = newStateBoard;
			                while (traceStateBoard != null) {
			                	   int branchlevel = treeDepth.get(traceStateBoard);
			                	   System.out.println(traceStateBoard.substring(0,1)+ " " +traceStateBoard.substring(1,2)+ 
			                			   " "+traceStateBoard.substring(2,3));
			                	   System.out.println(traceStateBoard.substring(3,4)+ " " +traceStateBoard.substring(4,5)+ 
			                			   " "+traceStateBoard.substring(5,6)+"     at Branch: "+branchlevel);
			                	   System.out.println(traceStateBoard.substring(6,7)+ " " +traceStateBoard.substring(7,8)+ " "
			                			   +traceStateBoard.substring(8,9));
			                	   System.out.println("");
			                       traceStateBoard = stateLog.get(traceStateBoard);
			            }
			             System.exit(0);
			            }
			}


}
