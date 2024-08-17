package Practico4;

public class MainCoches {

	public static void main (String args[]) {
		
		int cantCoches=5;
		GestorCruce gestor=new GestorCruce();
		
		Thread[] coches=new Thread[cantCoches];
		
		Control control=new Control(gestor);
		Thread hiloControl=new Thread(control,"Control");
		
		for (int i=0;i<cantCoches;i++) {
			Coche coche=new Coche(gestor);
			coches[i]=new Thread(coche,"Coche"+i);
			coches[i].start();
		}
		
		hiloControl.start();
		
	}
}
