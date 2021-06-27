package fatura;

import java.util.ArrayList;
import java.util.Iterator;

import boleto.Boleto;

public class Fatura {
	private String data;
	private String nomeCliente;
	private double valorTotal;
	private ArrayList<Boleto> pagamentos;
	private boolean paga;
	
	public Fatura(String d, String nc, double vt) {
		paga = false;
		pagamentos = new ArrayList();
		data = d;
		nomeCliente = nc;
		valorTotal = vt;
	}
	
	public void processaPagamento(ArrayList<Boleto> boletos) {
		pagamentos = boletos;
	}
	
	public boolean estaPaga() {
		double valorTotalPagamentos = 0.0;

		for (Iterator i = pagamentos.iterator(); i.hasNext();) {
			Boleto boleto = (Boleto) i.next();
			valorTotalPagamentos += boleto.getValorPago();
		}
		
		if(valorTotalPagamentos >= valorTotal) {
			return true;
		}
		
		return false;
	}
	
	public int qtdPagamentos() {
		return 3;
	}
	
	
}
