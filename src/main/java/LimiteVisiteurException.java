public class LimiteVisiteurException extends Exception {

	private static final long serialVersionUID = -6359543674897857575L;

	@Override
	public String getMessage() {
		return "La limite de visiteur est atteinte";
	}
}
