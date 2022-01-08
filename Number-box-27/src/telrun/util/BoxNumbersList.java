package telrun.util;

import java.util.HashSet;

//ILYA
public abstract class BoxNumbersList extends BoxNumbersColleection {
	
	@Override
	public int removeRepeated() {
		HashSet<Integer> hashSet = new HashSet<>(collection);
		int countRemNum = collection.size() - hashSet.size();
		updateCollectionByHashSet(hashSet);
		return countRemNum;
	}

	protected abstract void updateCollectionByHashSet(HashSet<Integer> hashSet);

}
