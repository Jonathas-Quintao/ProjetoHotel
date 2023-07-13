package testesGerais;

import java.time.LocalDate;
import java.util.ArrayList;

import entidades.Funcionario;
import entidades.Hospede;
import entidades.IdentificadorDePessoas;

public class TesteHospede {

	public static void main(String[] args) {
		Hospede h1 = new Hospede("jonathas",LocalDate.of(2002,11,11), "jonathas@gmail.com","masculino");
		Hospede h2 = new Hospede("julia",LocalDate.of(2008,9,19), "julia@gmail.com","feminino");

		System.out.println(h1.getDataDeNascimento());
		System.out.println(h2.getDataDeNascimento());

		System.out.println(h1.getSaudacao());
		System.out.println(h2.getSaudacao());

		System.out.println(h1.getQuantidadeGasta());
		System.out.println(h2.getQuantidadeGasta());

		System.out.println(h1.toString());
		System.out.println(h2.toString());



		System.out.println(IdentificadorDePessoas.identificarTipoDePessoa(h1));
		System.out.println(IdentificadorDePessoas.identificarTipoDePessoa(h2));

	}
}
