package Practico_6;

public class SalaEstudio {

	private int limiteMesas;
	private int cantMesasOcupadas;
	private int esperandoMesa;
	
	public SalaEstudio(int unCantMesas) {
		this.limiteMesas=unCantMesas;
		this.cantMesasOcupadas=0;
		this.esperandoMesa=0;
	}
	
	
	public synchronized void usarMesa() {
		this.esperandoMesa++;
		
		try {
			while(this.cantMesasOcupadas>=this.limiteMesas) {
				System.out.println(Thread.currentThread().getName()+"......esperando mesa");				
				this.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		this.esperandoMesa--;
		System.out.println(Thread.currentThread().getName()+"......uso mesa");
		this.cantMesasOcupadas++;
	}
	
	public synchronized void dejarMesa() {
		
		this.cantMesasOcupadas--;
		System.out.println(Thread.currentThread().getName()+"......dejo la mesa");
		this.notify();
		
	}
	
	
}
