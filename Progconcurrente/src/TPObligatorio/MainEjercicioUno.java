package TPObligatorio;

public class MainEjercicioUno {

		public static void main(String args[]){
			int cantidadAutos=23;
			int cantidadEspacios=10;
			Transbordador transbordador=new Transbordador(cantidadEspacios);
			
			ControlTransbordador control=new ControlTransbordador(transbordador);
			
			Thread [] autos= new Thread[cantidadAutos];
			
			Thread hiloControl=new Thread(control,"Control");
			hiloControl.start();
			
			for (int i=0;i<cantidadAutos;i++) {
				Auto unAuto=new Auto(transbordador);
				autos[i]= new Thread(unAuto,"Auto "+i);
				autos[i].start();
			}
		}
}
