package Practico6;

public class MainCuartel {

	public static void main (String []args) {
		
		int cantBandejasAlmuerzo=5;
		int cantBandejasPostres=3;
		int cantAbridores=10;
		
		Cuartel cuartel = new Cuartel(cantBandejasAlmuerzo, cantBandejasPostres, cantAbridores);
		
		int cantSoldados=10;
		Thread[] soldados=new Thread[cantSoldados];
		
		for (int i=0;i<cantSoldados;i++) {
			Soldado soldado=new Soldado(cuartel);
			soldados[i]=new Thread(soldado,"Soldado"+i);
			soldados[i].start();
		}
		
	}
}
