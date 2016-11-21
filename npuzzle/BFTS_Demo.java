package npuzzle;

import search.TreeSearch;
import search.GraphSearch;
import search.AStarFunction;
import search.BestFirstFrontier;
import search.BreadthFirstFrontier;
import search.DepthFirstFrontier;
import search.GoalTest;
import search.Node;

public class BFTS_Demo {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on 8-puzzle");
		System.out.println();
		
		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
	/*	
		Tiles sinitialConfiguration = new Tiles(new int[][] {
			{ 1, 0, 3 },
			{ 4, 2, 6 },
			{ 7, 5, 8 }
		});
*/		
		GoalTest goalTest = new TilesGoalTest();
		Node root = new Node(null, null, initialConfiguration);
		
		//Testing performances for TreeSearch
		TreeSearch BfsTreeSearch = new TreeSearch(new BreadthFirstFrontier());
		Node BfsTreeSolution = BfsTreeSearch.findSolution(root, goalTest);
		System.out.println("BfsTreeSearch generated " + BfsTreeSearch.nodeGenerated() + " nodes");
		System.out.println("Maximum frontier size: " + BfsTreeSearch.frontierMaxSize());
		//new NPuzzlePrinting().printSolution(BfsTreeSolution);
		
		TreeSearch DfsTreeSearch = new TreeSearch(new DepthFirstFrontier());
		//Node DfsTreeSolution = DfsTreeSearch.findSolution(root, goalTest);
		System.out.println("DfSTreeSearch generated " + DfsTreeSearch.nodeGenerated() + " nodes");
		System.out.println("Maximum frontier size: " + DfsTreeSearch.frontierMaxSize());
		//new NPuzzlePrinting().printSolution(DfsTreeSolution);
		
		//Testing performances for GraphSearch
		GraphSearch BfsGraphSearch = new GraphSearch(new BreadthFirstFrontier());
		Node BfsGraphSolution = BfsGraphSearch.findSolution(root, goalTest);
		System.out.println("BfsGraphSearch generated " + BfsGraphSearch.nodeGenerated() + " nodes");
		System.out.println("Maximum frontier size: " + BfsGraphSearch.frontierMaxSize());
		//new NPuzzlePrinting().printSolution(BfsGraphSolution);
		
		GraphSearch DfsGraphSearch = new GraphSearch(new DepthFirstFrontier());
		Node DfsGraphSolution = DfsGraphSearch.findSolution(root, goalTest);
		System.out.println("DfsGraphSearch generated " + DfsGraphSearch.nodeGenerated() + " nodes");
		System.out.println("Maximum frontier size: " + DfsGraphSearch.frontierMaxSize());
		//new NPuzzlePrinting().printSolution(DfsGraphSolution);
		
		AStarFunction aStarFunction = new AStarFunction(new MisplacedTilesHeuristicFunction());

		//Testing performances for A* TreeSearch
		TreeSearch AStarTreeSearch = new TreeSearch(new BestFirstFrontier(aStarFunction));
		Node AStarTreeSolution = AStarTreeSearch.findSolution(root, goalTest);
		System.out.println("AStarTreeSearch generated " + AStarTreeSearch.nodeGenerated() + " nodes");
		System.out.println("Maximum frontier size: " + AStarTreeSearch.frontierMaxSize());
		//new NPuzzlePrinting().printSolution(AStarTreeSolution);
		
		//Testing performances for A* Graph Search 
		GraphSearch AStarGraphSearch = new GraphSearch(new BestFirstFrontier(aStarFunction));
		Node AStarGraphSolution= AStarGraphSearch.findSolution(root, goalTest);
		System.out.println("AStarGraphSearch generated " + AStarGraphSearch.nodeGenerated() + " nodes");
		System.out.println("Maximum frontier size: " + AStarGraphSearch.frontierMaxSize());
		//new NPuzzlePrinting().printSolution(AStarGraphSolution);


	}
}
