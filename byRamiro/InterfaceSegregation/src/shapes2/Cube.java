package shapes2;

import java.util.ArrayList;
import java.util.List;

public class Cube implements I3DShape{
	int s ;
	 
	
	public Cube(){
		this.s =0;
	}
	
	public Cube(int s){
		if (s>=0){this.s = s;}
		else {this.s = 0;}
		
	}
	
	public void setSide(int s  ){
		if (s>=0){this.s = s;}
		else {this.s = 0;}
	}
	
	public int getSide(){
		return s;
	}
	
	@Override
	public int area(){
		return 6*s*s;
	}
	
	@Override
	public int volume(){
		return s*s*s;
	}
	
	public List<Integer> listEdges(){
		List<Integer> l = new ArrayList<Integer>();
		l.add(this.s);
		return l;
	}
	
}

