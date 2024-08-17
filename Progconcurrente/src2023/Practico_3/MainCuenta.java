package Practico_3;

public class MainCuenta {
	
	public static void main(String[] args) {
		VerificarCuenta3 vc = new VerificarCuenta3();
		
		Thread Luis = new Thread(vc, "Luis");
		Thread Manuel = new Thread(vc, "Manuel");
		
		Luis.start();
		Manuel.start();
	}
}
