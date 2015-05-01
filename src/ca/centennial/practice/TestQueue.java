package ca.centennial.practice;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {

	public static void main(String[] args)
	{
		Queue<String> queue = new LinkedList<String>();
		queue.offer("Oklahoma");
		queue.offer("Indiana");
		queue.offer("Texas");
		queue.offer("Georgia");
		System.out.print(queue);
		
		//peek retrieves but does not remove the head of the queue
		System.out.print("\n" + queue.peek());
		System.out.print("\n" + queue);
		
		//poll retrieves and removes the head of the queue, returns null if the queue is empty
		System.out.print("\n" + queue.poll());
		System.out.print("\n" + queue);
		
		//remove retrieves and removes the head of the queue, generates exception if the queue is empty
		System.out.print("\n" + queue.remove());
		System.out.print("\n" + queue);
		
		
		
	}	


}
