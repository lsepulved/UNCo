package Practico5;

public class MainComedero2 {

	public static void main (String []args) {
		
		int capacidad=2;
		int cantPerros=5;
		int cantGatos=5;
		
		Comedero2 comedero=new Comedero2(capacidad);
		Thread[]gatos = new Thread[cantGatos]; 
		Thread[]perros = new Thread[cantPerros];
		
		
		for (int i=0;i<cantGatos;i++) {
			Gato2 gato=new Gato2(comedero,"Gatos");
			gatos[i]=new Thread(gato,"Gato "+i);
			gatos[i].start();
		}
		
		for (int i=0;i<cantPerros;i++) {
			Perro2 perro=new Perro2(comedero,"Perros");
			perros[i]=new Thread(perro,"Perro "+i);
			perros[i].start();
		}
		
		
	}
	
	
}
