package tour;

import java.util.Set;

import search.Node;
import search.NodeFunction;

public class TourHeuristic implements NodeFunction {
	
	Set<City> visitedCities;
	City goal;
	
	public TourHeuristic(Set<City> set, City goal) {
		this.visitedCities = set;
		this.goal = goal;
	}

	@Override
	public int costFunction(Node node) {
		// TODO Auto-generated method stub
		return 0;
	}

}
