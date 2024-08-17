package TPO2023;

public class MainTren {

	public static void main(String[] args) {

		
		int capacidad=5;
		
		Tren tren=new Tren(capacidad);
		
		ControlTren control=new ControlTren(tren);
		Thread hiloControl=new Thread(control, "Control");
		hiloControl.start();
	
		ExpendedoraTickets expendedora=new ExpendedoraTickets();
		
		int cantHilos=10;
		
		Thread []hilosPasajeros = new Thread[cantHilos] ;
		
		for(int i=0; i<cantHilos;i++) {
			Pasajero unPasajero=new Pasajero(tren,expendedora);
			hilosPasajeros[i]=new Thread(unPasajero,"Pasajero"+i);
			hilosPasajeros[i].start();			
		}

		
//		for(int i=0; i<cantHilos;i++) {
//			try {
//				hilosPasajeros[i].join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}			
//		}
				
//		System.out.println("Se vendieron "+expendedora.getTicketVendidos()+" tickets");
		
		
		
	}
}
