package multi_threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @since 12/10/2020
 * No need to put wait/notify/notifyAll. BQ will take care of blocking the operation.
 *
 */

public class ProducerConsumerUsingBQ {

    public static void main(String args[]){
  
     BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();//IMP
 
     Thread prodThread = new Thread(new ProducerBQ(sharedQueue));
     Thread consThread = new Thread(new ConsumerBQ(sharedQueue));

     prodThread.start();
     consThread.start();
    }
 
}

class ProducerBQ implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;

    public ProducerBQ(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

class ConsumerBQ implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;

    public ConsumerBQ(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
  
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
  
  
}