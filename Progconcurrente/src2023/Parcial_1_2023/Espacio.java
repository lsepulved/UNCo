package Parcial_1_2023;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Espacio {

	private int cantO;
	private int eliminarO;
	private int cantH;
	private int eliminarH;
	private int agua;
	private int limite;
	private boolean esOxigeno;

	private int cantHesperando;
	private int cantOesperando;
	
	private final Lock cerrojo;
	
	private final Condition oxigenos;
	private final Condition hidrogenos;
	
	public Espacio(int unLimite) {
		this.cantHesperando=0;
		this.cantOesperando=0;
		
		this.esOxigeno=false;
		this.limite=unLimite;
		this.agua=0;
		this.cantH=0;
		this.eliminarH=0;
		this.cantO=0;
		this.eliminarO=0;
		
		this.cerrojo= new ReentrantLock();
		this.oxigenos=cerrojo.newCondition();
		this.hidrogenos=cerrojo.newCondition();
	}
	
	public void Olisto() {
		try {
			this.cerrojo.lock();
			System.out.println("+++++++++++++++"+Thread.currentThread().getName()+" ....");
			this.cantO++;
			while (this.cantH<2 && this.eliminarO<=0) {
//			while (!((this.cantO>=1 && this.cantH>=2)|| this.eliminarO>0)) {			
				System.out.println(Thread.currentThread().getName()+" .... esperando para hacer Agua");
				this.oxigenos.await();	
			}
			
			if (this.eliminarO>0){
				this.eliminarO--;
				System.out.println(Thread.currentThread().getName()+" .... FUI USADO PARA HACER AGUA");
			}else {
				this.esOxigeno=true;
				this.hacerAgua();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.cerrojo.unlock();
		}
	}
	
	public void Hlisto() {
		try {
			this.cerrojo.lock();
			System.out.println("===================="+Thread.currentThread().getName()+" ....");
			this.cantH++;
			while ((this.cantH<2 || this.cantO<1) && eliminarH<=0) {
//			while (!((this.cantO>=1 && this.cantH>=2)|| this.eliminarH>0)){	
				System.out.println(Thread.currentThread().getName()+" .... esperando para hacer Agua");
				this.hidrogenos.await();	
			}
			this.cantH++;
			
			if (this.eliminarH>0){
				this.eliminarH--;
				System.out.println(Thread.currentThread().getName()+" .... FUI USADO PARA HACER AGUA");
			}else {
				this.esOxigeno=false;
				this.hacerAgua();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.cerrojo.unlock();
		}
	}
	
	public void hacerAgua() {
		this.cerrojo.lock();
		System.out.println(Thread.currentThread().getName()+" .... HACIENDO AGUA----------------------");
		
		if (this.esOxigeno) {
			this.cantO--;
			this.eliminarH+=2;
			this.hidrogenos.signal();
			this.hidrogenos.signal();
			this.cantH-=2;
		}else {
			this.cantH-=2;
			this.eliminarH++;
			this.eliminarO++;
			this.cantO--;
			this.oxigenos.signal();
			this.hidrogenos.signal();
		}
		
		this.agua++;
		if (this.agua>this.limite) {
			System.out.println("Recipiente lleno, repongo uno vacio");
			this.agua=0;
		}
		
		this.cerrojo.unlock();

	}
	
}
