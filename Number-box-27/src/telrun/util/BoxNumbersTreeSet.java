package telrun.util;

import java.util.TreeSet;

//ILYA
public class BoxNumbersTreeSet extends BoxNumbersSet {

	public BoxNumbersTreeSet() {

		collection=new TreeSet<Integer>();
	}
	
	@Override
	public int removeInRange(int minInclusive, int maxExclusive) {
		TreeSet<Integer> subset = 
				(TreeSet<Integer>) ((TreeSet<Integer>)collection).subSet(minInclusive, maxExclusive);
		int countRemNum = subset.size();
		subset.clear();
		return countRemNum;
	}

}
