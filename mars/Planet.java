package mars;

import java.util.HashSet;

import search.AStarFunction;
import search.BestFirstFrontier;
import search.GoalTest;
import search.Node;

public class Planet {
    private static final int[][] accessible = new int[][] {
        /*{1,1,1,1,0,1,1,1},
        {1,1,0,0,0,0,0,1},
        {1,0,1,0,1,0,1,1},
        {0,0,1,1,1,0,0,0},
        {1,0,0,1,0,1,0,1},
        {1,1,0,0,0,1,0,1},
        {1,1,1,0,0,0,0,1},
        {1,1,1,1,0,1,1,1},
*/     
		{1,1,1,1,0,1,1,1},
        {1,1,0,0,0,0,0,1},
        {1,0,1,0,1,0,1,1},
        {0,0,1,1,1,0,0,0},
        {1,0,0,1,0,1,0,1},
        {1,1,0,0,0,1,0,1},
        {1,1,1,0,0,0,0,1},
        {1,1,1,1,0,1,1,1},
};
        
    public static boolean isAccessible(int x, int y) {
        int offx = x+0; int offy = y+0;
        if (offx>=0 && offy>=0 && offx<accessible.length && offy<accessible[0].length) return (accessible[offx][offy]==0);
        else return false;
    }
    
    public int height() {return accessible.length;}
    public int width() {return accessible[0].length;}
    public static final int GOAL = 20;
    
    public static void main (String args[]) {
    	System.out.println("Solving the mars exploration problem: ");
    	System.out.println();
    	
    	GoalTest goalTest = new MarsGoalTest();
    	Cell startingCell = new Cell(4,4);
    	HashSet<Cell> set = new HashSet<Cell>();
    	set.add(startingCell);
    	Position initialPosition = new Position(accessible, startingCell, set, GOAL);
    	
    	Node root = new Node (null, null, initialPosition);
    	AStarFunction aStarFunction = new AStarFunction(new MarsHeuristicFunction());
    	
    	MarsGraphSearch marsSolver = new MarsGraphSearch(new BestFirstFrontier(aStarFunction));
    	Node aStarMarsSolution = marsSolver.findSolution(root , goalTest);
    	if(aStarMarsSolution == null) {
    		aStarMarsSolution = marsSolver.retrieveBest();
    		Position position = (Position) aStarMarsSolution.state;
    		int moves = GOAL - position.moves;
    		System.out.println("There are no solutions to cover all " + GOAL + " squares");
    		System.out.println("The best solution covers " + marsSolver.maxLength + " squares in " + moves + " moves");
    		new MarsPrinting().printSolution(aStarMarsSolution);
    	}
    	else {
			System.out.println("Optimal path covering " + GOAL + " squares found!");
			new MarsPrinting().printSolution(aStarMarsSolution);
    	}
    }
}
