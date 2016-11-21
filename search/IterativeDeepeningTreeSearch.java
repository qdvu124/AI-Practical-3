package search;

public class IterativeDeepeningTreeSearch implements Search {
	Frontier frontier = new DepthFirstFrontier();
	private int nodeGenerated = 0;

	@Override
	public Node findSolution(Node root, GoalTest test) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nodeGenerated() {
		// TODO Auto-generated method stub
		return nodeGenerated;
	}

}
