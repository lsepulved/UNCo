package Practico_3;

public class MainEjercicio3 {

	public static void main (String[]args) {
		
		SalaConcierto salaConcierto=new SalaConcierto(10);
		salaConcierto.iniciarSala();
		
		int cantHilos=10;
		String nombre;
		Thread [] terminales= new Thread[cantHilos];

		for (int i=0;i<cantHilos;i++) {
			ReservarAsiento reserva= new ReservarAsiento(salaConcierto);			
			nombre="Terminal "+i;
			terminales[i]=new Thread(reserva,nombre);
			terminales[i].start();
		}

//		for (int i=0;i<cantHilos;i++) {
//			terminales[i].start();
//		}

	}
	
}
