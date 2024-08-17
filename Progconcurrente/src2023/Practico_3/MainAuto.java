package Practico_3;

import java.util.Random;

public class MainAuto {

	public static void main (String[] args) {
		
		int maxLitros=20;
		Surtidor3 surtidor= new Surtidor3(maxLitros);
		
		int cantAutos=50;
		Random random=new Random();
		int litros;
		
		
		for(int i=0;i<cantAutos;i++) {
			litros= random.nextInt(10)+1;
			Auto3 unAuto=new Auto3("A"+i, i, "Marca "+i, i*100, 5, litros, 10, surtidor);
			Thread hiloAuto=new Thread(unAuto,"Auto "+i);
			hiloAuto.start();
		}
	}
}
