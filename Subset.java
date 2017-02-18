package assignment02;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Subset {

	public static void main(String[] args) 
	{
		RandomizedQueue<String> randQ = new RandomizedQueue<>();
		
		int k =  Integer.parseInt(args[0]);
		
		StdOut.println("Enter sequence of strings :");
		while (!StdIn.isEmpty())
		{
			randQ.enqueue(StdIn.readString());		
		}
		
		for (int i = 0; i < k; i++)
		{
			StdOut.println(randQ.dequeue() );			
		}
		

	}

}
