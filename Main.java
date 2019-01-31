package pl.rucinski.antoni.wdprir.pics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	


	public static void main(String[] args) throws InterruptedException {
		
		//Filters filters = new Filters();
		Files files = new Files("/home/anru/Pictures/testing/");
		Lockers lockers = new Lockers(files.array.length);
		Filters filters = new Filters();
		
		lockers.resetLocker();
		
		int numberOfProcessors = Runtime.getRuntime().availableProcessors(); 
		
		
		ExecutorService executor = Executors.newFixedThreadPool(numberOfProcessors);
		
		long time_start = System.nanoTime();
		new Threads(files.array, filters, executor, lockers.array); 
		

		executor.shutdown();
		long time_end = System.nanoTime();
		long time = time_end - time_start;
		System.out.println(time);
		
		

			
		
		
		/**
		String path = "/home/anru/Pictures/NIKON/";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		
		
		for (File file : listOfFiles) {
			if (file.isFile()) {
				
				System.out.println(path+file.getName());
				Picture pic = new Picture(path + (String) file.getName());
				pic.resizeImage(pic.width/500, pic.height/500);
				
				filters.sepiaFilter(pic);
				pic.savePicture("newPic" +"_"+(String) file.getName());
				
				System.out.println("newPic" +"_"+(String) file.getName());
				pic = null;
			}
		}
		**/

	}

	


}
