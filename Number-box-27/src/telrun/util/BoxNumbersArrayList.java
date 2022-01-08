package telrun.util;
import java.util.ArrayList;
//ILYA
import java.util.HashSet;

public class BoxNumbersArrayList extends BoxNumbersList{

	public BoxNumbersArrayList() {

		collection = new ArrayList<Integer>();
	}

	@Override
	protected void updateCollectionByHashSet(HashSet<Integer> hashSet) {

		collection = new ArrayList<Integer>(hashSet);
		
	}

}
