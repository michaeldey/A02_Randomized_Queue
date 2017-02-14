package assignment02;

import java.util.Iterator;
import edu.princeton.cs.introcs.*;


public class RandomizedQueue<Item> implements Iterable<Item> 
{

	 private Item[] a;
	 private int sizeN;
	 
	 public RandomizedQueue()                 // construct an empty randomized queue
	 {
		 Item[] a = (Item[]) new Object[1];
	 }
	 
	 public boolean isEmpty()                 // is the queue empty?
	 {
		 return sizeN == 0;
	 }
	 
     public int size()                        // return the number of items on the queue
     {
    	 return sizeN;
    	 
     }
     public void enqueue(Item item)           // add the item
     {
    	 
     }
     
     public Item dequeue()                    // delete and return a random item
     {
    	 return null;
     }
     
     public Item sample()                     // return (but do not delete) a random item
     {
    	 return a[StdRandom.uniform(sizeN)];    	 
     }
     
     public Iterator<Item> iterator()         // return an independent iterator over items in random order
     {
    	 return null;
     }
     
     public static void main(String[] args)   // unit testing
     {
    	 RandomizedQueue<String> a = new RandomizedQueue<String>();  
         while (!StdIn.isEmpty()) 
         {  
             String item = StdIn.readString();              
         }  
           
     }
	
	
}
