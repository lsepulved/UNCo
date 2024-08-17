package Practico_5;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cuerda {
	
	private int babuinosEsperandoNorte;
	private int babuinosEsperandoSur;
	private int cantBabuinos;
	private int limite;
	
	private Semaphore cuerda;
//	private Semaphore dejarCuerda;
	
	private Semaphore turnoNorte;
	private Semaphore turnoSur;
	
	private Semaphore mutex;
	
	public Cuerda(int unLimite) {
		this.limite=unLimite;
		
		this.babuinosEsperandoNorte=0;
		this.babuinosEsperandoSur=0;
		this.cantBabuinos=0;
		
		this.cuerda=new Semaphore(this.limite);
//		this.dejarCuerda=new Semaphore(0);
		
		this.turnoNorte=new Semaphore(0);
		this.turnoSur=new Semaphore(0);
		
		this.mutex=new Semaphore(1);
		
		this.turnoLado();
	}
	
	public void turnoLado() {
		Random random=new Random();
		int valor;
		valor=random.nextInt(2);
		
		if (valor==0) {
			this.turnoNorte.release(this.limite);
		}else {
			this.turnoSur.release(this.limite);
		}
	}
	
	public void subirCuerdaNorte() {
		try {
			this.mutex.acquire();
			this.babuinosEsperandoNorte++;
			this.mutex.release();
			
			this.turnoNorte.acquire();
			this.cuerda.acquire();
			
			this.mutex.acquire();			
			System.out.println(Thread.currentThread().getName()+"..............entra babuino por el NORTE");
			
//			if (this.cantBabuinos<this.limite && this.babuinosEsperandoNorte>0) {
//				this.turnoNorte.release();
//			}else {
//				if (this.cantBabuinos==0) {
//					if (this.babuinosEsperandoSur>0) {
//						this.turnoSur.release();
//					}else {
//						if (this.babuinosEsperandoNorte>0) {
//							this.turnoNorte.release();
//						}
//					}
//					
//				}
//			}
			this.cantBabuinos++;
			this.babuinosEsperandoNorte--;
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void subirCuerdaSur() {
		try {
			this.mutex.acquire();
			this.babuinosEsperandoSur++;
			this.mutex.release();
			
			this.turnoSur.acquire();
			this.cuerda.acquire();
			
			this.mutex.acquire();
			System.out.println(Thread.currentThread().getName()+"..............entra babuino por el SUR");
//			if (this.cantBabuinos<this.limite && this.babuinosEsperandoSur>0) {
//				this.turnoSur.release();
//			}else {
//				if (this.cantBabuinos==0) {
//					if (this.babuinosEsperandoNorte>0) {
//						this.turnoNorte.release();
//					}else {
//						if (this.babuinosEsperandoSur>0) {
//							this.turnoSur.release();
//						}
//					}
//					
//				}
//			}
			
			this.cantBabuinos++;
			this.babuinosEsperandoSur--;
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dejarCuerdaNorte() {
		try {
			this.mutex.acquire();
			this.cantBabuinos--;
			
			System.out.println(Thread.currentThread().getName()+"_______________________________sale babuino por el SUR, QUEDAN "+this.cantBabuinos);
			if (this.cantBabuinos==0) {
				System.out.println(Thread.currentThread().getName()+"______________________cambio turno a SUR_____________________");
				if (this.babuinosEsperandoSur>this.limite) {
					this.turnoSur.release(this.limite);
					this.cuerda.release(this.limite);
				}else {
					if (this.babuinosEsperandoSur>0) {
						this.turnoSur.release(this.babuinosEsperandoSur);
						this.cuerda.release(this.babuinosEsperandoSur);
					}else {
						System.out.println(Thread.currentThread().getName()+"===============SIGO turno a NORTE==============");
						if (this.babuinosEsperandoNorte>this.limite) {
							this.turnoNorte.release(this.limite);
							this.cuerda.release(this.limite);
						}else {
							if (this.babuinosEsperandoNorte>0) {
								this.turnoNorte.release(this.babuinosEsperandoNorte);
								this.cuerda.release(this.babuinosEsperandoNorte);															
							}
						}
					}
				}
			}
			
			this.mutex.release();			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void dejarCuerdaSur() {
		try {
			this.mutex.acquire();
			this.cantBabuinos--;
			
			System.out.println(Thread.currentThread().getName()+"_______________________________sale babuino por el NORTE, QUEDAN "+this.cantBabuinos);
			
			if (this.cantBabuinos==0) {
				
				System.out.println(Thread.currentThread().getName()+"______________________cambio turno a NORTE_____________________");
				
				if (this.babuinosEsperandoNorte>this.limite) {
					this.turnoNorte.release(this.limite);
					this.cuerda.release(this.limite);
				}else {
					if (this.babuinosEsperandoNorte>0) {
						this.turnoNorte.release(this.babuinosEsperandoNorte);
						this.cuerda.release(this.babuinosEsperandoNorte);
					}else {
						System.out.println(Thread.currentThread().getName()+"===============SIGO turno a SUR==============");
						if (this.babuinosEsperandoSur>this.limite) {
							this.turnoSur.release(this.limite);
							this.cuerda.release(this.limite);
						}else {
							if (this.babuinosEsperandoSur>0) {
								this.turnoSur.release(this.babuinosEsperandoSur);
								this.cuerda.release(this.babuinosEsperandoSur);															
							}
						}
					}
				}
			}
			
			this.mutex.release();			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
