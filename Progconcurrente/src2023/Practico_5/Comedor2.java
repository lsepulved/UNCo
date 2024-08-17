package Practico_5;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Comedor2 {

		private int maxEspecie;
		private int contaPerros;
		private int contaGatos;
		
		private int perrosComiendo;
		private int gatosComiendo;
		private int perrosEsperando;
		private int gatosEsperando;
		
		private int cantComederos;
		
		private Semaphore plato;
		private Semaphore mutex;
		private Semaphore turnoPerros;
		private Semaphore turnoGatos;
		
		public Comedor2(int maximoEspecies,int cantComederos) {
			
			this.maxEspecie=maximoEspecies;
			this.contaPerros=0;
			this.contaGatos=0;
			
			this.cantComederos=cantComederos;
			this.perrosComiendo=0;
			this.gatosComiendo=0;

			this.perrosEsperando=0;
			this.gatosEsperando=0;
			
			this.plato=new Semaphore(cantComederos);
			this.mutex=new Semaphore(1);
			
			this.turnoGatos=new Semaphore(0);
			this.turnoPerros=new Semaphore(0);
			
			this.turnoEspecie();
		}
		
		public void turnoEspecie() {
			Random random=new Random();
			int valor=random.nextInt(2);
			if (valor==0) {
				this.turnoPerros.release(this.cantComederos/2);
			}else {
				this.turnoGatos.release(this.cantComederos);
			}
			
		}
		public void perroUsarPlato() {
			try {
				this.mutex.acquire();
				this.perrosEsperando++;
				this.mutex.release();
				this.turnoPerros.acquire();
				this.plato.acquire(2);
				this.mutex.acquire();
				this.contaPerros++;
				System.out.println("__________________"+Thread.currentThread().getName()+".....usando PLATO");
				this.perrosComiendo++;
				this.perrosEsperando--;			
				System.out.println("---------PERROS ESPERANDO....."+this.perrosEsperando);
				this.mutex.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void perroDejaPlato() {
			try {
				this.mutex.acquire();
				this.perrosComiendo--;			
				System.out.println(Thread.currentThread().getName()+".....dejando PLATO");
				if (this.contaPerros<this.maxEspecie && this.perrosEsperando>0) {
					this.turnoPerros.release();
				}else {
					System.out.println(".....Perros comiendo: "+this.perrosComiendo);
					if (this.perrosComiendo==0) {					
						this.contaPerros=0;
						if (this.gatosEsperando>0) {					
							System.out.println(".....CAMBIO DE TURNO, LE TOCA A LOS GATOS");
							if (this.gatosEsperando>this.cantComederos) {
								this.turnoGatos.release(this.cantComederos);
							}else {
								this.turnoGatos.release(this.gatosEsperando);
							}
						}else {
							if (this.perrosEsperando>0) {
								System.out.println(".....NO HAY GATOS ESPERANDO, CONTINUAMOS CON PERROS");
								this.turnoPerros.release();
							}
						}					
					}
				}
				
				this.plato.release(2);
				this.mutex.release();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void gatoUsarPlato() {
			try {
				this.mutex.acquire();			
				this.gatosEsperando++;
				this.mutex.release();
				this.turnoGatos.acquire();
				this.plato.acquire();
				this.mutex.acquire();
				this.contaGatos++;
				System.out.println("__________________"+Thread.currentThread().getName()+".....usando PLATO");
				this.gatosComiendo++;
				this.gatosEsperando--;			
				System.out.println("---------GATOS ESPERANDO....."+this.gatosEsperando);
				this.mutex.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void gatoDejaPlato() {
			try {
				this.mutex.acquire();
				this.gatosComiendo--;
				System.out.println(Thread.currentThread().getName()+".....dejando PLATO");			
				if (this.contaGatos<this.maxEspecie && this.gatosEsperando>0) {
					this.turnoGatos.release();
				}else {
					System.out.println(".....GATOS comiendo: "+this.gatosComiendo);
					if (this.gatosComiendo==0) {
						this.contaGatos=0;
						if (this.perrosEsperando>0) {					
							System.out.println(".....CAMBIO DE TURNO, LE TOCA A LOS PERROS");
							if (this.perrosEsperando>this.cantComederos) {
								this.turnoPerros.release(this.cantComederos);
							}else {
								this.turnoPerros.release(this.perrosEsperando);
							}
						}else {
							if (this.gatosEsperando>0) {
								System.out.println(".....NO HAY PERROS ESPERANDO, CONTINUAMOS CON GATOS");
								this.turnoGatos.release();
							}
						}					
					}
				}
				
				this.plato.release();
				this.mutex.release();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
