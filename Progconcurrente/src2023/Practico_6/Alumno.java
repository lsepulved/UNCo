package Practico_6;

public class Alumno implements Runnable{
	
	SalaEstudio sala;
	
	public Alumno(SalaEstudio unaSala) {
		this.sala=unaSala;
	}
	
	public void run() {
		this.esperarMesa();
		this.sala.usarMesa();
		this.usarMesa();
		this.sala.dejarMesa();
	}

	public void esperarMesa() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void usarMesa() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
