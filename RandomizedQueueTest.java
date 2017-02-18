package A02_Randomized_Queue_and_Deques;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class RandomizedQueueTest {

	@Test
	public void testRandomizedQueue() {
		RandomizedQueue n = new RandomizedQueue();
		assertTrue(n.isEmpty());					//test constructor works and n is empty
		assertEquals(0, n.size());					//double test that n is empty
	}

	@Test
	public void testIsEmpty() {
		RandomizedQueue n = new RandomizedQueue();
		assertTrue(n.isEmpty());
	}

	@Test
	public void testSizeZero() {
		RandomizedQueue n = new RandomizedQueue();
		int size = n.size();
		
		assertEquals(size, 0);
	}
	
	@Test
	public void testSizeMultiple() {
		RandomizedQueue n = new RandomizedQueue();
		boolean test = false;
		for (int i = 0; i < 10; i++){
			n.enqueue("test");
			if (n.size() == (i+1)){
				test = true;
			}
			else{
				test=false;
				break;
			}
		}			
		assertTrue(test);
	}
	
	@Test
	public void testEnqueue() {
		RandomizedQueue n = new RandomizedQueue();
		int size1 = n.size();
		assertEquals(size1, 0);
		assertTrue(n.isEmpty());
		n.enqueue("test");
		int size2 = n.size();
		assertEquals(size2, 1);
		assertFalse(n.isEmpty());
		assertNotEquals(size1,size2);
	}

	@Test
	public void testDequeue() {
		RandomizedQueue n = new RandomizedQueue();
		boolean test = false;
		
		String Test1 = "1";
		String Test2 = "2";
		String Test3 = "3";
		
		n.enqueue(Test1);
		n.enqueue(Test2);
		n.enqueue(Test3);
		Object f = n.dequeue(); 	//f should be one of the three items
		
		if (f.equals(Test1) || f.equals(Test2) || f.equals(Test3))test = true;		
		assertTrue(test);
		
		assertEquals(2, n.size()); //the size of the list should have decremented by one and is now 2
	}
	
	@Test
	public void testSample() {
		RandomizedQueue n = new RandomizedQueue();
		boolean test = false;
		
		String Test1 = "1";
		String Test2 = "2";
		String Test3 = "3";
		
		n.enqueue(Test1);
		n.enqueue(Test2);
		n.enqueue(Test3);
		Object f = n.sample(); 	//f should be one of the three items
		
		if (f.equals(Test1) || f.equals(Test2) || f.equals(Test3))test = true;		
		assertTrue(test);
	}
	
	@Test
	public void testIterator() {
		RandomizedQueue n = new RandomizedQueue();
		boolean test = false;
		
		String Test1 = "1";
		String Test2 = "2";
		
		n.enqueue(Test1);
		n.enqueue(Test2);
		
		Iterator myIt = n.iterator();
		Object one = myIt.next();
		Object two = myIt.next();
		
		if ((one.equals(Test1) && two.equals(Test2)) || 
			(one.equals(Test2) && two.equals(Test1))){
			test = true;
		}
		
		assertTrue(test);
	}

}
