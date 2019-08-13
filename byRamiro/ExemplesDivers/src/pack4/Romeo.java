package pack4;

public class Romeo {
	
	public static class Amour {
		private Amour() {
		}
	}
	
	private String nom;
	private Juliette  Ju=new Juliette();
	public Romeo() {
		nom="Romeo";
	}
	
	public void declarerAmour(){
		System.out.println("Je t'aime, Juliette");
		Ju.declarerAmour(new Amour());
		
	}
	
	

}
