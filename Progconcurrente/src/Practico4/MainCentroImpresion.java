package Practico4;

public class MainCentroImpresion {

	public static void main (String[]args) {

		int cantUsuariosA=5;
		int cantUsuariosB=5;
		int cantUsuariosX=5;
		
		int cantImpresorasA=3;
		int cantImpresorasB=2;
		
		CentroImpresion centro=new CentroImpresion(cantImpresorasA,cantImpresorasB);
		
		Thread[] usuariosA= new Thread[cantUsuariosA]; 
		Thread[] usuariosB= new Thread[cantUsuariosB];
		Thread[] usuariosX= new Thread[cantUsuariosX];
		
		for (int i=0;i<cantUsuariosA;i++) {
			Usuario usuA= new Usuario(centro, 'A');
			usuariosA[i]=new Thread(usuA,"UsuarioA "+i);
			usuariosA[i].start();
		}

		for (int i=0;i<cantUsuariosB;i++) {
			Usuario usuB= new Usuario(centro, 'B');
			usuariosB[i]=new Thread(usuB,"UsuarioB "+i);
			usuariosB[i].start();
		}

		for (int i=0;i<cantUsuariosX;i++) {
			Usuario usuX= new Usuario(centro, 'X');
			usuariosX[i]=new Thread(usuX,"UsuarioX "+i);
			usuariosX[i].start();
		}
		
	}
}
