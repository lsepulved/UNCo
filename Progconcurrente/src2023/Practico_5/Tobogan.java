package Practico_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Tobogan {

	private Queue<Thread> escalera;
	private int limite;
	private int esperandoEscalera;
	private int enEscalera;
	
	private Semaphore usoTobogan;
	private Semaphore dejoTobogan;
	private Semaphore libreTobogan;

	private Semaphore usoEscalera;
	private Semaphore dejoEscalera;
	
	private Semaphore mutex;
	private Semaphore avisoResponsable;

	
	public Tobogan(int unLimite) {
		this.escalera=new LinkedList<Thread>();
		this.limite=unLimite;
		this.esperandoEscalera=0;
		this.enEscalera=0;
		
		this.usoTobogan=new Semaphore(0);
		this.dejoTobogan=new Semaphore(0);
		this.libreTobogan=new Semaphore(2);
	
		this.usoEscalera=new Semaphore(this.limite);
		this.dejoEscalera=new Semaphore(1);
		
		this.mutex=new Semaphore(1);
		this.avisoResponsable=new Semaphore(0);
	
	}
	
	public void usarEscalera() {
		try {
			this.mutex.acquire();
			this.esperandoEscalera++;
			this.mutex.release();
			
			this.usoEscalera.acquire();
			this.mutex.acquire();
			System.out.println(Thread.currentThread().getName()+"________________________uso escalera");
			this.enEscalera++;
			this.esperandoEscalera--;
			this.escalera.add(Thread.currentThread());	
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean dejarEscalera() {
		boolean band=false;
		try {
			this.dejoEscalera.acquire();
			System.out.println("=============="+Thread.currentThread().getName()+"..........................INTENTA DEJAR ESCALERA");
			if (Thread.currentThread().getId()==this.escalera.peek().getId()&& this.enEscalera>0) {
				
				this.libreTobogan.acquire();
				
				this.mutex.acquire();
				System.out.println("=============="+Thread.currentThread().getName()+"........deja escalera");
				escalera.remove();
				band=true;
				if (this.enEscalera>0) {
					this.dejoEscalera.release();
				}
				
				if (this.esperandoEscalera>0) {
					this.usoEscalera.release();	
					}
				
				this.avisoResponsable.release();
				this.mutex.release();
					
			}else {
				this.dejoEscalera.release();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return band;
	}
	
	public void eligeTobogan() {
		try {
			
			this.avisoResponsable.acquire();
			this.mutex.release();
			System.out.println("_____"+Thread.currentThread().getName()+"...................elige tobogan");
			this.usoTobogan.release();
			this.mutex.acquire();
				
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void entrarTobogan() {
		try {
			this.usoTobogan.acquire();
			this.mutex.acquire();
			System.out.println(Thread.currentThread().getName()+".........entra en tobogan");		
			this.dejoTobogan.release();
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void salirTobogan() {
		try {
			this.dejoTobogan.acquire();			
			this.mutex.acquire();
			System.out.println(Thread.currentThread().getName()+"......sale del tobogan");
			this.libreTobogan.release();
			this.mutex.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
