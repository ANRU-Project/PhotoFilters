package pl.rucinski.antoni.wdprir.pics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Picture {
	BufferedImage img;
	public int width;
	public int height;
	public int[][] target;
	public Picture(String path) {
		loadImage(path);
	}

	
	/**
	 * loading image from file
	 * getting weight and height of the picture
	 * @param path
	 * @return
	 */
	public BufferedImage loadImage(String path) {
		//BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(path));
		    img.getScaledInstance(10, 10, Image.SCALE_FAST);
		    width = img.getWidth(); // get width of the picture
		    height = img.getHeight(); // get height if the picture
		    System.out.println("Reading picture complete.");
		} catch (IOException e) {
			System.out.println("Error: "+e);
		}
		
		return img;
	}
	
	/**
	 * resizing picture
	 * @param newWidth
	 * @param newHeight
	 */
	public void resizeImage(int newWidth, int newHeight) {
		img.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
	}
	
	/**
	 * saving image to file
	 * @param path
	 */
	public void savePicture(String path) {
		try{
			File f = new File(path);
			ImageIO.write(img, "jpg", f);
			System.out.println("Savig picture complete.");
		}catch(IOException e){
	      System.out.println("Error: "+e);
	    }
		
	}

}
