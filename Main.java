package pl.rucinski.antoni.wdprir.pics;

import java.io.File;

public class Main {

	


	public static void main(String[] args) {
		
		
		

		String path = "...";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				System.out.println(path+file.getName());
				Picture pic = new Picture(path + (String) file.getName());
				Filters filters = new Filters();

				filters.sepiaFilter(pic);
				pic.savePicture("newPic" +"_"+(String) file.getName());
				
				System.out.println("newPic" +"_"+(String) file.getName());
			}
		}

	}

	


}
