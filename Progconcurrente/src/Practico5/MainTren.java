package Practico5;

public class MainTren {

		public static void main (String []args) {
			
			int cantAsientos=5;
			int cantPasajeros=5;
			
			Tren tren=new Tren(cantAsientos);
			
			VendedorTickets vendedor=new VendedorTickets(tren);
			Thread hiloVendedor=new Thread(vendedor,"Vendedor");

			ControlTren control=new ControlTren(tren);
			Thread hiloControl=new Thread(control,"Control");
			
			
			Thread[]pasajeros = new Thread[cantPasajeros]; 
			
			hiloVendedor.start();
			hiloControl.start();
			
			for (int i=0;i<cantPasajeros;i++) {
				Pasajero pasajero=new Pasajero(tren);
				pasajeros[i]=new Thread(pasajero,"Pasajero "+i);
				pasajeros[i].start();
			}
			
			
			
		}

}
