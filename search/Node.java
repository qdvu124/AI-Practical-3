package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public final int depth;
	public int value = Integer.MAX_VALUE;
	public int costFromStart;
	
	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		if(this.parent == null) {
			costFromStart = 0;
			depth = 0;
		}
		else {
			costFromStart = parent.costFromStart + action.cost();
			depth = parent.depth + 1;
		}
		this.action = action;
		this.state = state;
	}
	
	public void setValue(int cost) {
		value = cost;
	}
}
