package liskov2;

import java.util.List;

public class PolygoneColore implements Polygone  {
	
	private Polygone p ; 
	private String couleur ;
	
	public PolygoneColore(Polygone p) {
		this.p=p;
		couleur="DEFAULT";
		
	}
	
	public List<Integer> listCotes(){
		return p.listCotes();
	}
	
	public  int perimetre() {
		return p.perimetre();
	}
	public  int surface() {
		return p.surface();
	}
	
	public void setColor(String c) {
		if ((c=="RED")|| (c=="BLUE")||(c=="GREEN")) {
		this.couleur=c;
		}
	}
	
	public String getColor() {
		return this.couleur;
	}

}
