package Practico_5;

public class MainPiscina {

	public static void main(String[] args) {
		
		int cantLugares=10;
		Piscina piscina=new Piscina(cantLugares);
		
		int cantPersonas=20;
		
		for (int i=0;i<cantPersonas;i++) {
			Persona unaPersona=new Persona(piscina);
			Thread hiloPersona=new Thread(unaPersona,"Persona "+i);
			hiloPersona.start();
		}
	}
}
