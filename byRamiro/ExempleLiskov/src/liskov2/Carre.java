package liskov2;

import java.util.*;

public class Carre implements Polygone {
	
	private int c;
	
	public Carre(){
		this.c=0;
	}
	
	public Carre(int c){
		setCote(c);	
	}
	
	public void setCote(int c) {
		if (c>=0) {this.c=c;}
		
	}
	
	public int getCote() {
		return this.c;
	}
	
	
	public int perimetre() {
		return 4*this.c;
	}
	public int surface() {
		return this.c*this.c;
	}
	
	public List<Integer> listCotes(){
		ArrayList<Integer> l =new ArrayList<Integer>();
		l.add(c);
		return l;	
	}
	
}
