package Practico_5;

public class MainAvion {

	public static void main(String[] args) {
		
		int limite=10;
		Pista pista=new Pista(limite);
		
//		TorreControl torre=new TorreControl(pista);
//		Thread hiloTorre=new Thread(torre,"TorreControl");
//		hiloTorre.start();
		
		int cantAviones=15;
		
		for (int i=0;i<cantAviones;i++) {
			Avion unAvion=new Avion(pista);
			Thread hiloAvion=new Thread(unAvion,"Avion"+i);
			hiloAvion.start();
		}
	}
}
