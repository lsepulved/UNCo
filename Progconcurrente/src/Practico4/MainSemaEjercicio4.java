package Practico4;

public class MainSemaEjercicio4 {

	public static void main (String[]args) {
	
		Jaula unaJaula=new Jaula();
		
		
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