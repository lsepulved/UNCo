package Practico_3;

public class Hamster implements Runnable{
	private Plato plato;
	private Rueda rueda;
	private Hamaca hamaca;
	
	public Hamster(Plato unPlato, Rueda unaRueda, Hamaca unaHamaca) {
		this.plato=unPlato;
		this.rueda=unaRueda;
		this.hamaca=unaHamaca;
	}
	
	public void run() {
		while (true) {
			
			if (this.plato.usarPlato()) {
				System.out.println(Thread.currentThread().getName() + " esta comiendo");
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.plato.dejarPlato();
				System.out.println(Thread.currentThread().getName() + " dejo de comer");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				if (this.rueda.usarRueda()) {
					System.out.println(Thread.currentThread().getName()+" esta ejercitando");
					try {
						Thread.sleep(2500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					this.rueda.dejarRueda();
					System.out.println(Thread.currentThread().getName() + " dejo la rueda");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					if (this.hamaca.usarHamaca()) {
						System.out.println(Thread.currentThread().getName()+" esta descansando");
						try {
							Thread.sleep(2500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.hamaca.dejarHamaca();
						System.out.println(Thread.currentThread().getName() + " dejo la hamaca");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else {
						
						System.out.println(Thread.currentThread().getName()+" todo ocupado, espero para volver a intentar");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
					
			}
			
		}
	}
}
