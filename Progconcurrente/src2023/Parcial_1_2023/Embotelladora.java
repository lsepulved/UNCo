package Parcial_1_2023;

import java.util.concurrent.Semaphore;

public class Embotelladora {

	private int limiteBotellas;
	private int limiteCajas;
	
	private int cantBotellasAgua;
	private int cantBotellasVino;
	private int cantCajas;
	
	private Semaphore mutexAgua;
	private Semaphore mutexVino;
	private Semaphore mutexEmpaquetador;
	private Semaphore mutexTransportardor;
	
	private Semaphore botellaAgua;
	private Semaphore botellaVino;
	private Semaphore usoEmpaquetador;
	private Semaphore tomarCaja;
	private Semaphore dejarCaja;
	private Semaphore transportar;
	
	private boolean llenaVino;
	private boolean llenaAgua;
	
	public Embotelladora(int unLimiteBotellas, int unLimiteCajas) {
		
		this.limiteBotellas=unLimiteBotellas;
		this.limiteCajas=unLimiteCajas;
		
		this.cantBotellasAgua=0;
		this.cantBotellasVino=0;
		this.cantCajas=0;
		
		this.mutexAgua=new Semaphore(1);
		this.mutexVino=new Semaphore(1);
		this.mutexEmpaquetador=new Semaphore(1);
		this.mutexTransportardor=new Semaphore(1);
		
		this.botellaAgua=new Semaphore(1);
		this.botellaVino=new Semaphore(1);
		
		this.tomarCaja=new Semaphore(0);
		this.dejarCaja=new Semaphore(0);
		this.transportar=new Semaphore(0);
		this.usoEmpaquetador=new Semaphore(1);
		
		this.llenaAgua=false;
		this.llenaVino=false;
	}
	
	public void embotellarAgua() {
		try {
			this.botellaAgua.acquire();
			this.mutexAgua.acquire();
			
			if (this.cantBotellasAgua<this.limiteBotellas) {
				System.out.println(Thread.currentThread().getName()+ " agua EMBOTELLADA");
				this.cantBotellasAgua++;
				this.botellaAgua.release();					
				
			}else {
				this.usoEmpaquetador.acquire();
				System.out.println(Thread.currentThread().getName()+ " caja de agua llena, se puede retirar");
				this.llenaAgua=true;
				this.tomarCaja.release();
			}
			
			this.mutexAgua.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void embotellarVino() {
		try {
			this.botellaVino.acquire();
			this.mutexVino.acquire();
			
			if (this.cantBotellasVino<this.limiteBotellas) {
				System.out.println(Thread.currentThread().getName()+ " vino EMBOTELLADO");
				this.cantBotellasVino++;				
				this.botellaVino.release();
			
			}else {
				this.usoEmpaquetador.acquire();
				System.out.println(Thread.currentThread().getName()+ " caja de vino llena, se puede retirar");
				this.llenaVino=true;
				this.tomarCaja.release();
			}
			
			this.mutexVino.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void empaquetar() {
		try {
			this.tomarCaja.acquire();
			this.mutexEmpaquetador.acquire();
			if (this.cantCajas<this.limiteCajas) {
				this.cantCajas++;
				if (this.llenaVino) {
					System.out.println(Thread.currentThread().getName()+ " empaqueto caja de vino");
				}else {
					if (this.llenaAgua) {
						System.out.println(Thread.currentThread().getName()+ " empaqueto caja de agua");
					}
				}
				
				this.dejarCaja.release();
			}else {
				System.out.println(Thread.currentThread().getName()+ " almacen lleno, debo llamar al transportador");
				this.transportar.release();
			}
			this.mutexEmpaquetador.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dejarCaja() {
		try {
			this.dejarCaja.acquire();
			this.mutexEmpaquetador.acquire();
			
			if (this.llenaVino) {
				System.out.println(Thread.currentThread().getName()+ " dejo caja de vino en almacen y repongo caja vacia");
				this.cantBotellasVino=0;
				this.botellaVino.release();
				this.llenaVino=false;
			}else {
				if (this.llenaAgua) {
					System.out.println(Thread.currentThread().getName()+ " dejo caja de agua en almacen y repongo caja vacia");
					this.cantBotellasAgua=0;
					this.botellaAgua.release();
					this.llenaAgua=false;
				}
			}
			this.usoEmpaquetador.release();
			
			this.mutexEmpaquetador.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void transpotarCajas() {
		try {
			this.transportar.acquire();
			this.mutexTransportardor.acquire();
			System.out.println(Thread.currentThread().getName()+ " retiro las cajas del almacen");
			this.cantCajas=0;
			this.dejarCaja.release();
			this.mutexTransportardor.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
