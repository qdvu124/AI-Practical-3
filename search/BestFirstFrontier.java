package search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirstFrontier implements Frontier {
	
	private PriorityQueue<Node> frontier;
	private NodeFunction nodeFunction;
	private int maxSize;
	
	public BestFirstFrontier(NodeFunction function) {
		nodeFunction = function;
		maxSize = Integer.MIN_VALUE;
		frontier = new PriorityQueue<Node> (1, new Comparator<Node>() {
			public int compare (Node node1, Node node2) {
				return node1.value - node2.value;
			}
		});
	}

	@Override
	public void addNode(Node node) {
		// TODO Auto-generated method stub
		node.setValue(nodeFunction.costFunction(node));
		frontier.add(node);
		if(maxSize < frontier.size())
			maxSize = frontier.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return frontier.isEmpty();
	}

	@Override
	public Node removeNode() {
		// TODO Auto-generated method stub
		if(frontier.isEmpty())
			return null;
		return frontier.remove();
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		while(!frontier.isEmpty())
			frontier.remove();
	}

	@Override
	public int maxSize() {
		// TODO Auto-generated method stub
		return maxSize;
	}

}
