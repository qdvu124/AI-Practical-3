package search;

import java.util.HashSet;

public class GraphSearch implements Search {
	Frontier frontier;
	private int nodeGenerated = 0;
	public GraphSearch (Frontier frontier) {
		this.frontier = frontier;
	}
	@Override
	public Node findSolution(Node root, GoalTest goalTest) {
		// TODO Auto-generated method stub
		HashSet<State> visitedState= new HashSet<State>();
		frontier.addNode(root);
		nodeGenerated++;
		while (!frontier.isEmpty()) {
			Node node = frontier.removeNode();
			if(visitedState.contains(node.state))
				continue;
			visitedState.add(node.state);
			if (goalTest.isGoal(node.state))
				return node;
			else {
				for (Action action : node.state.getApplicableActions()) {
					State newState = node.state.getActionResult(action);
					if(!visitedState.contains(newState)) {
						frontier.addNode(new Node(node, action, newState));
						nodeGenerated++;
					}
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
		return frontier.maxSize();
	}
}
