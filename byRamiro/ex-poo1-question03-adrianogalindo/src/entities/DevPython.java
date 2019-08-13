package entities;

public class DevPython implements Developpeur{
	private Developpeur dev;
	private String competence;
	
	
	public DevPython(Developpeur dev) {
		this.dev=dev;
		this.competence = "Python";
	}

	public String getNom() {
		return dev.getNom();
	}
	
	public String getCompetence() {
		return this.competence + ", "+ dev.getCompetence();
	}
}
