package mars;

public class Cell {
	private int row;
	private int column;
	
	public Cell(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public int hashCode() {
		return row * 2 + column * 3;
	}
	
	public boolean equals(Object another) {
		Cell anotherCell = (Cell) another;
		return row == anotherCell.getRow() && column == anotherCell.getColumn();
	}
}
