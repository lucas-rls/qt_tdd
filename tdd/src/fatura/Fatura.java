package fatura;

import java.util.ArrayList;

import boleto.Boleto;

public class Fatura {
	private String data;
	private String nomeCliente;
	private float valorTotal;
	private ArrayList<Boleto> pagamentos;
	private boolean paga;
	
	public Fatura(String data, String nomeCliente, float valorTotal) {
		paga = false;
		pagamentos = new ArrayList();
		data = data;
		nomeCliente = nomeCliente;
		valorTotal = valorTotal;
	}
	
	
}
