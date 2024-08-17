package Practico_3;

public class MainEjercicio2 {

	public static void main(String[] args) {

		Vida unaVida=new Vida();
		
		Orco unOrco=new Orco(unaVida);
		Curandero unCurandero=new Curandero(unaVida);
		
		Thread hiloOrco=new Thread(unOrco,"soy Orco");
		Thread hiloCurandero=new Thread(unCurandero,"soy Curandero");
		
		
		hiloOrco.start();
		hiloCurandero.start();
	}
}
