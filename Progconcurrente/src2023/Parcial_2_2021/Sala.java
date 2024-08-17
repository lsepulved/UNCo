package Parcial_2_2021;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sala {

	private int cantBailarinPareja;
	private int filaElegida;
	private int cantFila1;
	private int cantFila2;
	
	private int salirBailarFila1;
	private int salirBailarFila2;
	
	private final Lock cerrojo;
	private final Condition fila1;
	private final Condition fila2;
	
	private boolean soyFila1;
	
	public Sala() {
		this.cantBailarinPareja=0;
		this.cantFila1=0;
		this.cantFila2=0;
		this.filaElegida=0;
		this.soyFila1=false;
		
		this.salirBailarFila1=0;
		this.salirBailarFila2=0;
		
		this.cerrojo=new ReentrantLock(true);
		this.fila1=cerrojo.newCondition();
		this.fila2=cerrojo.newCondition();
		
	}
	
	public int elegirFila() {
		Random random=new Random();
		int valor=0;
		
		this.cerrojo.lock();
		
		if (this.cantBailarinPareja % 2==0) {
			this.filaElegida=random.nextInt(2)+1;
			valor=this.filaElegida;
		}else {
			if (this.filaElegida==1) {
				this.filaElegida=2;
				valor=this.filaElegida;
			}else {
				this.filaElegida=1;
				valor=filaElegida;
			}
		}
		
		this.cantBailarinPareja++;
		this.cerrojo.unlock();
		
		return valor;
	}
	
	public void entraFila1() {
		try {
			this.cerrojo.lock();
			this.cantFila1++;
			
			while (this.cantFila2<=0 && this.salirBailarFila1<=0) {
				System.out.println(Thread.currentThread().getName()+".....esperando compañero de la fila 2 para salir a bailar");
				this.fila1.await();
			}
			
			if (this.salirBailarFila1>0) {
				System.out.println(Thread.currentThread().getName()+".....soy de la fila 1, ya sali a bailar");
				this.salirBailarFila1--;
			}else {
				this.soyFila1=true;
				this.bailar();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.cerrojo.unlock();
		}
	}
	
	public void entraFila2() {
		try {
			this.cerrojo.lock();
			this.cantFila2++;
			while (this.cantFila1<=0 && this.salirBailarFila2<=0) {
				System.out.println(Thread.currentThread().getName()+".....esperando compañero de la fila 1 para salir a bailar");
				this.fila2.await();
			}
			
			if (this.salirBailarFila2>0) {
				System.out.println(Thread.currentThread().getName()+".....soy de la fila 2, ya sali a bailar");
				this.salirBailarFila2--;
			}else {
				this.soyFila1=false;
				this.bailar();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.cerrojo.unlock();
		}
	}
	
	public void bailar() {
		this.cerrojo.lock();
		
		if (this.soyFila1) {
			System.out.println(Thread.currentThread().getName()+".....soy fila 1, SALI A LA PISTA A BAILAR!!!!!!!!!");
			this.cantFila1--;
			this.salirBailarFila2++;
			this.fila2.signal();
			this.cantFila2--;
		}else {
			System.out.println(Thread.currentThread().getName()+".....soy fila 2, SALI A LA PISTA A BAILAR!!!!!!!!!");			
			this.cantFila2--;
			this.salirBailarFila1++;
			this.fila1.signal();
			this.cantFila1--;			
		}
		
		this.cerrojo.unlock();
	}
	
}
