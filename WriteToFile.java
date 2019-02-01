package pl.rucinski.antoni.wdprir.pics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteToFile {
	
	public String filePath;
	public WriteToFile( String filePath){
		this.filePath = filePath;
		
	}

	public void writeToFile(long size, long time) throws IOException {
		
		
		File file = new File(filePath);
		
		if(file.exists() == false) {
			FileWriter fr = new FileWriter(file, true);
			
			BufferedWriter br = new BufferedWriter(fr);
			br.write("size" + "\t"+"avgTime"+"\n");
			br.close();
			fr.close();
		}
		FileWriter fr = new FileWriter(file, true);
		BufferedWriter br = new BufferedWriter(fr);
		
		br.write(Long.toString(size)+ "\t" + Long.toString(time) + "\n");
		
		br.close();
		fr.close();
	
	}

}
