package search;

import java.util.LinkedList;

public class BreadthFirstFrontier implements Frontier {
	
	private int maxSize = Integer.MIN_VALUE;
	private LinkedList<Node> frontier;
	
	public BreadthFirstFrontier() {
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
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return frontier.isEmpty();
	}

	@Override
	public Node removeNode() {
		// TODO Auto-generated method stub
		if(isEmpty())
			return null;
		// BreadthFirstSearch using a queue, first in first out principle
		return frontier.removeFirst();
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		if(isEmpty())
			return;
		// Remove until the frontier is empty
		while(!isEmpty())
			frontier.removeFirst();
	}

	@Override
	// Return the maximum size of the frontier 
	public int maxSize() {
		// TODO Auto-generated method stub
		return maxSize;
	}

}
