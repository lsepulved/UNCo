package Parciales;

public class MainParcial1 {

	public static void main (String[]args) {
		
		int cantOraciones=2;
		Armada armada=new Armada(cantOraciones);
		
		for (int i=1;i<=5;i++) {
			
			InterceptarOracion intercepto=new InterceptarOracion(armada);
			Thread hilo1=new Thread(intercepto, "Division "+i);
			
//			InterceptarOracion2 intercepto2=new InterceptarOracion2(division);
//			Thread hilo2=new Thread(intercepto2, "Division "+i);
			
			hilo1.start();
//			hilo2.start();
		}
	}
}
