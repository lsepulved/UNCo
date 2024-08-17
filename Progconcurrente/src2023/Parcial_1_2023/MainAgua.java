package Parcial_1_2023;

public class MainAgua {

	public static void main(String[] args) {
		
		int limiteRecipiente=10;
		Espacio espacio=new Espacio(limiteRecipiente);
		
		int cantOxigenos=10;
		int cantHidrogenos=20;
		
		for (int i=0;i<cantOxigenos;i++) {
			Oxigeno unOxigeno=new Oxigeno(espacio);
			Thread hiloOxigeno=new Thread(unOxigeno, "Oxigeno"+i);
			hiloOxigeno.start();
		}
		
		for (int i=0;i<cantHidrogenos;i++) {
			Hidrogeno unHidrogeno=new Hidrogeno(espacio);
			Thread hiloHidrogeno=new Thread(unHidrogeno, "Hidrogeno"+i);
			hiloHidrogeno.start();
		}
		
	}
}
