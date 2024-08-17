package Practico_6;

public class Ferry {
		
	private int cantEspacios;
	private int cantCruzando;
	private int limite;
	private int espacioAuto;
	
	public Ferry(int unLimite,int unEspacioAuto) {
		this.limite=unLimite;
		this.espacioAuto=unEspacioAuto;	
		
		this.cantEspacios=0;
		this.cantCruzando=0;
				
	}
	
	public synchronized void subirPersonaFerry() {
			
		try {
			while (this.cantEspacios>=this.limite ) {
				System.out.println("----"+Thread.currentThread().getName()+" no puede subir, debe esperar");
				this.wait();	
			}
			
			this.cantEspacios++;
			this.cantCruzando++;			
			
			System.out.println(Thread.currentThread().getName()+" ..................................subio al Ferry, Espacios: "+this.cantEspacios);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		public synchronized void subirAutoFerry() {
						
			try {
				while (this.cantEspacios>=this.limite) {
					System.out.println("----"+Thread.currentThread().getName()+" no puede subir, debe esperar");
					this.wait();	
				}
				
				this.cantEspacios=this.cantEspacios+this.espacioAuto;
				this.cantCruzando=this.cantCruzando+this.espacioAuto;

				
				System.out.println(Thread.currentThread().getName()+" ..................................subio al Ferry, Espacios: "+this.cantEspacios);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		public synchronized void salirPersonaFerry() {
			
			this.cantCruzando--;
						
			System.out.println(Thread.currentThread().getName()+" ..................................se baja del Ferry, cruzando: "+this.cantCruzando);
			if (this.cantCruzando==0) {
				System.out.println("---------FERRY .................llego a destino, se pueden subir");			
				this.cantEspacios=0;
			}
				
			this.notifyAll();
			
		}

		public synchronized void salirAutoFerry() {
			
			this.cantCruzando=this.cantCruzando-this.espacioAuto;
					
			System.out.println(Thread.currentThread().getName()+" ..................................se baja del Ferry, cruzando "+this.cantCruzando);
			
			if (this.cantCruzando==0) {
				System.out.println("---------FERRY .................llego a destino, se pueden subir");
//				this.viajando=true;
				this.cantEspacios=0;
			}
			this.notifyAll();
			
		}
		
}
