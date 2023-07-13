package entidades;

public class Aposento {
	private int quarto;
	private String tipoDeQuarto;
	private double preco;
	private String codigo;
	private static int contador=0;
	
	
	
	public Aposento(int quarto, String tipoDeQuarto, double preco){
		this.quarto = quarto;
		this.tipoDeQuarto = tipoDeQuarto;
		this.preco = preco;
		Aposento.contador++;
		this.codigo = "AP"+ Aposento.contador;
		
		
	}
	
	public Aposento() {
		
	}
	
 	public Aposento(Aposento aposento) {
        this.quarto = aposento.quarto;
        this.tipoDeQuarto = aposento.tipoDeQuarto;
        this.preco = aposento.preco;
        this.codigo = aposento.codigo;
    }

	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getPreco(){
		return this.preco;
	}

	public String getCodigo(){
		return this.codigo;
	}

	public String getTipoDeQuarto(){
		return this.tipoDeQuarto;
	}
	
	
	
	public int getQuarto() {
		return this.quarto;
	}




	@Override
	public String toString() {
		return "Aposento [quarto=" + getQuarto() + ", tipoDeQuarto=" + getTipoDeQuarto() + ", preco=" + getPreco() + " Apartamento=" + getCodigo() + "]" ;
	}




	
	
	
	
}
