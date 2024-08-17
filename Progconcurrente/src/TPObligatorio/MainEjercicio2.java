package TPObligatorio;

public class MainEjercicio2 {

	public static void main(String args[]){
		
		
		Espacio espacio=new Espacio();
		Recipiente recipiente= new Recipiente(2);
		
		GeneradorAtomo generador= new GeneradorAtomo(espacio);
		Thread hiloGenerador= new Thread(generador, "Generador");
		
		ConsumidorAgua consumidor= new ConsumidorAgua(espacio,recipiente);		
		Thread hiloConsumidor= new Thread(consumidor,"Consumidor");
		
		hiloGenerador.start();
		hiloConsumidor.start();
	}
}
