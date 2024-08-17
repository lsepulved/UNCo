package Practico_6;

public class MainProduConsu {

	public static void main(String []args) {
		
		int capacidad=5;
		Almacen almacen=new Almacen(capacidad);
		
		int cantProductores=15;
		int cantConsumidores=25;
		
		for (int i=0;i<cantProductores;i++) {
			Productor unProductor=new Productor(almacen);
			Thread hiloProductor=new Thread(unProductor,"Productor"+i);
			hiloProductor.start();
		}
		
		for (int i=0;i<cantConsumidores;i++) {
			Consumidor unConsumidor=new Consumidor(almacen);
			Thread hiloConsumidor=new Thread(unConsumidor,"Consumidor"+i);
			hiloConsumidor.start();
		}
		
	}
}
