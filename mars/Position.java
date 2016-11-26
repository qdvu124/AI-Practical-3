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
	protected final int moves;
	
	public Position (int[][] map, Cell currentCell, int moves) {
		this.map = map;
		this.moves = moves;
		currentRow = currentCell.getRow();
		currentColumn = currentCell.getColumn();
		width = map.length;
		length = map[0].length;
	}

	@Override
	public Set<? extends Action> getApplicableActions() {
		// TODO Auto-generated method stub
		if(moves == 0)
			return null;
		Set<Action> actions = new LinkedHashSet<Action>();
		for (Movement movement : Movement.values()) {
			int newRow = currentRow + movement.deltaRow;
			int newColumn = currentColumn + movement.deltaColumn;
			if (0 <= newRow && newRow < width && 0 <= newColumn && newColumn < length)
				if(map[newRow][newColumn] == 0)
					actions.add(movement);
		}
		return actions;
	}

	@Override
	public State getActionResult(Action action) {
		// TODO Auto-generated method stub
		Movement movement = (Movement) action;
		int newRow = currentRow + movement.deltaRow;
		int newColumn = currentColumn + movement.deltaColumn;
		return new Position(this.map, new Cell(newRow, newColumn), moves - 1);
	}
	
	public int hashCode() {
		return currentRow * 2 + currentColumn * 3 + visitedCells.size() * 5;
	}
	
	public boolean equals(Object object) {
		Position other = (Position) object;
		for(Cell cell: visitedCells)
			if(!other.visitedCells.contains(cell))
				return false;
		if(other.moves != this.moves)
			return false;
		return true;
	}

}
