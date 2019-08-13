package entities;

public class DevWeb implements Developpeur{
	private Developpeur dev;
	private String competence;
	
	
	public DevWeb(Developpeur dev) {
		this.dev=dev;
		this.competence = "Web";
	}

	public String getNom() {
		return dev.getNom();
	}
	
	public String getCompetence() {
		return this.competence + ", "+ dev.getCompetence();
	}
}
