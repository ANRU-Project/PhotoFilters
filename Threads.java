package pl.rucinski.antoni.wdprir.pics;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;


public class Threads {


	
	public Threads(Files files, Filters filters, ExecutorService executor, AtomicInteger[] lock_array) throws InterruptedException {
			
			int numberOfProcessors = Runtime.getRuntime().availableProcessors(); // number of processors 
			Runnable[] threads = new Runnable[numberOfProcessors]; // array; size of array = # of processors
			CountDownLatch latch = new CountDownLatch(numberOfProcessors);  // create countdownlatch
						
			int num = 0;
			while (num!=lock_array.length) {
				
				
				for (int w = 0; w<threads.length; w++) {
					threads[w] = new Thread() {
						
						public void run() {
							
							
							for (int i = 0; i < lock_array.length; i++) {
								
								if (lock_array[i].compareAndSet(0, 1)==true) {
									
									Picture pic = new Picture(files.array[i]); // get picture
									
									filters.sepiaFilter(pic); // set filter on picture
									
									pic.savePicture(files.targetPath + "sepia_"+(files.array[i].substring(files.array[i].lastIndexOf("/") + 1)));  // save new picture
									pic = null;
									break;
								}
								
									
								}
							latch.countDown(); 
							
						}
					};
				}
				
			
			// start threads
			for (int i=0; i<numberOfProcessors; i++) {
				executor.execute(threads[i]); // start thread i
			}
		
			latch.await(); // wait for all threads
			num++;
		}
	}

}
