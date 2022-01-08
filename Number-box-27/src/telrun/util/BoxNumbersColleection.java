package telrun.util;
import java.util.Collection;
//ILYA
import java.util.Iterator;
import java.util.function.Predicate;

public abstract class BoxNumbersColleection implements BoxNumbers {

	protected Collection <Integer> collection;
	
	
	@Override
	public Iterator<Integer> iterator() {
		 
		return collection.iterator();
	}

	@Override
	public boolean addNumber(int number) {
		 
		return collection.add(number);
	}

	@Override
	public boolean removeNumber(int number) {
		 
		return collection.remove(number);
	}

	/*
	@Override
	public int removeRepeated() {
		//  Auto-generated method stub
		return 0;
	}

*/
	
	@Override
	public int removeByPredicate(Predicate<Integer> predicate) {
		
		int sizeBeforeRemove = collection.size();
		collection.removeIf(predicate);
		return sizeBeforeRemove-collection.size();
	}

	
	@Override
	public int removeInRange(int minInclusive, int maxExclusive) {
	 
		return removeByPredicate(num -> num>=minInclusive && num < maxExclusive);
	}

	@Override
	public boolean containsNumber(int number) {
		
		return collection.contains(number);
	}

}
