package mars;

import search.Node;
import search.NodeFunction;

public class MarsHeuristicFunction implements NodeFunction {
	private final int GOAL = 20;
	@Override
	public int costFunction(Node node) {
		// TODO Auto-generated method stub
		Position position = (Position) node.state;
		return GOAL - position.countVisitedCells();
	}
}
