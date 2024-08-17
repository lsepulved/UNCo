package Practico_7;

import java.util.Random;

public class Cocinero implements Runnable{

	private Ingrediente ingrediente;
	private char tipo;
	
	public Cocinero(Ingrediente unIngrediente, char unTipo) {
		this.ingrediente=unIngrediente;
		this.tipo=unTipo;
	}
	
	public void run() {
		Random random=new Random();
		int valor;
		
		switch (tipo) {
		case 'C':
			this.ingrediente.usarCarne();
			this.cocinando();
			this.ingrediente.dejarCarne();
			
			valor=random.nextInt(2);
			if (valor==1) {
				this.ingrediente.usarPasta();
				this.cocinando();
				this.ingrediente.dejarPasta();
			}
			valor=random.nextInt(2);
			if (valor==1) {
				this.ingrediente.usarVegetal();
				this.cocinando();
				this.ingrediente.dejarVegetal();
			}
			
			break;
		case 'V':
			this.ingrediente.usarVegetal();
			this.cocinando();
			this.ingrediente.dejarVegetal();
			
			valor=random.nextInt(2);
			if (valor==1) {
				this.ingrediente.usarPasta();
				this.cocinando();
				this.ingrediente.dejarPasta();
			}
			valor=random.nextInt(2);
			if (valor==1) {
				this.ingrediente.usarCarne();
				this.cocinando();
				this.ingrediente.dejarCarne();
			}
			
			break;
		case 'P':
			this.ingrediente.usarPasta();
			this.cocinando();
			this.ingrediente.dejarPasta();
			
			valor=random.nextInt(2);
			if (valor==1) {
				this.ingrediente.usarCarne();
				this.cocinando();
				this.ingrediente.dejarCarne();
			}
			valor=random.nextInt(2);
			if (valor==1) {
				this.ingrediente.usarVegetal();
				this.cocinando();
				this.ingrediente.dejarVegetal();
			}
			
			break;

		default:
			break;
		}
	}
	
	public void cocinando() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
