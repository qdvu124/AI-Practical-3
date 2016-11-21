package mars;

import java.util.LinkedHashSet;
import java.util.Set;

import search.Action;
import search.State;

public class Position implements State {
	
	private Set<Cell> visitedCells;
	protected final int[][] map;
	protected final int currentRow;
	protected final int currentColumn;
	protected final int width;
	protected final int length;
	
	public Position (int[][] map, Cell currentCell) {
		this.map = map;
		currentRow = currentCell.getRow();
		currentColumn = currentCell.getColumn();
		width = map.length;
		length = map[0].length;
	}

	@Override
	public Set<? extends Action> getApplicableActions() {
		// TODO Auto-generated method stub
		Set<Action> actions = new LinkedHashSet<Action>();
		
		return actions;
	}

	@Override
	public State getActionResult(Action action) {
		// TODO Auto-generated method stub
		return null;
	}

}
