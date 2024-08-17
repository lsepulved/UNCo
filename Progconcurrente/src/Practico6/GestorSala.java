package Practico6;

public class GestorSala {

	private int temperatura;
	private int tUmbral;
	private int personasDentro;
	private int jubiEsperando;
	private int cantPersonas;
	
	public GestorSala() {
		this.temperatura=0;
		this.tUmbral=30;
		this.personasDentro=0;
		this.jubiEsperando=0;
		this.cantPersonas=0;
	}
	
	//persona
	public synchronized void entrarSala() {
		while (this.personasDentro>=this.cantPersonas && this.jubiEsperando>0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.personasDentro++;
		System.out.println("entro persona, Personas Dentro: "+this.personasDentro);
	}
	
	//jubilado
	public synchronized void entrarSalaJubilado() {
		while (this.personasDentro>=this.cantPersonas) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.jubiEsperando--;
		System.out.println("Quedan jubilados esperando: "+this.jubiEsperando);
		this.cantPersonas++;
		System.out.println("Personas Dentro: "+this.personasDentro);
	}
	
	//jubilado
	public synchronized void esperarJubilado() {
		this.jubiEsperando++;
		System.out.println("Jubilados esperando: "+this.jubiEsperando);
	}
	
	//persona
	public synchronized void SalirSala() {
		this.personasDentro--;
		System.out.println("Sale de la sala, quedan Personas Dentro: "+this.personasDentro);
		this.notifyAll();
	}
	
	//controlTemperatura
	public void notificarTemperatura(int medicion) {
		this.temperatura=medicion;
		if (this.temperatura>this.tUmbral) {
			this.cantPersonas=5;
		}else {
			this.cantPersonas=10;
		}
		
		System.out.println("=====Temperatura Actual: "+this.temperatura +" Capacidad Museo: "+this.cantPersonas);
	}
	
}
