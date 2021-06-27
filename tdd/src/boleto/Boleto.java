package boleto;

public class Boleto {
	private String codigo;
	private String data;
	private double valorPago;
	
	public Boleto(String c, String d, double vp) {
		codigo = c;
		data = d;
		valorPago = vp;
	}
	
	public double getValorPago() {
		return valorPago;
	}
}
