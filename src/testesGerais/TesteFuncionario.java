package testesGerais;

import entidades.Funcionario;
import entidades.IdentificadorDePessoas;

public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("jose", 5000, "jose@gmail", "masculino");
        Funcionario f2 = new Funcionario("fatima", 2000, "fatima@gmail", "feminino");

        System.out.println(f1.getSalario());
        System.out.println(f2.getSalario());

        System.out.println(f1.getSexo());
        System.out.println(f2.getSexo());

        System.out.println(f1.toString());
        System.out.println(f2.toString());

        System.out.println(f1.getSaudacao());
        System.out.println(f2.getSaudacao());

        System.out.println(IdentificadorDePessoas.identificarTipoDePessoa(f1));
        System.out.println(IdentificadorDePessoas.identificarTipoDePessoa(f2));
    }
}
