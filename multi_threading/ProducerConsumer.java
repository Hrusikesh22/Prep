package multi_threading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
	public static void main(String[] s) {
		/*
		 * 1- Common link between P n C.
		 * 2- Also both P n C will have lock on this Q and will call wait()/notifyAll() 
		 * 3- Queues are unbounded. so take QUEUE_CAPACITY to check in Producer for q.isFull() 
		 */
		Queue<Integer> q = new LinkedList<>();//IMP
		
		new Thread(new Producer(q)).start();
		new Thread(new Consumer(q)).start();
	}
}

class Producer implements Runnable {

	private Queue<Integer> q;
	private final int QUEUE_CAPACITY = 5; //IMP
	
	Producer(Queue<Integer> q){
		this.q = q;
	}
	
	@Override
	public void run() {
		int i = 1;
		while(i<=10) {
			try {
				produce(i++);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
	
	public void produce(int i) throws InterruptedException {
		
		synchronized (q) {
			
			if(q.size() == QUEUE_CAPACITY) {
				System.out.println("Q is full, Producer waiting...");
				q.wait();
			}
			
			q.offer(i);
			
			System.out.println("Producer added " + i +", Q : " + q);
			System.out.println("Producer Notified all...");
			
			q.notifyAll();
		}
	}
}

class Consumer implements Runnable {
	
	private Queue<Integer> q;
	
	Consumer(Queue<Integer> q) {
		this.q = q;
	}

	@Override
	public void run() {
		while(true) {
			try {
				consume();
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
	
	public void consume() throws InterruptedException {
		
		synchronized (q) {
			
			if(q.isEmpty()) {
				System.out.println("Q is Empty, Consumer waiting");
				q.wait();
			}
			
			int top = q.poll();

			System.out.println("Consumer removed " + top + ", Q : " + q);
			System.out.println("Consumer Notified all...");
			
			q.notifyAll();
		}
	}
	
}

