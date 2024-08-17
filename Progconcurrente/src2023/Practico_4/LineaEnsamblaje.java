package Practico_4;

import java.util.concurrent.Semaphore;

public class LineaEnsamblaje {
	private char tipo;
	private int numLinea;
	private int cantLinea;
	private int capacidadLinea;
	private boolean lineaDetenida;
	private Semaphore entra;
	private Semaphore ensambla;	
	private Semaphore sale;
	private Semaphore mutex;
	private Semaphore mutex2;
	private Semaphore cambiarLinea;
	
	public LineaEnsamblaje(int unaCapacidad1, char unTipo,int unNum) {
		this.cantLinea=0;
		this.numLinea=unNum;
		this.capacidadLinea=unaCapacidad1;
		this.entra=new Semaphore(1);
		this.ensambla=new Semaphore(0);		
		this.sale=new Semaphore(0);			
		this.tipo=unTipo;
		this.mutex= new Semaphore(1);
		this.mutex2= new Semaphore(1);
		this.cambiarLinea= new Semaphore(0);
		this.lineaDetenida=false;
	}
	
	public boolean llega(char unTipo) {
		boolean exito=false;
		try {			
			this.entra.acquire();
			this.mutex2.acquire();				
			if (this.cantLinea<this.capacidadLinea && this.lineaDetenida==false && this.tipo==unTipo) {
				this.cantLinea++;
				exito=true;
				System.out.println(Thread.currentThread().getName() +".........................................llega Linea "+this.numLinea+" "+this.getTipo()+" unTipo "+unTipo);				
				this.ensambla.release();
				this.entra.release();
			}
			this.mutex2.release();				
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exito;
	}
	
	public void ensambla() {
		try {
			this.ensambla.acquire();
			this.sale.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void sale() {
		try {
			this.sale.acquire();
			this.mutex.acquire();
			if (this.cantLinea>0) {				
				this.cantLinea--;
				System.out.println(Thread.currentThread().getName() +"________________________ SALE Linea "+this.numLinea+" "+this.getTipo());
				
				if (this.cantLinea==0 && this.lineaDetenida==true) {
					System.out.println(Thread.currentThread().getName()+"-------------------------------->Linea "+this.numLinea+" Vacia");
					this.cambiarLinea.release();	
				}
				
//				if (this.lineaDetenida==false) {
//					this.entra.release();	
//				}
				
			}
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void detenerLineas(LineaEnsamblaje linea1, LineaEnsamblaje linea2) {
//		char tipo;
		try {
			System.out.println("======================>"+Thread.currentThread().getName()+" detener las lineas");

			this.mutex.acquire();
			
			linea1.lineaDetenida=true;
			linea2.lineaDetenida=true;

			if (linea1.cantLinea==0) {
				linea1.cambiarLinea.release();
			}
			
			if (linea2.cantLinea==0) {
				linea2.cambiarLinea.release();
			}
			
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void cambiarLineas(LineaEnsamblaje linea1, LineaEnsamblaje linea2) {
		char unTipo;
		try {
			
			linea1.cambiarLinea.acquire();
			linea2.cambiarLinea.acquire();
			
			this.mutex.acquire();

//			if (linea1.cantLinea==0 && linea1.lineaDetenida==true && linea2.cantLinea==0 && linea2.lineaDetenida==true) {
				unTipo=linea1.tipo;
				System.out.println(Thread.currentThread().getName()+" tipo "+linea1.tipo +"......es Linea "+linea1.numLinea+" cambia a TIPO "+linea2.tipo);
				System.out.println(Thread.currentThread().getName()+" tipo "+linea2.tipo +"......es Linea "+linea2.numLinea+" cambia a TIPO "+linea1.tipo);			
				linea1.tipo=linea2.tipo;
				linea2.tipo=unTipo;
			
				linea1.entra.release();
				linea1.lineaDetenida=false;
				linea2.entra.release();
				linea2.lineaDetenida=false;
				
//			}
			
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char unTipo) {
		try {
			this.mutex.acquire();
			this.tipo=unTipo;
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
