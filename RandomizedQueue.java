package A02_Randomized_Queue_and_Deques;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private int n; //size of the list
	private Node first; //initial pointer
	
	// construct an empty randomized queue
	public RandomizedQueue(){
		this.n = 0;
		first = null;
		assert check();
	}
	
	// if first == null, the list is empty (returns true) otherwise it returns false
	public boolean isEmpty(){		
		return (first==null);
	}
	
	// return the number of items on the queue
	public int size(){
		return n;
	}
	
	/*
	 * Adds an item to the list in a random order
	 * @param item the item to add
	 */
	public void enqueue(Item item){
		Node tempNode = new Node();
		tempNode.item = item;
		
		//if the list is empty, make this item the first item
		if (n==0){
			first = tempNode;
		}
		//if the list is not empty add this item randomly to the list
		else{
			int R = getRandomNumber(n); //get a random number between 0 and (size of list)
			
			//iterate through the list until you get to the Random null
			Node pointer = first;//set the pointer to the beginning
			int i = 0;//temporary counter
			
			 //go to point R in the list
			while (i<R){
				pointer = pointer.next;
				i++;
			}
			if (!hasNext(pointer)){
				pointer.next = tempNode; //pointer has no next, so tempNode becomes next
			}
			else{
				tempNode.next=pointer.next;	//make tempNode's next the same as pointer's
				pointer.next=tempNode;		//make pointer's next tempNode
			}
		}
		n++; //increment the count
		assert check();//check list size with n
	}
	
	/*
	 * dequeue selects an item in the list at random and returns and removes the item from the list
	 * 
	 * this method picks a random number, and moves to that random number in the list
	 * it then saves it in a temporary node and adjusts the previous items "next"
	 * it then decrements the count
	 */
	public Item dequeue(){
		int R = getRandomNumber(n-1); //get a random number between 0 and (one less than list size)
		Node pointer = first; //set pointer to the beginning
		Node previous=pointer; //this node will ultimately point to the parent node of pointer
		int i = 0;//temporary counter
		
		 //go to point R in the list
		while (i<R){
			if (hasNext(pointer)){		//save against out of bounds, this should never be false
				previous=pointer;		//previous references same object as pointer
				pointer = pointer.next; //pointer becomes it's .next leaving previous as parent of pointer
				i++;
			}
		}
		//at this point we will be returning pointer.item
		
		if (hasNext(pointer)){
			previous.next=pointer.next;		//adjust previous.next to skip pointer
		}
		else{previous.next = null;}			//pointer was at the end, now previous is at the end
		
		pointer.next=null; 				//clean up lingering reference
		n--;							//decrement the count
		assert check();					//check list size with n
		return pointer.item;			//return the item pointer is referencing		
	}
	
	// return (but do not delete) a random item
	public Item sample(){
		int R = getRandomNumber(n-1); 	//get a random number between 0 and list size
		Node pointer = first; 			//set pointer to the beginning
		int i = 0;						//temporary counter
		
		 //go to point R in the list
		while (i<R){
			if (hasNext(pointer)){			//save against out of bounds
				pointer = pointer.next; 	//pointer becomes it's .next
				i++;
			}
		}		
		return pointer.item;			//return the item pointer is referencing
	}
    
	/*
	 * Node is a helper linked list class
	 * The design of this is based off of Sedgwick's LinkedStack.java example
	 * 
	 * Item holds a reference to an object
	 * next holds a reference to the next object in the list
	 */
	private class Node{
		private Item item;
		private Node next;
	}
	
	/* 
	 * check if the Node has a next object
	 * returns true if it does NOT have a null next
	 */
	private boolean hasNext(Node pointer){
		return (pointer.next!=null);
	}
	
	//this function returns a random integer between 0 and (num - 1)
	public int getRandomNumber(int num){
		return StdRandom.uniform(num);
	}
	
	// return an independent iterator over items in random order
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	/*
	 * I am using the ListIterator method from Sedgwick's example as a guide
	 */
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext(){return current!=null;};
		public void remove(){ throw new UnsupportedOperationException();}
		
		public Item next(){
			if(!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item; 
		}
	}
	
/*
 * check() checks internal invariants
 * 
 * it is based off of Sedgwick's LinkedStack.java check() method
 * 
 * check() tests the count of the list against the value of n
 * if the two are not equal, there is a problem and false is returned
 */
    private boolean check() {

        // check a few properties of instance variable 'first'
        if (n < 0) {
            return false;
        }
        if (n == 0) {
            if (first != null) return false;
        }
        else if (n == 1) {
            if (first == null)      return false;
            if (first.next != null) return false;
        }
        else {
            if (first == null)      return false;
            if (first.next == null) return false;
        }

        // check internal consistency of instance variable n
        int numberOfNodes = 0;
        for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != n) return false;

        return true;
    }
	
	public static void main(String[] args) {
		RandomizedQueue RQ = new RandomizedQueue();		
		System.out.println("isEmpty test: " + RQ.isEmpty());
		
		RQ.enqueue("0");
		RQ.enqueue("1");
		RQ.enqueue("2");
		RQ.enqueue("3");
		RQ.enqueue("4");
		RQ.enqueue("5");
		RQ.enqueue("6");
		RQ.enqueue("7");
		RQ.enqueue("8");
		RQ.enqueue("9");
		
		//test enqueue method
		System.out.print("enqueue test: ");
		RandomizedQueue n = new RandomizedQueue();
		String TestString = "Test";		
		n.enqueue(TestString);		
		Object newString = n.first.item;
		if (TestString.equals(newString))System.out.println("enque method passes");
		
		//test dequeue method
		System.out.print("dequeue test: ");
		System.out.print("RQ size: " + RQ.size() + " ");
		Object f = RQ.dequeue();
		System.out.print(f.toString());
		System.out.println(" RQ size: " + RQ.size());
		
		//test sample method
		System.out.print("sample test: ");
		Object h = RQ.sample();
		System.out.println(h.toString());
		
		//test Iterator
		System.out.println("iterator test:");
		Iterator myIt = RQ.iterator();
		for (int i = 0; i < RQ.size(); i++){
			System.out.println(myIt.next().toString());
		}
		
	}
	
}//end of RandomizedQueue class
