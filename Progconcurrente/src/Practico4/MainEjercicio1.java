package Practico4;

public class MainEjercicio1 {

		public static void main (String[] args) {
		
//			SynchronizedCounter contador1=new SynchronizedCounter();
			
			SynchronizedObjectCounter contador1=new SynchronizedObjectCounter();
			
			SumadorObject sumador1=new SumadorObject(contador1);
			SumadorObject sumador2=new SumadorObject(contador1);

			Thread hilo1=new Thread(sumador1,"Hilo 1");
			Thread hilo2=new Thread(sumador2,"Hilo 2");

			hilo1.start();
			hilo2.start();
		}
}
