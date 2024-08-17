package EjemploTeoria;

public class TestRunThread {

	public static void main (String[] args) {

		HiloAlfaBeta alfa = new HiloAlfaBeta("Hilo Alfa ");
		HiloAlfaBeta beta = new HiloAlfaBeta("Hilo Beta ");
		
		alfa.start();
		beta.start();
	}
}