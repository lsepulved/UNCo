package Practico_7;

public class PersonaMuseo implements Runnable{

	private SalaMuseo sala;
	private char tipo;
	
	public PersonaMuseo(SalaMuseo unaSala,char unTipo) {
		this.sala=unaSala;
		this.tipo=unTipo;
	}
	
	public void run() {
		
		this.esperando();
		
		if (this.tipo=='P') {
			this.sala.entrarSala();
		}else {
			this.sala.entrarSalaJubilado();
		}
		
		this.visitandoMuseo();
		this.sala.salirSala();
	}

	public void esperando() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void visitandoMuseo() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
