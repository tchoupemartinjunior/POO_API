import java.util.ArrayList;
import java.util.List;

public class Zoo {

	private int visiteurs = 0;
	private List<Secteur> secteursAnimaux = new ArrayList<Secteur>();
	
	private final int LIMITE_VISITEUR_PAR_SECTEUR = 3;
	
	public void ajouterSecteur(TypeAnimal type){
		secteursAnimaux.add(new Secteur(type));
	}
	
	public void nouveauVisiteur() throws LimiteVisiteurException{
		if (visiteurs + 1 == getLimiteVisiteur()){
			throw new LimiteVisiteurException();
		}
		visiteurs++;
	}
	
	public int getLimiteVisiteur(){
		return LIMITE_VISITEUR_PAR_SECTEUR * secteursAnimaux.size();
	}
	
	public Secteur getSecteurFromType(TypeAnimal typeAnimal){
		return secteursAnimaux.stream().filter(s -> s.obtenirType() == typeAnimal).findFirst().orElse(null);
	}
	
	public void nouvelAnimal(Secteur secteur, Animal animal){
		try {
			secteur.ajouterAnimal(animal);
		} catch (AnimalDansMauvaisSecteurException e) {
			e.printStackTrace();
		}
	}
	
	public int nombreAnimaux(){
		int nombreAnimaux = 0;
		for (Secteur secteur : secteursAnimaux){
			nombreAnimaux = secteur.getNombreAnimaux();
		}
		return nombreAnimaux;
	}
}
