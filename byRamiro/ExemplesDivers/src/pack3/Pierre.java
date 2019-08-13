package pack3;

public class Pierre {
	
	public static class MaitreJP {
		private MaitreJP() {
		}
	}
	
	private String nom;
	private Chien  JP=new Chien();
	public Pierre() {
		nom="Pierre";
	}
	
	public void commanderJP(){
		System.out.println("Je commande JP");
		JP.obeir(new MaitreJP());
		
	}
	
	

}
