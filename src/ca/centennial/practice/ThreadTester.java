package ca.centennial.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTester {


	public static void main(String[] args) {
		//startDemo1();
		
		startThreadPool();
	}

	private static void startThreadPool() {
		// create a fixed thread pool with maximum three threads
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		// submit runnable tasks to the executor
		executor.execute(new PrintChar('a', 100));
		executor.execute(new PrintChar('b', 100));
		executor.execute(new PrintNum(100));
		
		// shutdown the executor
		executor.shutdown();
	}
	
	private static void startDemo1() {
		// create tasks
		Runnable printA = new PrintChar('a', 100);
		Runnable printB = new PrintChar('b', 100);
		Runnable printC = new PrintNum(100);

		// create threads
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(printC);

		// start threads
		thread1.start();
		thread2.start();
		thread3.start();
	}

}

// task - print number
class PrintNum implements Runnable {
	private int times;
	public PrintNum(int i) {
		this.times = i;
	}

	@Override
	public void run() {
		for (int i = 0; i < times; i++){
			try {
				Thread.sleep(500);
				System.out.println(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
// tasks - print character
class PrintChar implements Runnable {
	private char charToPrint;
	private int times;

	public PrintChar(char c, int i) {
		this.charToPrint = c;
		this.times = i;
	}

	@Override
	public void run() {
		for (int i = 0; i < times; i++) {
			try {
				Thread.sleep(500);
				System.out.println(charToPrint);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
