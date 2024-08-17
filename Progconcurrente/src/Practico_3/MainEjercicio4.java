package Practico_3;

public class MainEjercicio4 {

	public static void main (String[]args) {
	
		Jaula unaJaula=new Jaula();
		unaJaula.iniciarJaula();
		
		
		int cantidadHamsters=5;
		Thread [] hamsters=new Thread[cantidadHamsters];
		
		for (int i=0;i<cantidadHamsters;i++) {
			ActividadJaula unaActividad=new ActividadJaula(unaJaula);
			hamsters[i]=new Thread(unaActividad,"Hamster "+i);
			hamsters[i].start();
		}

//		for (int i=0;i<cantidadHamsters;i++) {
//			hamsters[i].start();
//		}
		
	}
}
