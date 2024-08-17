package Practico_3;

public class Auto extends Vehiculo {

	private UsarSurtidor usaSurtidor;
	
	public Auto(String unaPatente, int unModelo, String unaMarca, int unKm, UsarSurtidor usaUnSurtidor) {
		super(unaPatente, unModelo, unaMarca, unKm);
		this.usaSurtidor=usaUnSurtidor;

	}
	
	public UsarSurtidor getUsaSurtidor() {
		return this.usaSurtidor;
	}
}
