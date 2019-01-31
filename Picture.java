package pl.rucinski.antoni.wdprir.pics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// http://blog.ivank.net/fastest-gaussian-blur.html
public class Picture {
	BufferedImage img;
	public int width;
	public int height;
	public int[][] target;
	public Picture(String path) {
		// TODO Auto-generated constructor stub
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
		    
		    width = img.getWidth(); // get width of the picture
		    height = img.getHeight(); // get height if the picture
		    System.out.println("Reading picture complete.");
		} catch (IOException e) {
			System.out.println("Error: "+e);
		}
		
		return img;
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
