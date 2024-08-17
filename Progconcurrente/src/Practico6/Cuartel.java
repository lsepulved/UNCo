package Practico6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cuartel {

	private int bandejasAlmuerzo;
	private int bandejasPostre;
	private int abridores;
	
	final Lock cerrojo=new ReentrantLock();
	final Condition almuerzoDisponible= cerrojo.newCondition();
	final Condition postreDisponible=cerrojo.newCondition();
	final Condition abridorDisponible=cerrojo.newCondition();
	
	public Cuartel(int unasBandejasAlmuerzo, int unasBandejasPostre, int unosAbridores ) {
		this.bandejasAlmuerzo=unasBandejasAlmuerzo;
		this.bandejasPostre=unasBandejasPostre;
		this.abridores=unosAbridores;
	}
	
	public void tomarBandejaAlmuerzo() {
		this.cerrojo.lock();
		try {
			while (this.bandejasAlmuerzo==0) {
				almuerzoDisponible.await();
			}
			this.bandejasAlmuerzo--;
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.cerrojo.unlock();	
		}		
		
	}
	
	public void devolverBandejaAlmuerzo() {
		this.cerrojo.lock();
		this.bandejasAlmuerzo++;
		this.almuerzoDisponible.signal();
		this.cerrojo.unlock();
	}
	
	public void tomarBandejaPostre() {
		this.cerrojo.lock();
		try {
			while (this.bandejasPostre==0) {
				this.postreDisponible.await();
			}
			this.bandejasPostre--;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.cerrojo.unlock();
		}
	}
	
	public void dejarBandejaPostre() {
		this.cerrojo.lock();
		this.bandejasPostre++;
		this.postreDisponible.signal();
		this.cerrojo.unlock();		
	}
	
	public void tomarAbridor() {
		this.cerrojo.lock();
		try {
			while (this.abridores==0) {
				this.abridorDisponible.await();
			}
			this.abridores--;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.cerrojo.unlock();
		}
	}
	
	public void dejarAbridor() {
		this.cerrojo.lock();
		this.abridores++;
		this.abridorDisponible.signal();
		this.cerrojo.unlock();
	}
	
}
