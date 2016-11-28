package mars;

import search.GoalTest;
import search.State;

public class MarsGoalTest implements GoalTest {
	static final int GOAL = 20;
	@Override
	public boolean isGoal(State state) {
		// TODO Auto-generated method stub
		Position position = (Position) state;
		return position.countVisitedCells() == GOAL;
	}
}
