package Practico_3;

public class MainVida {

	public static void main (String[] args) {
	
		int puntos=10;
		Vida3 vida=new Vida3(puntos);
		
		Curandero3 unCurandero= new Curandero3(vida);
		Orco3 unOrco= new Orco3(vida);
		
		Thread hiloCurandero=new Thread(unCurandero, "Curandero");
		Thread hiloOrco=new Thread(unOrco, "Orco");
		
		hiloCurandero.start();
		hiloOrco.start();
	}
}
