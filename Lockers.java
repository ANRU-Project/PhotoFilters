package pl.rucinski.antoni.wdprir.pics;

import java.util.concurrent.atomic.AtomicInteger;

public class Lockers {

	public AtomicInteger [] array;
	
	public Lockers(int size){
		this.array = new AtomicInteger [size];
		
	}
	
	public void resetLocker(){
		for(int i = 0; i < array.length; i++)
		        array[i] = new AtomicInteger(0);
	}
	
	public boolean setLocker(int i) {
		boolean flag = true;
		if (array[i].compareAndSet(0, 1)) {}
		else {
			flag = false;
			return flag;
		}
		return flag;
		
	}
	
	public void removeLocer(int i) {
		array[i].compareAndSet(1, 0);
	}

}
