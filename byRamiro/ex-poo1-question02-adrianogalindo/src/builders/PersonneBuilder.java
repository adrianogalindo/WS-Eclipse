package builders;

import entities.PersonneDesiree;

public class PersonneBuilder {
		
		private PersonneDesiree personneDesiree;


		public PersonneBuilder(){
		}
		
		public static PersonneBuilder creerPersonneDesiree(String sexe_){
			PersonneBuilder builder = new PersonneBuilder();
			builder.personneDesiree = new PersonneDesiree();
			builder.personneDesiree.setSexe(sexe_);
			builder.personneDesiree.setMinAge(18);
			builder.personneDesiree.setMaxAge(110);
			builder.personneDesiree.setPaysOrigine("");
			builder.personneDesiree.setCouleurCheveu("");
			builder.personneDesiree.setCouleurYeux("");
			builder.personneDesiree.setEducation("");
			return builder;
		}    	
		
		public PersonneBuilder setMinAge(int minAge_){
			personneDesiree.setMinAge(minAge_);
			return this;
		}    	
		public PersonneBuilder setMaxAge(int maxAge_){
			personneDesiree.setMaxAge(maxAge_);
			return this;
		}
		public PersonneBuilder setPaysOrigine(String paysOrigine_){
			personneDesiree.setPaysOrigine(paysOrigine_);
			return this;
		}
		public PersonneBuilder setCouleurCheveu(String couleurCheveu_){
			personneDesiree.setCouleurCheveu(couleurCheveu_);
			return this;
		}
		public PersonneBuilder setCouleurYeux(String couleurYeux_){
			personneDesiree.setCouleurYeux(couleurYeux_);
			return this;
		}
		public PersonneBuilder setEducation(String education_){
			personneDesiree.setEducation(education_);
			return this;
		}
		
		public PersonneDesiree maintenant() {
			return personneDesiree;
		}
		
		// exemple de construction PersonneDesirer neuvellePersonne = PersonneBuilder.creerPersonneBuilder(sexe_).setMinAge(25).setMaxAge(40).maintenant();

}
