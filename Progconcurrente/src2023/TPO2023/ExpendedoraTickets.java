package TPO2023;

public class ExpendedoraTickets {

	private int ticketVendidos;
	
	
	public ExpendedoraTickets() {
		this.setTicketVendidos(0);
	}
	
	public synchronized void vender() {
		this.setTicketVendidos(this.getTicketVendidos() + 1);
		System.out.println("============================================Se vendieron "+this.getTicketVendidos()+" tickets");
	}

	public int getTicketVendidos() {
		return ticketVendidos;
	}

	public void setTicketVendidos(int ticketVendidos) {
		this.ticketVendidos = ticketVendidos;
	}
		
}
