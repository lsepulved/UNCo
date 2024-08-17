package TPObligatorio;

public class Reloj {

	private int hora;
	private int totalHoras;
	private int cantDurmientes;
	private int totalDurmientes;
	
	public Reloj (int total) {
		this.hora=0;
		this.totalHoras=24;
		this.cantDurmientes=total;
		this.totalDurmientes=total;
	}
	
	public int getHora() {
		return this.hora;
	}

	public synchronized void incrementarTotalDurmientes() {
		this.totalDurmientes++;
	}

	public synchronized void decrementarTotalDurmientes() {
		this.totalDurmientes--;
	}
	
	public synchronized void trabajar (int unaHora) {
			
		while (this.hora!=unaHora) {
			System.out.println(Thread.currentThread().getName()+": No es mi horario de trabajo");
			try {
				this.wait();
				
				if (this.cantDurmientes>0) {
					this.notify();
					this.cantDurmientes--;
				}				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void incrementarHora() {
		if (this.hora+1==totalHoras) {
			this.hora=0;
		}else {
			this.hora++;
		}
		System.out.println("==================================Hora Actual "+this.hora+"hs===========");

		this.notify();
		this.cantDurmientes=this.totalDurmientes-1;

		System.out.println("");
		

		
	}
}

