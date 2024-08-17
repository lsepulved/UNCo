package Practico6;

public class MainCanibal {

	public static void main (String []args) {
		
		int cantRaciones=5;
		Olla olla=new Olla(cantRaciones);
		
		int cantCanibales=13;		
		Thread[] canibales=new Thread[cantCanibales];
		
		Cocinero cocinero=new Cocinero(olla);
		Thread hiloCocinero= new Thread(cocinero,"Cocinero");
		
		for (int i=0;i<cantCanibales;i++) {
			Canibal canibal=new Canibal(olla);
			canibales[i]=new Thread(canibal,"Canibal "+i);
			canibales[i].start();
		}		
		hiloCocinero.start();
	}
}
