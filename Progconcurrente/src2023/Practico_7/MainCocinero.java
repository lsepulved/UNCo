package Practico_7;

public class MainCocinero {

	public static void main (String []args) {

		int limiteVegetales=5;
		int limiteCarne=3;
		int limitePasta=8;
		

		Ingrediente ingrediente=new Ingrediente(limiteVegetales,limiteCarne,limitePasta);
				
		int cantCocineroCarne=4;
		int cantCocineroVegetal=8;
		int cantCocineroPasta=12;
		
		int total=cantCocineroCarne+cantCocineroVegetal+cantCocineroPasta;
		
		for (int i=0;i<total;i++) {
			if (i<cantCocineroCarne) {
				Cocinero unCocinero=new Cocinero(ingrediente, 'C');
				Thread hiloCocineroCarne= new Thread(unCocinero,"CocineroCarne"+i);
				hiloCocineroCarne.start();
			}else {
				if(i<(cantCocineroCarne+cantCocineroVegetal)) {
					Cocinero unCocinero=new Cocinero(ingrediente, 'V');
					Thread hiloCocineroVegetal= new Thread(unCocinero,"CocineroVegetal"+i);
					hiloCocineroVegetal.start();
				}else {
					Cocinero unCocinero=new Cocinero(ingrediente, 'P');
					Thread hiloCocineroPasta= new Thread(unCocinero,"CocineroPasta"+i);
					hiloCocineroPasta.start();
				}
			}
		}
		
	}

}
