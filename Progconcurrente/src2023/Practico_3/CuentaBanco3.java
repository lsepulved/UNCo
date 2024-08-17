package Practico_3;

public class CuentaBanco3 {
	
	private int balance = 50;
	
	public CuentaBanco3(){
	}
	
	public int getBalance(){
		return balance;
	}
	
	public synchronized boolean retiroBancario(int retiro){
		boolean band=false;
		if (retiro<=balance) {
			balance = balance - retiro;
			band=true;
		}
		return band;
	}
	
}
