package entities;

public class DevJava implements Developpeur {
	
	private Developpeur dev;
	private String competence;
	
	
	public DevJava(Developpeur dev) {
		this.dev=dev;
		this.competence = "Java";
	}

	public String getNom() {
		return dev.getNom();
	}
	
	public String getCompetence() {
		return this.competence + ", "+ dev.getCompetence();
	}

}
