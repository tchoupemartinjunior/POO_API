public class AnimalDansMauvaisSecteurException extends Exception {

	private static final long serialVersionUID = -6359543674897857575L;

	@Override
	public String getMessage() {
		return "L'animal est dans le mauvais secteur";
	}
}
