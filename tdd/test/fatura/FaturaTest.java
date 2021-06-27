package fatura;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import boleto.Boleto;

public class FaturaTest {
	Fatura fatura;
	ArrayList<Boleto> boletos;
	
	@Test
	public void testProcessamento1() {
		fatura = new Fatura("27/06/2021", "Lucas", 1500.00);
		Boleto boleto1 = new Boleto("123", "27/06/2021", 500.00);
		Boleto boleto2 = new Boleto("124", "27/06/2021", 400.00);
		Boleto boleto3 = new Boleto("125", "27/06/2021", 600.00);
		boletos = new ArrayList();
		boletos.add(boleto1);
		boletos.add(boleto2);
		boletos.add(boleto3);
		
		
		fatura.processaPagamento(boletos);
		
		assertAll("processamento1",
				() -> assertTrue(fatura.estaPaga()),
				() -> assertEquals(3, fatura.qtdPagamentos())
				);
	}
	
	@Test
	public void testProcessamento2() {
		fatura = new Fatura("27/06/2021", "Lucas", 1500.00);
		Boleto boleto1 = new Boleto("123", "27/06/2021", 100.00);
		Boleto boleto2 = new Boleto("124", "27/06/2021", 500.00);
		Boleto boleto3 = new Boleto("125", "27/06/2021", 250.00);
		boletos = new ArrayList();
		boletos.add(boleto1);
		boletos.add(boleto2);
		boletos.add(boleto3);
		
		fatura.processaPagamento(boletos);
		
		assertAll("processamento2",
				() -> assertFalse(fatura.estaPaga()),
				() -> assertEquals(3, fatura.qtdPagamentos())
				);
	}
	
	@Test
	public void testProcessamento3() {
		fatura = new Fatura("27/06/2021", "Lucas", 2000.00);
		Boleto boleto1 = new Boleto("123", "27/06/2021", 500.00);
		Boleto boleto2 = new Boleto("124", "27/06/2021", 400.00);
		boletos = new ArrayList();
		boletos.add(boleto1);
		boletos.add(boleto2);
		
		fatura.processaPagamento(boletos);
		
		assertAll("processamento3",
				() -> assertFalse(fatura.estaPaga()),
				() -> assertEquals(2, fatura.qtdPagamentos())
				);
	}
}
