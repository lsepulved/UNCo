package Practico_5;

public class Responsable implements Runnable{

	Tobogan tobogan;
	
	public Responsable(Tobogan unTobogan) {
		this.tobogan=unTobogan;
	}
	
	public void run() {
		while (true) {
			this.tobogan.eligeTobogan();
		}
	}
}
