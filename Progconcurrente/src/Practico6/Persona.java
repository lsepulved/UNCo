package Practico6;

public class Persona implements Runnable{
	
	private GestorSala gestor;
	private boolean jubilado;
	
	public Persona(GestorSala unGestor, boolean esJubilado) {
		this.gestor=unGestor;
		this.jubilado=esJubilado;
	}
	
	public void run() {
		if (this.jubilado) {
			this.gestor.esperarJubilado();
			this.gestor.entrarSalaJubilado();
		}else {
			this.gestor.entrarSala();
		}
		
		System.out.println("*******"+Thread.currentThread().getName() + " entro a la sala");
		this.entrar();
		
		this.gestor.SalirSala();
		
		System.out.println("*******"+Thread.currentThread().getName() + " salio de la sala");
	}
	
	private void entrar() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
