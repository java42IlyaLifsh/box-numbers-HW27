package telrun.util;
//Ilya


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BoxNumbersTest {
	BoxNumbers boxNumbersForArrayList = new BoxNumbersArrayList();
	BoxNumbers boxNumbersForLinkedList = new BoxNumbersLinkedList();
	BoxNumbers boxNumbersForHashSet = new BoxNumbersHashSet();
	BoxNumbers boxNumbersForTreeSet = new BoxNumbersTreeSet();

	int[] forList = { 1, 3, 13, 7, 5, 5, 1, 7, 11 };
	int[] forSet = { 1, 11, 3, 7, 5, 13 };

	@BeforeEach
	void setUp() throws Exception {
		fillBoxNumbers(boxNumbersForArrayList, forList);
		fillBoxNumbers(boxNumbersForLinkedList, forList);
		fillBoxNumbers(boxNumbersForHashSet, forSet);
		fillBoxNumbers(boxNumbersForTreeSet, forSet);
	}

	private void fillBoxNumbers(BoxNumbers box, int[] forList) {
		for (int i = 0; i < forList.length; i++) {
			box.addNumber(forList[i]);
		}
	}

	@Test
	void testAddNumber() {
		// ArrayList
		assertTrue(boxNumbersForArrayList.addNumber(5));
		// LinkedList
		assertTrue(boxNumbersForLinkedList.addNumber(5));
		// HashSet
		assertTrue(boxNumbersForHashSet.addNumber(4));
		// adding the same number
		assertFalse(boxNumbersForHashSet.addNumber(5));
		// TreSet
		assertTrue(boxNumbersForTreeSet.addNumber(4));
		// adding the same number
		assertFalse(boxNumbersForTreeSet.addNumber(5));
	}
	@Test
	void testRemoveNumber() {
		// ArrayList
		assertTrue(boxNumbersForArrayList.removeNumber(13));
		assertFalse(boxNumbersForArrayList.containsNumber(13));
		// LinkedList
		assertTrue(boxNumbersForLinkedList.removeNumber(13));
		assertFalse(boxNumbersForLinkedList.containsNumber(13));
		// HashSet
		assertTrue(boxNumbersForHashSet.removeNumber(13));
		assertFalse(boxNumbersForHashSet.removeNumber(13));
		// TreeSet
		assertTrue(boxNumbersForTreeSet.removeNumber(13));
		assertFalse(boxNumbersForTreeSet.removeNumber(13));
	}
	//	int forList[] = {1, 3, 13, 7, 5, 5, 1, 7, 11};
	//	int forSet[] = {1, 11, 3, 7, 5, 13};
	@Test
	void testRemoveRepeated() {
		// ArrayList
		assertEquals(3, boxNumbersForArrayList.removeRepeated());
		assertEquals(0, boxNumbersForArrayList.removeRepeated());
		// LinkedList
		assertEquals(3, boxNumbersForLinkedList.removeRepeated());
		assertEquals(0, boxNumbersForLinkedList.removeRepeated());
		// HashSet
		assertEquals(0, boxNumbersForHashSet.removeRepeated());
		// TreeSet
		assertEquals(0, boxNumbersForTreeSet.removeRepeated());
	}

	@Test
	void testRemoveByPredicate() {
		// ArrayList
		assertEquals(2, boxNumbersForArrayList.removeByPredicate(p -> (p % 5 == 0)));
		assertEquals(7, boxNumbersForArrayList.removeByPredicate(p -> (p % 1 == 0)));
		// LinkedList
		assertEquals(2, boxNumbersForLinkedList.removeByPredicate(p -> (p % 5 == 0)));
		assertEquals(7, boxNumbersForLinkedList.removeByPredicate(p -> (p % 1 == 0)));
		// HashSet
		assertEquals(1, boxNumbersForHashSet.removeByPredicate(p -> (p % 13 == 0)));
		assertEquals(5, boxNumbersForHashSet.removeByPredicate(p -> (p % 1 == 0)));
		// TreeSet
		assertEquals(1, boxNumbersForTreeSet.removeByPredicate(p -> (p % 13 == 0)));
		assertEquals(5, boxNumbersForTreeSet.removeByPredicate(p -> (p % 1 == 0)));
	}
//	int forList[] = {1, 3, 13, 7, 5, 5, 1, 7, 11};
	//	int forSet[] = {1, 11, 3, 7, 5, 13};
	@Test
	void testRemoveInRange() {
		// ArrayList
		assertEquals(1, boxNumbersForArrayList.removeInRange(13, 5555));
		assertEquals(7, boxNumbersForArrayList.removeInRange(1, 11));
		// LinkedList
		assertEquals(1, boxNumbersForLinkedList.removeInRange(13, 555));
		assertEquals(7, boxNumbersForLinkedList.removeInRange(1, 11));
		// HashSet
		assertEquals(1, boxNumbersForHashSet.removeInRange(3, 5));
		assertEquals(3, boxNumbersForHashSet.removeInRange(7, 555));

		// TreeSet
		assertEquals(1, boxNumbersForTreeSet.removeInRange(13, 50));
		assertEquals(0, boxNumbersForTreeSet.removeInRange(13, 50));


	}

	@Test
	void testContainsNumber() {
		// ArrayList
		assertTrue(boxNumbersForArrayList.containsNumber(13));
		assertFalse(boxNumbersForArrayList.containsNumber(2));
		// LinkedList
		assertTrue(boxNumbersForLinkedList.containsNumber(13));
		assertFalse(boxNumbersForLinkedList.containsNumber(2));
		// HashSet
		assertTrue(boxNumbersForHashSet.containsNumber(13));
		assertFalse(boxNumbersForHashSet.containsNumber(2));
		// TreeSet
		assertTrue(boxNumbersForTreeSet.containsNumber(13));
		assertFalse(boxNumbersForTreeSet.containsNumber(2));

	}

}

