package src.testesGerais;

import java.time.LocalDate;

import Exceptions.ExceptionDate;
import Exceptions.ExceptionDateNull;
import entidades.*;

public class TesteHospedagem {

	public static void main(String[] args) {
		Funcionario f1 = new Funcionario("jose", 5000, "jose@gmail", "masculino");
		Hospede h1 = new Hospede("jonathas", LocalDate.of(2002,11,11),  "email@ja.com", "masculino");
		Hospede h2 = new Hospede("joaquim", LocalDate.of(2002,11,11),  "email@ja.com", "masculino");
		Hospede h3 = new Hospede("zeca", LocalDate.of(2002,11,11),  "email@ja.com", "masculino");
		Aposento a1 = new Aposento(21, "suite", 5000);
		Aposento a3 = new Aposento(21, "suite", 10000);
		Aposento a2 = new Aposento(21, "suite", 100);
		Consumo c1 = new Consumo("cerveja", 17);
		Consumo c2 = new Consumo("bombom", 5);
		Consumo c3 = new Consumo("refri", 12);
		
		Hospedagem hosp1 = new Hospedagem(f1,h1,a1,LocalDate.of(2022, 04, 14));

		Hospedagem hosp3 = new Hospedagem(f1,h3,a3,LocalDate.of(2022, 04, 14));

		Hospedagem hosp2 = new Hospedagem(f1,h2,a2,LocalDate.of(2022, 3, 11));

		hosp1.addConsumo(c1);
		hosp1.addConsumo(c2);
		hosp1.addConsumo(c3);

		hosp2.addConsumo(c1);
		hosp2.addConsumo(c2);
		hosp2.addConsumo(c3);

		hosp2.removeConsumo(c2);

		System.out.println(hosp1.getFuncionario());
		System.out.println(hosp2.getFuncionario());

		System.out.println(hosp1.getAposento());
		System.out.println(hosp2.getAposento());

		System.out.println(hosp1.getHospede());
		System.out.println(hosp2.getHospede());

		System.out.println(hosp1.getCodigo());
		System.out.println(hosp2.getCodigo());



		System.out.println(hosp1.getDataDeEntrada());
		System.out.println(hosp2.getDataDeEntrada());

		System.out.println(hosp1.getFuncionario());
		System.out.println(hosp2.getFuncionario());

		System.out.println(hosp1.getListaConsumo());
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);
		System.out.println(hosp2.getListaConsumo());
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);

		hosp1.getConsumo("CONS1");
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);
		hosp2.getConsumo("CONS2");
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);

		hosp1.getConsumoPreco();
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);
		hosp2.getConsumoPreco();
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);
		hosp1.getConsumoCrescente();
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);
		hosp2.getConsumoDecrescente();
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);



		
		
		
		try {
			hosp1.setDataSaida(LocalDate.of(2022, 04, 19));
		} catch (ExceptionDate e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try {
			hosp3.setDataSaida(LocalDate.of(2022, 04, 18));
		} catch (ExceptionDate e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			hosp2.setDataSaida(LocalDate.of(2022, 04, 18));
		} catch (ExceptionDate e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.println(hosp1.getDataSaida());
		System.out.println(hosp2.getDataSaida());

		try {
			System.out.println(hosp1.valorDaConta());
		} catch (ExceptionDateNull e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			System.out.println(hosp2.valorDaConta());
		} catch (ExceptionDateNull e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			System.out.println(hosp3.valorDaConta());
		} catch (ExceptionDateNull e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);
		hosp1.getCategoria();
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);
		hosp2.getCategoria();
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);
		hosp3.getCategoria();
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);

		System.out.println(h1.getQuantidadeGasta());
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);
		System.out.println(h2.getQuantidadeGasta());
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);
		System.out.println(h3.getQuantidadeGasta());
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);


		try {
			hosp1.getRecibo();
		} catch (ExceptionDateNull e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);

		Historico<Hospedagem> historicoHospedagem = new Historico<>();

		historicoHospedagem.addLista(hosp1);
		System.out.println(Historico.faturamentoTotal(historicoHospedagem));
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);

		try {
			System.out.println(historicoHospedagem.listarHospedesEGastos());
		} catch (ExceptionDateNull e) {
			throw new RuntimeException(e);
		}

		historicoHospedagem.addLista(hosp2);
		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);


		try {
			System.out.println(historicoHospedagem.listarHospedesEGastos());
		} catch (ExceptionDateNull e) {
			throw new RuntimeException(e);
		}

		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);
		System.out.println(Historico.faturamentoTotal(historicoHospedagem));

		System.out.println(
				"-------------------------------------------------------------------------------------------------"
		);

		historicoHospedagem.removeLista(hosp1);



		try {
			System.out.println(historicoHospedagem.listarHospedesEGastos());
		} catch (ExceptionDateNull e) {
			throw new RuntimeException(e);
		}




	}

}
