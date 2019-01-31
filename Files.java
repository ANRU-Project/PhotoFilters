package pl.rucinski.antoni.wdprir.pics;

import java.io.File;

public class Files {

	public  String[] array;
	private String ppath;
	
	public Files(String path) {
		// TODO Auto-generated constructor stub
		this.ppath = path;
		getPhotos();
	}
	
	public void getPhotos(){
		
	
	
	//String path = "/home/anru/Pictures/NIKON/";
		File folder = new File(ppath);
		File[] listOfFiles = folder.listFiles();
		//int size = listOfFiles.length;
		array = new String [listOfFiles.length];
		int i = 0;
		for (File file : listOfFiles) {
			if (file.isFile()) {
				//System.out.println(ppath+file.getName());
				//System.out.println("newPic" +"_"+(String) file.getName());
				array[i] = ppath+file.getName();
				//System.out.println(array[i]);
				i++;
			}
		}
	}

}
