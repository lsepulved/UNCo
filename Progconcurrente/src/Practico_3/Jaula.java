package Practico_3;

public class Jaula {

	private boolean platoDisponible=true;
	private boolean ruedaDisponible=true;
	private boolean hamacaDisponible=true;
	
	public Jaula() {
		
	}
	
public boolean disponiblePlato(){
		return this.platoDisponible;
	}
	
	public boolean disponibleRueda(){
		return this.ruedaDisponible;
	}

	public boolean disponibleHamaca(){
		return this.hamacaDisponible;
	}

	public synchronized void liberarPlato(){
		this.platoDisponible=true;
	}

	public synchronized void liberarRueda(){
		this.ruedaDisponible=true;
	}

	public synchronized void liberarHamaca(){
		this.hamacaDisponible=true;
	}
	
	public synchronized boolean ocuparPlato() {
		boolean exito=false;
		if (this.platoDisponible) {
			System.out.println(Thread.currentThread().getName()+" ocupo el plato");
			this.platoDisponible=false;
			exito=true;
		}
		return exito;
	}
	
	public synchronized boolean ocuparRueda() {
		boolean exito=false;
		if (this.ruedaDisponible) {
			System.out.println(Thread.currentThread().getName()+" ocupo la rueda");			
			this.ruedaDisponible=false;
			exito=true;
		}
		return exito;
	}

	public synchronized boolean ocuparHamaca() {
		boolean exito=false;
		if (this.hamacaDisponible) {
			System.out.println(Thread.currentThread().getName()+" ocupo la hamaca");			
			this.hamacaDisponible=false;
			exito=true;
		}
		return exito;
	}
	
	public void iniciarJaula() {
		this.hamacaDisponible=true;
		this.platoDisponible=true;
		this.ruedaDisponible=true;
	}
	
}
