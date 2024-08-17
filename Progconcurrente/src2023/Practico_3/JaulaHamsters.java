package Practico_3;

public class JaulaHamsters {

	public static void main(String[] args) {
		
		Plato plato=new Plato();
		Rueda rueda=new Rueda();
		Hamaca hamaca=new Hamaca();
		
		int cantHilos=5;
		
		for (int i=0;i<cantHilos;i++) {
			Hamster unHamster=new Hamster(plato, rueda, hamaca);
			Thread hilo=new Thread(unHamster,"Hamster "+i);
			hilo.start();
		}
		
	}
}
