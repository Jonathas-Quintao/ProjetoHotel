package entidades;

public class Consumo implements Comparable<Consumo> {
	private String produto;
	private double preco;
	private String codigo;
	static int contador = 0;
	
	public Consumo(String produto, double preco){
		this.produto = produto;
		this.preco = preco;
		Consumo.contador++;
		this.codigo="CONS" + Consumo.contador;
		
	}
	
	public Consumo() {
		
	}
	
	
	public String getProduto() {
		return this.produto;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public String setCodigo(String codigo) {
		return this.codigo = codigo;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Consumo)) {
			return false;
		}
		if(obj == this) {
			return true;
		}
		Consumo c = (Consumo) obj;
		if(c.codigo.equals(this.codigo)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "[produto=" + produto + ", preco=" + preco + ", Codigo= " + codigo +"]";
	}

	@Override
	public int compareTo(Consumo outroConsumo) {
		return this.produto.compareTo(outroConsumo.getProduto());
	}
}
