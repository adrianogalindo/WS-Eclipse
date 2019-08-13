package entities;

public class PersonneDesiree {
		
		private String sexe; 
		private int minAge;
		private int maxAge;
		private String paysOrigine;
		private String couleurCheveu;
		private String couleurYeux;
		private String education;
		
		public PersonneDesiree() {
		}
		
		public PersonneDesiree(String sexe, int minAge, int maxAge, String paysOrigine, String couleurCheveu, String couleurYeux,
				String education) {
			super();
			this.sexe = sexe;
			this.minAge = minAge;
			this.maxAge = maxAge;
			this.paysOrigine = paysOrigine;
			this.couleurCheveu = couleurCheveu;
			this.couleurYeux = couleurYeux;
			this.education = education;
		}
		
		
	    public String getSexe() {return sexe;}
		public int getMinAge() {return minAge;}
		public int getMaxAge() {return maxAge;}
		public String getPaysOrigine() {return paysOrigine;}
		public String getCouleurCheveu() {return couleurCheveu;}
		public String getCouleurYeux() {return couleurYeux;}
		public String getEducation() {return education;}

		public void setSexe(String sexe) {this.sexe = sexe;}
		public void setMinAge(int minAge) {this.minAge = minAge;}
		public void setMaxAge(int maxAge) {this.maxAge = maxAge;}
		public void setPaysOrigine(String paysOrigine) {this.paysOrigine = paysOrigine;}
		public void setCouleurCheveu(String couleurCheveu) {this.couleurCheveu = couleurCheveu;}
		public void setCouleurYeux(String couleurYeux) {this.couleurYeux = couleurYeux;}
		public void setEducation(String education) {this.education = education;}
	
}
