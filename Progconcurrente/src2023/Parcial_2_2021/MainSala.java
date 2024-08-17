package Parcial_2_2021;

public class MainSala {

	public static void main (String[] args) {
		
		int cantParejas=10;
		int cantBailarinSolo=10;
		
		
		Sala sala=new Sala();
		
		for (int i=0;i<cantBailarinSolo;i++) {
			BailarinSolo unBailarinSolo=new BailarinSolo(sala);
			Thread hiloBailarinSolo=new Thread(unBailarinSolo,"BailarinSolo"+i);
			hiloBailarinSolo.start();
		}
		
		for (int i=0;i<cantParejas;i++) {
			BailarinPareja unBailarinPareja=new BailarinPareja(sala);
			Thread hiloBailarinPareja=new Thread(unBailarinPareja,"BailarinPareja"+i);
			hiloBailarinPareja.start();
		}
		
	}
}
