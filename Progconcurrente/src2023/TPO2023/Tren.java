package TPO2023;

import java.util.concurrent.Semaphore;

public class Tren {
	
//    public void subirPasajero() {
//        try {
//            subiendo.acquire();
//
//            if (ocupacion < capacidad) {
//                ocupacion++;
//                System.out.println("Pasajero subido: " + Thread.currentThread().getName());
//                subiendo.release();
//            } else {
//                viajando.release();
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public void bajarPasajero() {
//
//        try {
//            bajando.acquire();
//            if (ocupacion > 0) {
//                ocupacion--;
//                System.out.println("Pasajero bajando:" + Thread.currentThread().getName());
//                bajando.release();
//            } else {
//                subiendo.release();
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
	private int capacidad;
	private int ocupacion;
	
	private Semaphore subir=new Semaphore(1);
	private Semaphore bajar=new Semaphore(0);
	private Semaphore viajando=new Semaphore(0);
	
	public Tren(int unaCapacidad) {
		this.capacidad=unaCapacidad;
		this.ocupacion=0;
	}
	
	public boolean subirTren() {
		boolean exito=false;
		try {
			this.subir.acquire();
			
			if (this.ocupacion<this.capacidad) {
				this.ocupacion++;
				exito=true;
				System.out.println(Thread.currentThread().getName()+" subio al Tren, ocupacion: "+this.ocupacion);
				
				if (this.ocupacion==this.capacidad) {
					this.viajando.release();	
				}else {
					this.subir.release();
				}										
//			}else {
		}	
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exito;
	}
	
	
	public void iniciarViaje() {
		try {
			this.viajando.acquire();
			System.out.println(Thread.currentThread().getName()+ " inicia viaje");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void finalizarViaje() {
		System.out.println(Thread.currentThread().getName()+ " =======Finaliza viaje==========");
		this.bajar.release();
	}

	public boolean bajarTren() {
		boolean exito=false;
		try {
			this.bajar.acquire();
			if (this.ocupacion>0) {
				this.ocupacion--;
				exito=true;
				System.out.println(Thread.currentThread().getName()+" bajo del Tren, ocupacion actual: "+this.ocupacion);
				if (this.ocupacion==0) {
					System.out.println(" =========TREN LISTO=========");
					this.subir.release();					
				}else {
					this.bajar.release();	
				}							
//			}else {
//				System.out.println(" =========TREN LISTO=========");
//				this.subir.release();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exito;		
	}	

}
