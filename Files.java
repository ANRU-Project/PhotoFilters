package pl.rucinski.antoni.wdprir.pics;

import java.io.File;

public class Files {

	public  String[] array;
	private String ppath;
	public String targetPath;
	public long size;
	
	public Files(String path, String tPath) {
		// TODO Auto-generated constructor stub
		this.ppath = path;
		this.targetPath = tPath;
		getPhotos();
	}
	
	/**
	 * get paths of the photos in the dir
	 */
	public void getPhotos(){
		File folder = new File(ppath);
		File[] listOfFiles = folder.listFiles();
		array = new String [listOfFiles.length];
		int i = 0;
		for (File file : listOfFiles) {
			if (file.isFile()) {
				size = file.length();
				array[i] = ppath+file.getName();
				i++;
			}
		}
	}

}
