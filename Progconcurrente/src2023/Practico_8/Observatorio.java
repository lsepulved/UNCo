package Practico_8;

public class Observatorio {

	private int cantVisitante;
	private int cantMantenimiento;
	private int cantInvestigador;

	private int cantVisitanteSilla;
	private int limite;
	private int capacidad;
	private int capacidadSilla;
	private int espacioSilla;
	
	public Observatorio(int unaCapacidad,int unaCapacidadSilla, int unEspacioSilla) {
		
		this.limite=unaCapacidad;
		this.capacidad=unaCapacidad;
		this.capacidadSilla=unaCapacidadSilla;
		this.espacioSilla=unEspacioSilla;
		
		this.cantVisitante=0;
		this.cantVisitanteSilla=0;
		this.cantMantenimiento=0;
		this.cantInvestigador=0;
				
	}
	
	public synchronized void entrarVisitante() {

		try {
			
			while (this.cantVisitante>=this.limite ||this.cantMantenimiento>0 || this.cantInvestigador>0) {
				System.out.println(Thread.currentThread().getName()+"...............esperando para poder ingresar, Visitantes: "+this.cantVisitante+" ,Mantenimiento: "+this.cantMantenimiento+" ,Investigador: "+this.cantInvestigador);
				this.wait();
			}
			System.out.println(Thread.currentThread().getName()+"...............ingreso al observatorio");
			this.cantVisitante++;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public synchronized void entrarVisitanteSilla() {
		try {
			
			while ((this.cantVisitante+this.espacioSilla)>=this.limite ||this.cantMantenimiento>0 || this.cantInvestigador>0) {
				System.out.println(Thread.currentThread().getName()+"...............esperando para poder ingresar, Visitantes: "+this.cantVisitante+" ,Mantenimiento: "+this.cantMantenimiento+" ,Investigador: "+this.cantInvestigador);
				this.wait();
			}
			System.out.println(Thread.currentThread().getName()+"...............ingreso al observatorio");
			this.cantVisitante=this.cantVisitante+this.espacioSilla;
			
			if (this.cantVisitanteSilla==0) {
				this.limite=this.capacidadSilla;
				System.out.println("!!!!!!!!!!!!!!!!!!!Cambio limite de capacidad: "+this.limite);				
			}
			
			this.cantVisitanteSilla++;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public synchronized void entrarMantenimiento() {

		try {
			
			while (this.cantMantenimiento>=this.limite ||this.cantVisitante>0 || this.cantInvestigador>0) {
				System.out.println(Thread.currentThread().getName()+"...............esperando para poder ingresar, Visitantes: "+this.cantVisitante+" ,Mantenimiento: "+this.cantMantenimiento+" ,Investigador: "+this.cantInvestigador);
				this.wait();
			}
			System.out.println(Thread.currentThread().getName()+"...............ingreso al observatorio");
			this.cantMantenimiento++;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public synchronized void entrarInvestigador() {
		try {
			
			while (this.cantInvestigador>=this.limite ||this.cantMantenimiento>0 || this.cantVisitante>0) {
				System.out.println(Thread.currentThread().getName()+"...............esperando para poder ingresar, Visitantes: "+this.cantVisitante+" ,Mantenimiento: "+this.cantMantenimiento+" ,Investigador: "+this.cantInvestigador);
				this.wait();
			}
			System.out.println(Thread.currentThread().getName()+"...............ingreso al observatorio");
			this.cantInvestigador++;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public synchronized void salirVisitante() {

		this.cantVisitante--;
		System.out.println(Thread.currentThread().getName()+"...............sale del observatorio");
		this.notifyAll();

	}

	public synchronized void salirVisitanteSilla() {
				
		this.cantVisitante=this.cantVisitante-this.espacioSilla;
		System.out.println(Thread.currentThread().getName()+"...............sale del observatorio");
		
		this.cantVisitanteSilla--;
		if (this.cantVisitanteSilla==0) {
			this.limite=this.capacidad;				
			System.out.println("!!!!!!!!!!!!!!!!!!!Cambio limite de capacidad: "+this.limite+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");			
		}
		this.notifyAll();

	}
	
	public synchronized void salirMantenimiento() {

		this.cantMantenimiento--;
		System.out.println(Thread.currentThread().getName()+"...............sale del observatorio");
		this.notifyAll();

	}

	public synchronized void salirInvestigador() {

		this.cantInvestigador--;
		System.out.println(Thread.currentThread().getName()+"...............sale del observatorio");
		this.notifyAll();

	}
	
}
