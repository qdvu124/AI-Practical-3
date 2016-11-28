package mars;

import java.util.HashSet;

import search.Action;
import search.Frontier;
import search.GoalTest;
import search.GraphSearch;
import search.Node;
import search.State;

public class MarsGraphSearch extends GraphSearch {
	
	final int GOAL = 20; 
	Node[] solutions = new Node[GOAL + 1];
	int maxLength = Integer.MIN_VALUE;

	public MarsGraphSearch(Frontier frontier) {
		super(frontier);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Node findSolution(Node root, GoalTest goalTest) {
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
				Position position = (Position) node.state;
				if(solutions[position.countVisitedCells()] == null) {
					solutions[position.countVisitedCells()] = node;
					maxLength = Math.max(maxLength, position.countVisitedCells());
				}
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
	
	public Node retrieveBest() {
		return solutions[maxLength];
	}
}
