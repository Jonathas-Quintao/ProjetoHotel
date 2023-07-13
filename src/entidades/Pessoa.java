package entidades;

public abstract class Pessoa {
	private String nome;
	private String sexo;
	private String email;
	
	
	public Pessoa (String nome, String sexo, String email) {
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
	}
	
	public abstract String getDescricao();
	public abstract String getSaudacao();
	

	public String getSexo() {
		if(this.sexo == "masculino") {
			
			return this.sexo;
		}
		return this.sexo = "feminino";
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getEmail() {
		return this.email;
	}


}
