package liskov2;

import java.util.*;

public class Rectangle implements Polygone {

	private int c1;
	private int c2;
	
	public Rectangle(){
		this.c1 = this.c2 = 0;
	}
	
	public Rectangle(int c1, int c2){
		setCote(c1,c2);
	}
	
	public void setCote(int c1, int c2) {
		if (c1>=0) {this.c1=c1;}
		if (c2>=0) {this.c2=c2;}	
	}
	
	public int getc1() {
		return this.c1;
	}
	
	public int getc2() {
		return this.c2;
	}
	
	public int perimetre() {
		return 2*this.c1 + 2*this.c2;
	}
	public int surface() {
		return this.c1*this.c2;
	}
	
	public List<Integer> listCotes(){
		ArrayList<Integer> l =new ArrayList<Integer>();
		l.add(c1);
		l.add(c2);
		return l;
		
	}

}

