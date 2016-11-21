package tour;

import search.BestFirstFrontier;
import search.BreadthFirstFrontier;
import search.BreadthFirstTreeSearch;
import search.DepthFirstFrontier;
import search.TreeSearch;
import search.GraphSearch;
import search.GoalTest;
import search.Node;

public class BFTS_Demo {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on Romania tour");
		System.out.println();
		
		Cities romania = SetUpRomania.getRomaniaMapSmall();
		City startCity = romania.getState("Bucharest");
		Node root = new Node(null, null, new TourState(startCity));
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		//Node solution = BreadthFirstTreeSearch.findSolution(new TourState(startCity), goalTest);
		//new TourPrinting().printSolution(solution);
		
		// Testing different tree search strategies
		System.out.println("Breadth first tree: ");
		TreeSearch BfsTreeSearch = new TreeSearch(new BreadthFirstFrontier());
		Node BfsTreeSolution = BfsTreeSearch.findSolution(root, goalTest);
		System.out.println("BfsTreeSearch generated " + BfsTreeSearch.nodeGenerated());
		System.out.println("Frontier size " + BfsTreeSearch.frontierMaxSize());
		//new TourPrinting().printSolution(BfsTreeSolution);
	/*	
		System.out.println("Depth first tree: ");
		TreeSearch DfsTreeSearch = new TreeSearch(new DepthFirstFrontier());
		Node DfsTreeSolution = DfsTreeSearch.findSolution(root, goalTest);
		new TourPrinting().printSolution(DfsTreeSolution);

*/		// Testing different graph search strategies
		System.out.println("Breadth first graph: ");
		GraphSearch BfsGraphSearch = new GraphSearch(new BreadthFirstFrontier());
		Node BfsGraphSolution= BfsGraphSearch.findSolution(root, goalTest);
		System.out.println("BfsGraphSearch generated " + BfsGraphSearch.nodeGenerated());
		System.out.println("Frontier size " + BfsGraphSearch.frontierMaxSize());
		//new TourPrinting().printSolution(BfsGraphSolution);
		
		System.out.println("Depth first graph: ");
		GraphSearch DfsGraphSearch = new GraphSearch(new DepthFirstFrontier());
		Node DfsGraphSolution = DfsGraphSearch.findSolution(root, goalTest);
		new TourPrinting().printSolution(DfsGraphSolution);

		BestFirstFrontier bestFirstFrontier = new BestFirstFrontier (new TourHeuristic(romania.getAllCities(), startCity));
	}
}
