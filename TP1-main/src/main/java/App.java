public class App {

	private static Zoo zoo;
	
	public static void main(String[] args) {
		zoo = new Zoo();
		System.out.println("Test");
	}
	
	public static Zoo getZoo() {
		return zoo;
	}
}
