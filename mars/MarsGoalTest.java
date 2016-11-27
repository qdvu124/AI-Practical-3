package mars;

import search.GoalTest;
import search.State;

public class MarsGoalTest implements GoalTest {
	static final int GOAL = 20;
	Position[] solutions = new Position[GOAL];
	@Override
	public boolean isGoal(State state) {
		// TODO Auto-generated method stub
		Position position = (Position) state;
		if(solutions[position.countVisitedCells()] == null)
			solutions[position.countVisitedCells()] = position;
		return position.countVisitedCells() == GOAL;
	}
}
