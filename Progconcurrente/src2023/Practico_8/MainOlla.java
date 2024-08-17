package Practico_8;

public class MainOlla {

	public static void main (String[] args) {
		
		int limiteOlla=5;
		Olla olla=new Olla(limiteOlla);
		
		
		Cocinero unCocinero=new Cocinero(olla);
		Thread hiloCocinero=new Thread(unCocinero,"Cocinero");
		hiloCocinero.start();
		
		int cantCanibales=13;
		for (int i=0;i<cantCanibales;i++) {
			Canibal unCanibal=new Canibal(olla);
			Thread hiloCanibal=new Thread(unCanibal,"Canibal"+i);
			hiloCanibal.start();
		}
	}
}
