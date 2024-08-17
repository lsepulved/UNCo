package Practico_4;

public class MainTaxi {

	public static void main(String[] args) {
		
		Taxi taxi=new Taxi();
		
		int cantHilos=5;
		
		Taxista taxista=new Taxista(taxi);
		Thread hiloTaxista=new Thread(taxista,"Taxista");
		hiloTaxista.start();
		
		
		for (int i=0;i<cantHilos;i++) {
			ClienteTaxi unCliente=new ClienteTaxi(taxi);
			Thread hiloCliente=new Thread(unCliente, "Cliente "+i);
			hiloCliente.start();
		}
	}
}
