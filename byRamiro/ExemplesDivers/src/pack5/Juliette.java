package pack5;

public class Juliette {
	
	private String nom; 
	private Juliette() {
		nom="Juliette";
	}
	private static Juliette j= new Juliette();
	public static Juliette appelerJuliette() {
		return j;
	}
	public void parler() {
		System.out.println("Bonjour");		
	}
	public void declarerAmour(Romeo.Amour a) {
		System.out.println("Je t'aime, Romeo");	
	}

}
