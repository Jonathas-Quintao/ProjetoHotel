package entidades;

public class Funcionario extends Pessoa {
	private double salario;
	
	
	public Funcionario (String nome, double salario, String email, String sexo){
		super(nome, sexo, email);
		this.salario = salario;
		
	}
	
	public Funcionario(Funcionario funcionario) {
		super(funcionario.getNome(), funcionario.getSexo(), funcionario.getEmail());
		this.salario = funcionario.salario;
		
	}

	public double getSalario(){
		return this.salario;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + getNome() + ", salario=" + getSalario() + ", email= "+ getEmail() + ", sexo=" + getSexo() + " ]";
	}

	@Override
	public String getDescricao() {
		
		return "Essa pessoa é um Funcionário.";
	}
	@Override
	public String getSaudacao() {

		if(getSexo() == "masculino") {
			return "Senhor " + getNome();
		}else {
			return "Senhora " + getNome() ;
		}
	}
	
	
}
