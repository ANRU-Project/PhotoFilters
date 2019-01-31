package pl.rucinski.antoni.wdprir.pics;

public class Filters {

	public Filters() {
		// TODO Auto-generated constructor stub
	}

	
	public int getPixel(Picture pic, int i, int j) {
		int pixel = pic.target[i][j];
		return pixel;
		
	}
	
	public int getA(int pixel) {
		return (pixel>>24) & 0xff;
	}
	public int getR(int pixel) {
		return (pixel>>16) & 0xff;
	}
	public int getG(int pixel) {
		return (pixel>>8) & 0xff;
	}
	public int getB(int pixel) {
		return pixel & 0xff;
	}
	public int setP(int a, int r, int g, int b) {
		return (a<<24) | (r<<16) | (g<<8) | b;
	}
	
	public int checkConditions(int tc, int c) {
		if(tc> 255){
			  c = 255;
			}else{
			  c = tc;
			}
		return c;
		
	}
	
	public void sepiaFilter(Picture pic) {
		System.out.println("Processing filter: sepia");
		for(int y = 0; y < pic.height; y++){
		      for(int x = 0; x < pic.width; x++){
		        int p = pic.img.getRGB(x,y);

		        int a = getA(p);//(p>>24)&0xff;
		        int r = getR(p);//(p>>16)&0xff;
		        int g = getG(p);//(p>>8)&0xff;
		        int b = getB(p);//p&0xff;

		        //calculate tr, tg, tb
		        int tr = (int)(0.393*r + 0.769*g + 0.189*b);
		        int tg = (int)(0.349*r + 0.686*g + 0.168*b);
		        int tb = (int)(0.272*r + 0.534*g + 0.131*b);

		        //check condition
		        r = checkConditions(tr, r);
		        g = checkConditions(tg,g);
		        b = checkConditions(tb,b);


		        //set new RGB value
		        p = setP(a, r, g, b);

		        pic.img.setRGB(x, y, p);
		      }
		    }
		System.out.println("Filter application completed successfully!");
	}
}
