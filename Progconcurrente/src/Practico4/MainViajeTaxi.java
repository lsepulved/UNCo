package Practico4;

public class MainViajeTaxi {

	public static void main (String[] args) {
		
		int cantPasajeros=5;
		Taxi taxi=new Taxi();
		
		Thread[] pasajeros=new Thread[cantPasajeros];
		
		Taxista taxista=new Taxista(taxi);
		Thread hiloTaxista=new Thread(taxista,"Taxista");
		
		for (int i=0;i<cantPasajeros;i++) {
			Pasajero pasajero=new Pasajero(taxi);
			pasajeros[i]=new Thread(pasajero,"Pasajero"+i);
			pasajeros[i].start();
		}
		
		hiloTaxista.start();
	}
}
