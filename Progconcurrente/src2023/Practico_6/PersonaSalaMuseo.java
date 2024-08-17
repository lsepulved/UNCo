package Practico_6;

public class PersonaSalaMuseo implements Runnable {
	
	GestorSala gestor;
	char tipo;
	
	public PersonaSalaMuseo(GestorSala unGestor, char unTipo) {
		this.gestor=unGestor;
		this.tipo=unTipo;
	}
	
	public void run() {

		this.esperando();
		if (this.tipo=='J') {
			this.gestor.jubiladoEntraSala();
		}else {
			this.gestor.personaEntraSala();
		}
		this.visitandoSala();
		this.gestor.salirPersona();
	}
	
	
	public void esperando() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void visitandoSala() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
