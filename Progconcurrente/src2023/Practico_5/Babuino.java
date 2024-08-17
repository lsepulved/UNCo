package Practico_5;

public class Babuino implements Runnable {

	Cuerda cuerda;
	char tipo;
	
	public Babuino(Cuerda unaCuerda,char unTipo) {
		this.cuerda=unaCuerda;
		this.tipo=unTipo;

	}
	
	public void run() {
//		while (true) {
			if (this.tipo=='N') {
				this.cuerda.subirCuerdaNorte();
				this.cruzando();
				this.cuerda.dejarCuerdaNorte();
			}else {
				this.cuerda.subirCuerdaSur();
				this.cruzando();
				this.cuerda.dejarCuerdaSur();
			}			
//		}
	}
	
	public void cruzando() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
