package mars;

import search.Action;
import search.Printing;
import search.State;

public class MarsPrinting extends Printing {
	public void print(Action action) {
		System.out.print("Move: ");
		System.out.print(((Movement)action).name());
	}

	@Override
	public void print(State state) {
		// TODO Auto-generated method stub
		Position position = (Position) state;
		int[][] map = position.map;
		int currentRow = position.currentRow;
		int currentColumn = position.currentColumn;
		map[currentRow][currentColumn] = 2;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
