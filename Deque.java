package A02_Randomized_Queue_and_Deques;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.*;
import edu.princeton.cs.introcs.*;
import java.util.LinkedList;


public class Deque<Item> implements Iterable<Item>
{

	/**
	 * Integer - Size of stack
	 */
	private int sizeNode;          // size of the stack
	/**
	 * Node - represent the first node of the stack
	 */
    private Node firstNode;     // top of stack
    /**
     * Node - represent the last node of the stack
     */
    private Node lastNode;
    
    /**
     * Helper link list class that contains the Node data type
     */
    private class Node 
    {
        private Item item;
        private Node next;
        private Node prev;
    }
	
	
	/**
	 * NoArg Construtor that initializes an empty stack
	 */
	public Deque()
	{		
		int sizeNode=0;
		firstNode = null;
		lastNode = null;
	}
		
	/**
	 * Is the stack empty?
	 * @return true if stack is empy, false if stack is not 
	 */
	public boolean isEmpty()
	{
		return firstNode == null;
	}
		
	/**
     * Returns the number of items in the stack.
     * @return the number of items in the stack
     */
	public int size()
	{
		return sizeNode;
	}
		
	 /**
     * Adds the item to this fist of the stack.
     * @param item the item to add
     */
	public void addFirst(Item item)
	{
		if (item == null) throw new NullPointerException();
				
		Node oldFirst = firstNode;
		
		firstNode = new Node();
		firstNode.item = item;
		
		//setup the prev and next pointer to next node
		if (isEmpty())
		{
			lastNode = firstNode;
			firstNode.next = null;
		}
		else
		{
			firstNode.next = oldFirst;
			oldFirst.prev = firstNode;
		}
			 	
		sizeNode++;
	}
		
	/**
     * Adds the item to this last/end of the stack stack.
     * @param item the item to add
     */
	public void addLast(Item item)
	{
		if (item == null) throw new NullPointerException();

		Node oldLast = lastNode;
		lastNode = new Node();
		lastNode.item = item;
		lastNode.next = null;
		
		//setup the prev and next pointer to next node
		if (isEmpty())
		{
			firstNode = lastNode;
			lastNode.prev = null;			
		}
		else
		{
			lastNode.prev = oldLast;
			oldLast.next = lastNode;			
		}
		sizeNode++;
		
	}
		
	/**
	 * Remove the first item from the stack
	 * @return item item that was removed from stack
	 */
	public Item removeFirst()
	{	
		if (isEmpty()) throw new UnsupportedOperationException();
    	Item oldFirst = firstNode.item;        // save item to return
    	firstNode = firstNode.next;            // delete first node
    	
        
    	if (isEmpty())
    	{
    		lastNode=null;
    		firstNode=null;
    	}
    	else
    	{
    		firstNode.prev=null;
    	}
    	sizeNode--;
        return oldFirst;                   // return the saved item
	}
		
	/**
	 * Remove the last item from the stack
	 * @return item item that was removed from stack
	 */
	public Item removeLast()   
	{
		if (isEmpty()) throw new UnsupportedOperationException();
		
		Item oldLast = lastNode.item;
		
	    lastNode = lastNode.prev;
	    
	    if (isEmpty())
	    {
	    	firstNode = null;
	    	lastNode = null;
	    }
	    else
	    {
	    	lastNode.next = null;	    	
	    }
	
		sizeNode--;
		return oldLast;
	}
	
	
	 /**
     * Returns a string representation of this stack.
     * @return the sequence of items in the stack in LIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }
       
	
    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     * @return an iterator to this stack that iterates through the items in LIFO order.
     */
	public Iterator<Item> iterator()  
	{
		return new ListInterator();
	}
	
	/**
	 * Helper iterator that returns the stack
	 */
	private class ListInterator implements Iterator<Item>
	{
		private Node current = firstNode;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
	}
	
	
	// unit testing
	public static void main(String[] args) 
	{
		LinkedStack<String> stack = new LinkedStack<String>();
		while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
		 
		 
	}



}