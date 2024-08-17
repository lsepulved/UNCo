package Practico_4;

import java.util.Random;

public class MainImpresoras {

	public static void main (String[] args){
		
		int cantImpresoras=5;
		GestorImpresoras unGestor=new GestorImpresoras(cantImpresoras);

		Random random=new Random();
		int valor;
		char unTipo;
				
		for (int i=0;i<cantImpresoras;i++) {
			
			valor=random.nextInt(3)+1;
			switch (valor) {
			case 1:
				unTipo='A';
				break;
			case 2:
				unTipo='B';
				break;
				
			default:
				unTipo='X';
				break;
			}
			
			Cliente unCliente=new Cliente(unGestor,unTipo);
			Thread hilo=new Thread(unCliente, "Cliente "+i);
			hilo.start();
		}
	}
}
