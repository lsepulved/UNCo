package Parcial_2_2021;

public class BailarinPareja implements Runnable{
	
	private Sala sala;
	
	public BailarinPareja(Sala unaSala) {
		this.sala=unaSala;
	}

	public void run() {
		int fila;
		
		fila=this.sala.elegirFila();
		this.esperando();
		if (fila==1) {
			this.sala.entraFila1();
		}else {
			this.sala.entraFila2();
		}
	}
	
	public void esperando() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
