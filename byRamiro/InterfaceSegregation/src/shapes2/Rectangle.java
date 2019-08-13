package shapes2;

import java.util.*;

public class Rectangle implements I2DShape {
	int sh ;
	int sv; 
	
	public Rectangle(){
		this.sh = this.sv =0;
	}
	
	public Rectangle(int sh , int sv){
		setSides(sh, sv);
	}
	
	public void setSides(int sh , int sv){
		if (sh>=0){this.sh = sh;}
		else {this.sh = 0;}
		if (sv>=0){this.sv = sv;}
		else {this.sv = 0;}		
	}
	
	public int getHorizontalSide(){
		return sh;
	}
	public int getVerticalSide(){
		return sv;
	}
	
	@Override
	public int perimeter(){
		return 2*sh+2*sv;
	}
	
	@Override
	public int area(){
		return sh*sv;
	}
	
	
	public List<Integer> listSides(){
		List<Integer> l = new ArrayList<Integer>();
		l.add(this.sh);
		l.add(this.sv);
		return l;
	}
}
