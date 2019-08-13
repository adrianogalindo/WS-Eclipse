package shapes1;

import java.util.ArrayList;
import java.util.List;

public class ImmSquare extends ImmRectangle{
	
	public ImmSquare(){
		super();
	}
	
	public ImmSquare(int s){
		super(s,s);
	}
	
//	public void setSides(int sh , int sv){
//		if (sh==sv){
//			if (sh>=0){this.sh = sh;this.sv = sv;}
//			else {this.sh = 0;this.sv = 0;}	
//		}
//	}

	public List<Integer> listSides(){
		List<Integer> l = new ArrayList<Integer>();
		l.add(this.sh);
		return l;
	}
	
}
