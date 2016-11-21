package search;

public class AStarFunction implements NodeFunction {
	private NodeFunction heuristicFunction;
	
	public AStarFunction(NodeFunction heuristicFunction) {
		this.heuristicFunction = heuristicFunction;
	}

	@Override
	public int costFunction(Node node) {
		// TODO Auto-generated method stub
		return node.costFromStart + heuristicFunction.costFunction(node);
	}

}
