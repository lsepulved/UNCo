package TeoriaSemaforo;

public class MainRestaurant {

	public static void main (String[]args) {
		
		Comida comida=new Comida();
		
		Mozo mozo=new Mozo(comida);
		Thread hiloMozo=new Thread(mozo,"Soy Mozo");
		
		Cocinero cocinero= new Cocinero(comida);
		Thread hiloCocinero=new Thread(cocinero,"Soy cocinero");
		
		hiloMozo.start();
		hiloCocinero.start();
		
	}
}
