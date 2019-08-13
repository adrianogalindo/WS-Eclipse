package liskov;

public class CarreImm extends RectangleImm {
	
	public CarreImm(){
		super();
//		this.setCote(0, 0);
	}
	
	public CarreImm(int c){
		super(c,c);
//		this.setCote(c, c);
	}

}
