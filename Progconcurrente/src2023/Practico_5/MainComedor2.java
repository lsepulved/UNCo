package Practico_5;

public class MainComedor2 {
	
	public static void main(String[] args) {
		
		int cantPerros=10;
		int cantGatos=5;
		int limite=4;
		int cantComedor=2;
		
		Comedor2 unComedor=new Comedor2(limite,cantComedor);
		
		for(int i=0;i<cantPerros;i++) {
			Perro2 unPerro=new Perro2(unComedor);
			Thread hiloPerro=new Thread(unPerro,"Perro"+i);
			hiloPerro.start();
		}

		for(int i=0;i<cantGatos;i++) {
			Gato2 unGato=new Gato2(unComedor);
			Thread hiloGato=new Thread(unGato,"Gato"+i);
			hiloGato.start();
		}
		
	}

}
