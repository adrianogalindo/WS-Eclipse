package tpDB1;

import java.util.ArrayList;

public class Requetes {
	private ServiceBD myServiceBD;	
	
	public Requetes(){
		myServiceBD = new ServiceBD();		
	}
	
	public void close(){
		myServiceBD.close();
	}
	
	public ArrayList< ArrayList<Object>> queryTousLesEtudiantsAvecMoyenne(){
		
		String sql = "SELECT e.nom, e.prenom, e.NumeroDossier, e.CodePermanent, AVG(ec.note) "
				+ "FROM etudiant AS e "
				+ "LEFT JOIN etudiant_cours AS ec " // *TOUS* les �tudiants, alors *LEFT* JOIN
				+ "ON e.NumeroDossier = ec.NumeroDossier "
				+ "GROUP BY e.NumeroDossier";
		
		return myServiceBD.executeQuery(sql);
	}
	
	public ArrayList< ArrayList<Object>> queryTousLesEtudiants(){
		
		String sql = "SELECT * FROM Etudiant";
		
		return myServiceBD.executeQuery(sql);
	}
	
	public ArrayList< ArrayList<Object>> queryTousLesCours(){
		
		String sql = "SELECT * FROM cours";
		
		return myServiceBD.executeQuery(sql);
	}
	
	public ArrayList< ArrayList<Object>> queryTousLesEtudiantsDunCours(int Id_cours){
		
		String sql = "SELECT e.nom, e.prenom, e.NumeroDossier, e.CodePermanent, ec.note" 
				+ " FROM Etudiant AS e"
				+ " INNER JOIN etudiant_cours AS ec"
				+ " ON e.NumeroDossier = ec.NumeroDossier"
				+ " where ec.Id_Cours=" + Id_cours;
		
		return myServiceBD.executeQuery(sql);
	}
	
	public ArrayList< ArrayList<Object>> queryTousLesCoursDunEtudiant(int numeroDossier){
		
		String sql = "SELECT c.Id_Cours, c.Titre" 
				+ " FROM cours AS c"
				+ " INNER JOIN etudiant_cours AS ec"
				+ " ON c.Id_cours = ec.Id_cours"
				+ " where ec.NumeroDossier=" + numeroDossier;
		
		return myServiceBD.executeQuery(sql);
	}
	
	public ArrayList< ArrayList<Object>> queryMoyenneDunCours(int Id_cours){
		
		String sql = "SELECT AVG(ec.note)" 
				+ " FROM etudiant_cours ec"
				+ " where ec.Id_Cours=" + Id_cours;
		
		return myServiceBD.executeQuery(sql);
	}
	
	public ArrayList< ArrayList<Object>> queryToutesLesNotesDunCours(int Id_cours){
		
		String sql = "SELECT ec.note" 
				+ " FROM etudiant_cours ec"
				+ " where ec.Id_Cours=" + Id_cours 
				+ " AND ec.note IS NOT NULL";
		
		return myServiceBD.executeQuery(sql);
	}
	
	public ArrayList< ArrayList<Object>> queryTousLesCoursPourInscrireUnEtudiant(int numeroDossier){
		String sql = "SELECT Id_Cours, Titre FROM cours "
				+ " WHERE Id_Cours NOT IN "
				+ " (SELECT c.Id_Cours FROM cours as c"
				+ " LEFT JOIN etudiant_cours as ec"
				+ " ON c.Id_Cours = ec.Id_Cours"
				+ " WHERE ec.NumeroDossier ="
				+ numeroDossier
				+ ")";
		
		
		//		String sql = "SELECT * FROM cours";
		
		return myServiceBD.executeQuery(sql);
	}
	
	public int insertUnEtudiant(Logic.Etudiant e){
		String sql = "insert into Etudiant(codePermanent,prenom,nom) values(" 
					+ e.codePermanent 
					+ ",'"
					+ e.prenom
					+ "','" 
					+ e.nom
					+ " ')";
				
		return myServiceBD.executeUpdate(sql);
	}
	
	public int deleteUnEtudiant(int numeroDossier){
		String sql = "DELETE FROM Etudiant WHERE (Etudiant.numeroDossier=" 
					+ numeroDossier 
					+ ")";
		
		return myServiceBD.executeUpdate(sql);
	}
	
	public int insertInscriptionDunEtudiantAUnCours(int numeroDossier, int Id_cours){
		String sql = "INSERT INTO etudiant_cours(Id_Cours,NumeroDossier) values("  
					+ Id_cours 
					+ ","
					+ numeroDossier 
					+ " )";
				
		return myServiceBD.executeUpdate(sql);
	}
	
	public int deleteInscriptionDunEtudiantAUnCours(int numeroDossier, int Id_cours){
		String sql = "DELETE FROM etudiant_cours WHERE (etudiant_cours.numeroDossier="
					+ numeroDossier
					+ " AND " 
					+ "etudiant_cours.Id_cours=" 
					+ Id_cours
					+ ")";
				
		return myServiceBD.executeUpdate(sql);
	}
	
	public int updateNotesDunEtudiantDansUnCours(int numeroDossier, int Id_cours, double note){
		String sql = "UPDATE etudiant_cours SET etudiant_cours.note="
					+ note
					+ "  WHERE  (etudiant_cours.numeroDossier="
					+ numeroDossier
					+ " AND "
					+ "etudiant_cours.Id_cours="
					+ Id_cours
					+ ")" ;
				
		return myServiceBD.executeUpdate(sql);
	}
	
	

}
