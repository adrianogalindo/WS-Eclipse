package console;

public class TestLine {

	public static void main(String[] args) {
		
		System.out.println("Test de line avec n");
		System.out.println("Montréal\nQuébec"); //avec n
		System.out.println();
		System.out.println("Test de line avec r");
		System.out.println("Montréal\rQuébec");	//avec r
		System.out.println();
		System.out.println("Test de line avec r et n");
		System.out.println("Montréal\r\nQuébec");	//avec les 2
		System.out.println();
		System.out.println("Test de line avec n et r");
		System.out.println("Montréal\n\rQuébec");	//avec les 2
		System.out.println();
		System.out.println("Test de line avec n et n");
		System.out.println("Montréal\n\nQuébec");	//avec les 2 n
	}

}
