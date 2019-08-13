package liskov;

public class Carre extends Rectangle {
	
	public Carre(){
		super();
	}
	
	public Carre(int c){
		super(c,c);
	}
	
	public void setCote(int c1, int c2) {
//		if (c1==c2) {this.setCote(c1, c2);}
		super.setCote(c1, c1);
	}

}
