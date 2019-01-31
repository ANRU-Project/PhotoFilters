package pl.rucinski.antoni.wdprir.pics;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;


public class Threads {


	
	public Threads(String[] array, Filters filters, ExecutorService executor, AtomicInteger[] lock_array) throws InterruptedException {
			
			int numberOfProcessors = Runtime.getRuntime().availableProcessors(); // liczba procesorów
			Runnable[] threads = new Runnable[numberOfProcessors]; // utworzenie tablicy watków o rozmiarze = liczbie procesorów
			CountDownLatch latch = new CountDownLatch(numberOfProcessors);  // tworzymy countdownlatcha dla watków równych liczbie procesorów
						
			int num = 0;
			while (num!=lock_array.length) {
				//System.out.println(lock_array.length);
				//System.out.println(num);
				
				for (int w = 0; w<threads.length; w++) {
					//System.out.println(w);
					
					threads[w] = new Thread() {
						
						public void run() {
							
							
							for (int i = 0; i < lock_array.length; i++) {
								//System.out.println(array[i]);
								//System.out.println(lock_array[i].get());
								if (lock_array[i].compareAndSet(0, 1)==true) {
									//System.out.print(array[i]);
									Picture pic = new Picture(array[i]);
									filters.sepiaFilter(pic);
								
									pic.savePicture("sepia_"+(array[i].substring(array[i].lastIndexOf("/") + 1))); 
									pic = null;
									break;
								}
								
									
								}
	
							//System.out.println("wątek zakończony");
							latch.countDown();  // odpala countdwonlatcha w momencie gdy zakonczymy wykonywać wątek
							
						}
					};
				}
				
			
			
			for (int i=0; i<numberOfProcessors; i++) {
				executor.execute(threads[i]); // startujemy watek		
			}
		
			latch.await(); // czekamy az wszystkie watki się wykonają
			num++;
		}
	}

}
