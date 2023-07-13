package entidades;


import java.time.LocalDate;


public class Hospede extends Pessoa {

	private LocalDate dataDeNascimento;
	private double quantidadeGasta = 0;
	
	
	public Hospede(String nome, LocalDate dataDeNascimento, String email, String sexo ){
		
		super(nome, sexo, email);
		
		this.dataDeNascimento = dataDeNascimento;
		
	}
	
	public Hospede(Hospede hospede) {
		super(hospede.getNome(), hospede.getSexo(), hospede.getEmail());
		
		this.dataDeNascimento = hospede.dataDeNascimento;
		
	}

	public LocalDate getDataDeNascimento() {
		return this.dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	@Override
	public String getSaudacao() {
		
		if(getSexo() == "masculino") {
			return "Prezado hóspede " + getNome();
		}else {
			return "Prezada hóspede " + getNome() ;
		}
	}

	public void setQuantidadeGasta(double valor){
		this.quantidadeGasta = this.quantidadeGasta + valor;

	}

	public double getQuantidadeGasta(){
		return this.quantidadeGasta;
	}

	public String getCategoria() {
		if(this.quantidadeGasta>=30000){
			return "categoria A";
		} else if (this.quantidadeGasta > 10000 && this.quantidadeGasta <30000) {
			return "categoria B";
		}else{
			return "categoria C";
		}

	}


	@Override
	public String toString() {

		return "Hospede [nome=" + getNome() + ", dataDeNascimento=" + getDataDeNascimento() +  ", saudacao: " + getSaudacao() + ", sexo: " + getSexo() +  ", email= "+ getEmail() + "]";
	}

	@Override
	public String getDescricao() {
		return "Essa pessoa é um Hóspede.";
	}

	
	
}
