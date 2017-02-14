package assignment02;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.LinkedList;


public class Deque<Item> implements Iterable<Item>
{
	
	private int sizeN;
	private LinkedList<Item> linkedList;
	
	// construct an empty deque
	public Deque()
	{		
		linkedList = new LinkedList<Item>();			
	}
	
	// is the deque empty?
	public boolean isEmpty()
	{
		return linkedList.isEmpty();
	}
	
	// return the number of items on the deque
	public int size()
	{
		return linkedList.size();
	}
	
	// insert the item at the front
	public void addFirst(Item item)
	{
		linkedList.addFirst(item);
	}
	
	// insert the item at the end
	public void addLast(Item item)
	{
		linkedList.addLast(item);
	}
	
	// delete and return the item at the front
	public Item removeFirst()
	{		
		return linkedList.pollFirst();
	}
	
	// delete and return the item at the end
	public Item removeLast()   
	{
		return linkedList.pollLast();
	}
	
	// return an iterator over items in order from front to end
	public Iterator<Item> iterator()  
	{
		return linkedList.iterator();
	}
	
	// unit testing
	public static void main(String[] args) 
	{
			
	}

	
	

}
