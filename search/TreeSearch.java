package search;

public class TreeSearch implements Search {
	Frontier frontier;
	private int nodeGenerated = 0;
	public TreeSearch(Frontier frontier) {
		this.frontier = frontier;
	}

	@Override
	public Node findSolution(Node root, GoalTest goalTest) {
		// TODO Auto-generated method stub
		frontier.addNode(root);
		nodeGenerated++;
		while (!frontier.isEmpty()) {
			Node node = frontier.removeNode();
			if (goalTest.isGoal(node.state))
				return node;
			else {
				for (Action action : node.state.getApplicableActions()) {
					State newState = node.state.getActionResult(action);
					frontier.addNode(new Node(node, action, newState));
					nodeGenerated++;
				}
			}
		}
		return null;
	}

	@Override
	public int nodeGenerated() {
		// TODO Auto-generated method stub
		return nodeGenerated;
	}
	
	public int frontierMaxSize() {
		return this.frontier.maxSize();
	}
}
