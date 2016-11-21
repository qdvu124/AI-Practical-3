package npuzzle;

import search.Node;
import search.NodeFunction;

public class MisplacedTilesHeuristicFunction implements NodeFunction {

	int misplacedCount;

	@Override
	public int costFunction(Node node) {
		misplacedCount = 0;
		// TODO Auto-generated method stub
		Tiles tiles = (Tiles) node.state;
		for(int i = 0; i < tiles.tiles.length - 1; i++) {
			if(tiles.tiles[i] != i + 1)
				misplacedCount++;
		}
		//if(tiles.tiles[tiles.tiles.length - 1] != 0)
		//	misplacedCount++;
		return misplacedCount;
	}

}
