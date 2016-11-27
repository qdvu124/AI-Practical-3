package mars;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import search.Action;
import search.State;

public class Position implements State {
	
	private HashSet<Cell> visitedCells;
	protected final int[][] map;
	protected final int currentRow;
	protected final int currentColumn;
	protected final int width;
	protected final int length;
	protected final int moves;
	
	public Position (int[][] map, Cell currentCell, HashSet<Cell> visitedCells, int moves) {
		this.visitedCells = (HashSet<Cell>) visitedCells;
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
		Cell next = new Cell(newRow, newColumn);
		HashSet<Cell> newVisitedCells = new HashSet<Cell>();
		newVisitedCells.addAll(visitedCells);
		newVisitedCells.add(next);
		return new Position(this.map, next, newVisitedCells, moves - 1);
	}
	
	public int countVisitedCells() {
		return visitedCells.size();
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
