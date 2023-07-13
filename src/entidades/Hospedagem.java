package entidades;

import java.time.LocalDate;
import java.util.*;

import Exceptions.ExceptionDate;
import Exceptions.ExceptionDateNull;

public class Hospedagem {
	private Funcionario funcionario;
	private Hospede hospede;
	private Aposento aposento;
	private LocalDate dataDeEntrada;
	private LocalDate dataDeSaida;
	private ListaGenerica<Consumo> listaDeConsumo;
	private static int ano;
	private static int contador = 1;
	private String codigo;

	public Hospedagem(Funcionario funcionario, Hospede hospede, Aposento aposento, LocalDate dataDeEntrada) {
		super();
		this.funcionario = funcionario;
		this.hospede = hospede;
		this.aposento = aposento;
		this.dataDeEntrada = dataDeEntrada;
		listaDeConsumo = new ListaGenerica<>();

		if (Hospedagem.ano == this.dataDeEntrada.getYear()) {
			Hospedagem.contador++;
		} else {
			Hospedagem.contador = 1;
		}
		Hospedagem.ano = this.dataDeEntrada.getYear();
		this.codigo = Hospedagem.ano + "-" + Hospedagem.contador;
	}
	
	public Funcionario getFuncionario() {
        return new Funcionario(funcionario);
    }

    public Hospede getHospede() {
        return new Hospede(hospede);
    }

    public Aposento getAposento() {
        return new Aposento(this.aposento);
    }

	public String getCodigo() {
		return codigo;
	}
	
	public LocalDate getDataSaida() {
		return this.dataDeSaida;
	}

	public LocalDate getDataDeEntrada(){
		return this.dataDeEntrada;
	}
	
	public void setDataSaida(LocalDate dataSaida) throws ExceptionDate {
		if(dataSaida.isBefore(this.dataDeEntrada)) {
			throw new ExceptionDate("A data de saída é menor que a data de entrada.");
		}
		this.dataDeSaida = dataSaida;
	}
	
	public void addConsumo(Consumo elemento) {
		this.listaDeConsumo.addLista(elemento);

	}

	public void removeConsumo(Consumo elemento) {
		this.listaDeConsumo.removeLista(elemento);

	}

	public ListaGenerica<Consumo> getListaConsumo(){
		return this.listaDeConsumo;
	}

	public void getConsumo(String codigo) {

		boolean consumido = false;

		for (Consumo consumo : listaDeConsumo) {
			if (consumo.getCodigo().equals(codigo)) {
				consumido = true;
				break;
			}
		}

		if (consumido) {
			System.out.println("O hospede consumiu o produto.");
		} else {
			System.out.println("O hospede nao consumiu o produto.");
		}
	} // vai procurar o consumo com base no codigo do alimento.
	
	public void getConsumoPreco() {
		Collections.sort(listaDeConsumo, new Comparator <Consumo>(){
			public int compare(Consumo c1, Consumo c2) {
				return Double.compare(c1.getPreco(), c2.getPreco());
			}
		});
		
		for (Consumo consumo : listaDeConsumo) {
            System.out.println(consumo);
        }
	}
	
	public void getConsumoCrescente() {
		Collections.sort(listaDeConsumo, new Comparator <Consumo>(){
			public int compare(Consumo c1, Consumo c2) {
				return c1.getProduto().compareTo(c2.getProduto());
			}
		});
		
		for (Consumo consumo : listaDeConsumo) {
            System.out.println(consumo);
        }
	}
	
	public void getConsumoDecrescente() {
		Collections.sort(listaDeConsumo, new Comparator <Consumo>(){
			public int compare(Consumo c1, Consumo c2) {
				return c2.getProduto().compareTo(c1.getProduto());
			}
		});
		
		for (Consumo consumo : listaDeConsumo) {
            System.out.println(consumo);
        }
	}

	public void getCategoria(){
		if(hospede.getQuantidadeGasta() >= 30000){
			Map<String, String> categoria = new HashMap<>();
			categoria.put(hospede.getNome(), "Categoria A");
			System.out.println(categoria);
		}else if(hospede.getQuantidadeGasta() > 10000 && hospede.getQuantidadeGasta() < 30000){
			Map<String, String> categoria = new HashMap<>();
			categoria.put(hospede.getNome(), "Categoria B");
			System.out.println(categoria);
		}
		else {
			Map<String, String> categoria = new HashMap<>();
			categoria.put(hospede.getNome(), "Categoria C");
			System.out.println(categoria);
		}
	}

	public double valorDaConta() throws ExceptionDateNull {
		if(this.dataDeSaida == null ) {
			throw new ExceptionDateNull("Não foi cadastrada uma nova data de saída");
		}
		
		double total = 0;
		double diaria = 0;
		double precoDaDiaria = aposento.getPreco();
		
		for (Consumo consumo : this.listaDeConsumo) {
			total += consumo.getPreco();
		}
		diaria = this.dataDeSaida.getDayOfMonth() - this.dataDeEntrada.getDayOfMonth();

		total = total + (diaria * precoDaDiaria);
		this.hospede.setQuantidadeGasta(total);
		return total;
	}
	
	public void getRecibo() throws ExceptionDateNull {
		double diaria = this.dataDeSaida.getDayOfMonth() - this.dataDeEntrada.getDayOfMonth();
		System.out.println("Quarto: " + aposento.getQuarto() + "\nFuncionário: " + funcionario.getNome() + "\nData de Entrada : " + this.dataDeEntrada
	+ "\nData de Saída: " + getDataSaida() + "\nDiárias: " + diaria + "\nValor da Hospedagem: " + valorDaConta() + "\nLista de Consumo : " + getListaConsumo() );
	}
	

	@Override
	public String toString() {
		return "[Codigo de hospedagem: " + getCodigo() + ", Hospedagem funcionario=" + funcionario.getNome() + ", hospede="
				+ hospede.getNome() + ", aposento=" + aposento.getQuarto() + ", dataDeEntrada=" + dataDeEntrada
				+ ", dataDeSaida=" + getDataSaida() + ", listaDeConsumo=" + getListaConsumo() + "]";
	}

}
