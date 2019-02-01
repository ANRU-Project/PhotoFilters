package pl.rucinski.antoni.wdprir.pics;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	


	public static void main(String[] args) throws InterruptedException, IOException {
		
		Filters filters = new Filters();
		
		// multithread processing
		
		WriteToFile writer = new WriteToFile("results.tsv");
		
		int repeats = 100;
		
		for (int s = 20; s<=100; s += 20) {
			
			Files files = new Files("/home/anru/eclipse-workspace/Pictures/pics/size" +  s + "/", "/home/anru/eclipse-workspace/Pictures/modified/size"+ s + "/");
			Lockers lockers = new Lockers(files.array.length);
			
			long time_start = System.nanoTime();
			
			for (int r = 0; r < 100; r ++) {
				lockers.resetLocker();
				int numberOfProcessors = Runtime.getRuntime().availableProcessors(); 

				ExecutorService executor = Executors.newFixedThreadPool(numberOfProcessors);
		
				
				new Threads(files, filters, executor, lockers.array); 
		

				executor.shutdown();
			}
			
			long time_end = System.nanoTime();
			long time = (time_end - time_start)/repeats;
			
			//System.out.println(time);
			//System.out.println(files.size);
			writer.writeToFile(files.size, time);
	
		}
		

			
		// sequential proessing
		/**
		WriteToFile writer = new WriteToFile("results_seq.tsv");
		int repeats = 100;
		
		for (int s = 20; s<=100; s += 20) {
			
			Files files = new Files("/home/anru/eclipse-workspace/Pictures/pics/size" +  s + "/", "/home/anru/eclipse-workspace/Pictures/modified/size"+ s + "/");
		
			
			long time_start = System.nanoTime();
			
			for (int r = 0; r < 100; r ++) {
				for (int i = 0; i < files.array.length; i++) {
					Picture pic = new Picture(files.array[i]);
					filters.sepiaFilter(pic);
			
					pic.savePicture(files.targetPath + "sepia_"+(files.array[i].substring(files.array[i].lastIndexOf("/") + 1))); 
					pic = null;
				}
			}
			
			long time_end = System.nanoTime();
			long time = (time_end - time_start)/repeats;
			
			writer.writeToFile(files.size, time);
		}
		**/


	}

	


}
