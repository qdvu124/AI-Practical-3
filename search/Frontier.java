package search;

public interface Frontier {
	// Outlines the common behaviours for both types of frontiers
	void addNode(Node node);
	boolean isEmpty();
	Node removeNode();
	void removeAll();
	int maxSize();
}
