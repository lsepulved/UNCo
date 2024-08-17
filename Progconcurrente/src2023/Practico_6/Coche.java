package Practico_6;

public class Coche implements Runnable {

	private char tipo;
	private Puente puente;
	
	public Coche(Puente unPuente, char unTipo) {
		this.puente=unPuente;
		this.tipo=unTipo;
	}
	
	public void run() {
//		boolean band=false;
		
		if (this.tipo=='N') {
			this.puente.entrarNortePuente();
			this.cruzando();
			this.puente.salirPuenteSur();
//			while (!band) {
//				band=this.puente.salirPuenteSur();	
//			}
			
		}else {
			this.puente.entrarSurPuente();
			this.cruzando();
			this.puente.salirPuenteNorte();
//			while (!band) {
//				band=this.puente.salirPuenteNorte();
//			}
			
		}
		
	}
	
	public void cruzando() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
