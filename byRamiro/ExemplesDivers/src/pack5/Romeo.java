package pack5;

public class Romeo {
	
	public static class Amour {
		private Amour() {
		}
	}
	
	private String nom;
	private Juliette  Ju=Juliette.appelerJuliette();
	private Romeo() {
		nom="Romeo";
	}
	private static Romeo r= new Romeo();
	public static Romeo appelerRomeo() {
		return r;
	}
	
	public void declarerAmour(){
		System.out.println("Je t'aime, Juliette");
		Ju.declarerAmour(new Amour());
		
	}
	
	

}
