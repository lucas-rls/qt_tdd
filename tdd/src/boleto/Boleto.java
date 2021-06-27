package boleto;

public class Boleto {
	private String codigo;
	private String data;
	private float valorPago;
	
	public Boleto(String codigo, String data, float valorPago) {
		codigo = codigo;
		data = data;
		valorPago = valorPago;
	}
}
