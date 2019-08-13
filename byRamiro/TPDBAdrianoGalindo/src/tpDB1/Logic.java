package tpDB1;

import java.util.ArrayList;
import java.util.Arrays;

public class Logic {
		
	
	public class Etudiant {
		int numeroDossier; 
		int codePermanent;
		String prenom;
		String nom;
	}
//	
//	public class Cours{
//		int Id_Cours;
//		String	Titre;
//	}
//	public class etudiant_cours{
//		int Id_Cours;
//		int NumeroDossier;
//		double note;
//	}

	
// Activer les couches Don�es et Interface Utilisateur
	Requetes myBD = new Requetes();
	UserInterface myUI = new UserInterface();
	
	public Logic(){		
	}
	
	public void execute() {		
		boolean boucle = true; 
		while(boucle){ 				
			boucle = sousMenu( myUI.menuPrincipal() );			
		}
		System.out.println("Au revoir");
		
		System.out.println("                                                       _____");
		System.out.println("                                                  _/` .-'` .");
		System.out.println("                                             _/`  .   _.'");
		System.out.println("                ....:::::::::::::.(_)   /` _.'__./");
		System.out.println("             .oooooooooo|  |/.--'_.'oooo.");
		System.out.println("         .ooooooooooo .|_|o |  `ooooooob.");
		System.out.println("     .ooooooooooooooooooooo&&oooooob.");
		System.out.println("  .oooooooooooooooooooo&@@@@@@oob.");
		System.out.println(" .ooooooooooooooooooooooo&&@@@@@oob");
		System.out.println("doooooooooooooooooooooooooo&@@@@oob");
		System.out.println("doooooooooooooooooooooooooo&@@@oooob");
		System.out.println("dooooooooooooooooooooooooo&@@@oooob");
		System.out.println("dooooooooooooooooooooooooo&@@ooooob'");
		System.out.println("`dooooooooooooooooooooooooo&@ooooob'");
		System.out.println("   `doooooooooooooooooooooooooooooob'");
		System.out.println("     `doooooooooooooooooooooooooooob'");
		System.out.println("       `doooooooooooooooooooooooooob'");
		System.out.println("          `doooooooooooooooooooooooob'");
		System.out.println("            `doooooooooooooooooooooob'");
		System.out.println("             `dooooooooobodoooooooob'");
		System.out.println("               `doooooooob dooooooob'");
		System.out.println("                 ````````````  ````````` ");
		
		myUI.close();
		myBD.close();
	}	
	
	
	private boolean sousMenu(int menuPrincipalChoix) {				
		switch (menuPrincipalChoix) {
		case 1: {				
        	// 1. La liste de tous les �tudiants
			myUI.listTousLesEtudiantsAvecMoyenne(myBD.queryTousLesEtudiantsAvecMoyenne());         
		} break;
		
		case 2: {			
			// 2. Affichage de la liste des �tudiants inscrits � un cours
			
			ArrayList<Object> selectedLine= myUI.choix(myBD.queryTousLesCours(), "Choisissez un cours");
			myUI.listTousLesEtudiantsAvecMoyenneDansUnCours(
					myBD.queryTousLesEtudiantsDunCours((int) selectedLine.get(0)),(String) selectedLine.get(1));
				          
        	
        	ArrayList<ArrayList<Object>> resultat = myBD.queryMoyenneDunCours((int)selectedLine.get(0));
        	if(resultat.get(0).get(0)!=null){
        		myUI.msg("Moyenne du groupe: "+ (double)resultat.get(0).get(0));
        	}
        	else {
        		myUI.msg("Pas de moyenne pour ce groupe");
        	}
        	        	
        	ArrayList<ArrayList<Object>> Liste = myBD.queryToutesLesNotesDunCours((int)selectedLine.get(0));
        	String median="";
        	if (Liste.size()>0){
        		double[] notes = new double[Liste.size()];

        		for (int j=0; j < notes.length ; j++) {
        			notes[j] = (double)Liste.get(j).get(0);
        		}
        		Arrays.sort(notes);        		
        		if (notes.length % 2 == 0)
        			median = ""+((double)notes[notes.length/2] + (double)notes[notes.length/2 - 1])/2;
        		else
        			median = ""+(double) notes[notes.length/2];        		
        	}
        	myUI.msg("Médiane du groupe: "+median);        
        	myUI.msg("\n---------------------------");	
            
		} break;
		
		case 3:{ 	
        	// 3. Ajout d'un nouvel �tudiant
			Etudiant unEtudiant= new Etudiant();
        	myUI.ajouterEtudiant(unEtudiant);
        	myBD.insertUnEtudiant(unEtudiant);    
        	
		} break;
		
		case 4:{ 
			// 4. Suppression d'un �tudiant
			myUI.msg("\n---------------------------\nSuppression d'un étudiant");
			try {
			ArrayList<Object> selectedLine= myUI.choix(myBD.queryTousLesEtudiants(),
					"Choisissez l'étudiant à supprimer:");
			myBD.deleteUnEtudiant(((int) selectedLine.get(0)));
			} catch (Exception e) {
				System.out.println();
				System.out.println("--------------------------------------------------------------------------------------");
				System.out.println("Mauvaise Selection: N'est pas possible de supprimer un étudiant inscrit dans un cours");
				System.out.println("--------------------------------------------------------------------------------------");
				System.out.println();
			}
		} break;	
			
			
		case 5:{
        	// 5. Inscription d'un �tudiant � un cours
			myUI.msg("\n---------------------------\nInscription d'un ,tudiant d'un cours");
			ArrayList<Object> selectedStudent= myUI.choix(myBD.queryTousLesEtudiants(),
					"Choisissez l'étudiant à inscrire:");
			ArrayList<Object> selectedCourse= myUI.choix(myBD.queryTousLesCoursPourInscrireUnEtudiant((int)selectedStudent.get(0)),
					"Choisissez le cours auquel inscrire l'étudiant:");
			myBD.insertInscriptionDunEtudiantAUnCours((int)selectedStudent.get(0),(int)selectedCourse.get(0));
			myUI.msg("---------------------------\n"
					+"étudiant "+ selectedStudent.get(2)+", "+selectedStudent.get(3)
					+ " inscrit au cours "+ selectedCourse.get(1)+"\n---------------------------"
					);			
			
		} break;
		
		case 6:{
        	// D�sinscription d'un �tudiant d'un cours
			myUI.msg("\n---------------------------\nDésinscription d'un étudiant d'un cours");
			try {
			ArrayList<Object> selectedStudent= myUI.choix(myBD.queryTousLesEtudiants(),
					"Choisissez l'étudiant à désinscrire:");
			ArrayList<Object> selectedCourse= myUI.choix(myBD.queryTousLesCoursDunEtudiant((int)selectedStudent.get(0)),
					"Choisissez le cours duquel désinscrire l'étudiant:");
			myBD.deleteInscriptionDunEtudiantAUnCours((int)selectedStudent.get(0),(int)selectedCourse.get(0));
			myUI.msg("---------------------------\n"
					+"étudiant "+ selectedStudent.get(2)+", "+selectedStudent.get(3)
					+ " désinscrit du cours "+ selectedCourse.get(1)+"\n---------------------------"
					);      
			} catch (Exception e) {
				System.out.println();
				System.out.println("-----------------------------------------------------------------");
				System.out.println("Mauvaise Selection: L'étudiant n'est pas inscrit dans aucun cours");
				System.out.println("-----------------------------------------------------------------");
				System.out.println();
			}
		} break;
		
		case 7:{
			//7. Modification de la note d'un �tudiant
			myUI.msg("\n---------------------------\nModification de la note d'un étudiant");
			try {
			ArrayList<Object> selectedStudent= myUI.choix(myBD.queryTousLesEtudiants(),
					"Choisissez l'étudiant auquel modifier la note:");
			ArrayList<Object> selectedCourse= myUI.choix(myBD.queryTousLesCoursDunEtudiant((int)selectedStudent.get(0)),
					"Choisissez le cours auquel changer la note de l'étudiant:");
			Double note= myUI.getNote();
			
			myBD.updateNotesDunEtudiantDansUnCours(
					(int)selectedStudent.get(0),
					(int)selectedCourse.get(0),
					note);
			myUI.msg("---------------------------\n"
					+"étudiant "+ selectedStudent.get(2)+", "+selectedStudent.get(3)
					+ "dans le cours "+ selectedCourse.get(1)
					+ " a reçu la note : "+note
					+"\n---------------------------"
					); 		
			} catch (Exception e){
				System.out.println();
				System.out.println("-----------------------------------------------------------------");
				System.out.println("Mauvaise Selection: L'étudiant n'est pas inscrit dans aucun cours");
				System.out.println("-----------------------------------------------------------------");
				System.out.println();
			}
	
		} break; 
		
		} // end switch
		if (menuPrincipalChoix==8){return false;} 
		else {
			String reponse =""; 
			while(!reponse.equals("1")){ 			
				System.out.println("Entrez 1 pour retourner au menu principal");
				System.out.println();
				reponse = myUI.sc.nextLine();    			
			}
			return true;
		} 
	}

	
	   public static void main(String[] args) {
	        new Logic().execute();
	        
	    }

	
	

}
