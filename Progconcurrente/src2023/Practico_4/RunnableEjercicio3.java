package Practico_4;

public class RunnableEjercicio3 implements Runnable {

	RecursoEjercicio3 recurso;
	
	public RunnableEjercicio3(RecursoEjercicio3 unRecurso) {
		this.recurso=unRecurso;
	}
	
	public void run() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		while (i<10) {
//			System.out.println(Thread.currentThread().getName() + " entro al P1");
			this.recurso.P1();
//			System.out.println(Thread.currentThread().getName() + " entro al P3");			
			this.recurso.P3();			
//			System.out.println(Thread.currentThread().getName() + " entro al P2");			
			this.recurso.P2();
//		}
	}
}
