package Practico5;

public class MainComedero {

	public static void main (String []args) {
		
		int capacidad=2;
		int limite=3;
		int cantPerros=5;
		int cantGatos=5;
		
		Comedero comedero=new Comedero(capacidad,cantPerros,cantGatos,limite);
		Thread[]gatos = new Thread[cantGatos]; 
		Thread[]perros = new Thread[cantPerros];
		
		
		for (int i=0;i<cantGatos;i++) {
			Gato gato=new Gato(comedero,"Gatos");
			gatos[i]=new Thread(gato,"Gato "+i);
			gatos[i].start();
		}
		
		for (int i=0;i<cantPerros;i++) {
			Perro perro=new Perro(comedero,"Perros");
			perros[i]=new Thread(perro,"Perro "+i);
			perros[i].start();
		}
		
		
	}
	
	
}
