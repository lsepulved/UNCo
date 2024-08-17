package Practico_5;

public class MainTren {

	public static void main (String[]args) {
		
		int cantPasajeros=15;
		int capacidad=5;
		Tren unTren=new Tren(capacidad);
		
		VendedorTickets unVendedor=new VendedorTickets(unTren);
		Thread hiloVendedor=new Thread(unVendedor,"Vendedor");
		hiloVendedor.start();
		
		
		ControlTren unControl=new ControlTren(unTren);
		Thread hiloControl=new Thread(unControl,"Control");
		hiloControl.start();
		
		for(int i=0;i<cantPasajeros;i++) {
			Pasajero unPasajero=new Pasajero(unTren);
			Thread hiloPasajero=new Thread(unPasajero,"Pasajero"+i);
			hiloPasajero.start();
		}
		
	}
}
