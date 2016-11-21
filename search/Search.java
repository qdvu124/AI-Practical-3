package search;

public interface Search {
	Node findSolution(Node root, GoalTest test);
	int nodeGenerated();
}
