package Practico_5;

public class MainComedor {

	public static void main(String[] args) {
		
		int cantPerros=10;
		int cantGatos=5;
		int limite=4;
		int cantComedor=2;
		
		Comedor unComedor=new Comedor(limite,cantComedor);
		
		for(int i=0;i<cantPerros;i++) {
			Perro unPerro=new Perro(unComedor);
			Thread hiloPerro=new Thread(unPerro,"Perro"+i);
			hiloPerro.start();
		}

		for(int i=0;i<cantGatos;i++) {
			Gato unGato=new Gato(unComedor);
			Thread hiloGato=new Thread(unGato,"Gato"+i);
			hiloGato.start();
		}
		
	}
}
