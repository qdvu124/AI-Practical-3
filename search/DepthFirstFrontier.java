package search;

import java.util.LinkedList;

public class DepthFirstFrontier implements Frontier {
	
	private int maxSize;
	private LinkedList<Node> frontier; 
	
	public DepthFirstFrontier() {
		maxSize = Integer.MIN_VALUE;
		frontier = new LinkedList<Node>();
	}

	@Override
	public void addNode(Node node) {
		// TODO Auto-generated method stub
		frontier.addLast(node);
		if(frontier.size() > maxSize)
			maxSize = frontier.size();
	}

	@Override
	public Node removeNode() {
		// TODO Auto-generated method stub
		// DepthFirstSearch using a stack, last in first out principle
		if(isEmpty())
			return null;
		return frontier.removeLast();
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return frontier.isEmpty();
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		if(isEmpty())
			return;
		// Remove until the frontier is empty
		while(!isEmpty()) 
			frontier.removeLast();
	}

	@Override
	// Return the maximum size of the frontier
	public int maxSize() {
		// TODO Auto-generated method stub
		return maxSize;
	}
}
