package Practico_3;

public class MainReserva {

	public static void main (String[] args) {
		
		int tamanio=10;
		int clientes=30;
		
		SalaConcierto3 sala=new SalaConcierto3(tamanio);
//		sala.vaciarSala();
		
		
		for(int i=0;i<clientes;i++) {
			Reserva reserva=new Reserva(sala);
			Thread cliente=new Thread(reserva,"Terminal "+i);
			cliente.start();
		}
		
	}
}
