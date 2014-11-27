package ca.centennial.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class CollectionTester {

	public static void main(String[] args) {
		//testArrayList();
		// initialize a arraylist
		System.out.println("\nArrayList:");
		List<Integer> arrayList1 = new ArrayList<>();
		// add 10 random numbers
		Random rd = new Random();
		for (int i = 0; i< 10; i++){
			arrayList1.add(rd.nextInt(100));
		}
		System.out.println(arrayList1);
		arrayList1.set(0, 1);
		arrayList1.set(1, 2);
		arrayList1.set(2, 3);
		System.out.println(arrayList1);

		// create a linkedlist
		System.out.println("\nLinkedList:");
		LinkedList<Object> linkedList1 = new LinkedList<Object>(arrayList1);
		System.out.println(linkedList1);
		linkedList1.add(0, "andy");
		linkedList1.removeLast();
		System.out.println(linkedList1);
		linkedList1.add(0, "john");
		System.out.println(linkedList1);
		// iterator
		System.out.println("\nListIterator:");
		ListIterator<Object> it = linkedList1.listIterator();
		while (it.hasNext()){
			System.out.print(it.next() + " ");
		}
		System.out.println();
		ListIterator<Object> it2 = linkedList1.listIterator(linkedList1.size());
		while (it2.hasPrevious()){
			System.out.print(it2.previous() + " ");
		}
	}

	private static void testArrayList() {
		ArrayList<String> collection1 = new ArrayList<>();
		collection1.add("Toronto");
		collection1.add("London");
		collection1.add("Scarborough");
		collection1.add("Kingston");
		// print collection
		System.out.println(collection1);
		// clone 
		ArrayList<String> collection2 = (ArrayList<String>) collection1.clone();

//		// check item existence
//		String item = "Scarborough";
//		if (collection1.contains(item)) {
//			System.out.println("Yes, it contains " + item);
//		} else {
//			System.out.println("No, it does not contain " + item);
//		}
		
		// remove an item
		Scanner reader = new Scanner(System.in);
		System.out.print("Which city do you want to remove? ");
		String itemToRemove = reader.next();
		collection1.remove(itemToRemove);
		System.out.println("After remove " + itemToRemove + "\n" + collection1);

//		// iterator
//		Iterator<String> it = collection1.iterator();
//		while (it.hasNext()){
//			System.out.print(it.next().toUpperCase() + " ");
//		}
		// compare collection1 and its original copy
		//System.out.println("\ncommon Cities" + collection1.retainAll(collection2));
		System.out.println(collection1);
		collection1.retainAll(collection2);
		System.out.println(collection2);
	}

}
