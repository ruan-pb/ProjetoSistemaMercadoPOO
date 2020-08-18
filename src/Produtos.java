
public class Produtos {
	private String codigo;
	private String nome;
	private double precoAtacado;
	private double precoVenda;
	
	public Produtos(){
		this.codigo = "";
		this.nome = "";
		this.precoAtacado = 0.00;
		this.precoVenda = 0.00;
	
	}
	public Produtos(String codigo, String nome, double precoAtacado,double precoVenda){
		this.codigo = codigo;
		this.nome = nome;
		this.precoAtacado = precoAtacado;
		this.precoVenda = precoVenda;
	}
	public Produtos(double precoAtacado,double precoVenda){
		this.precoAtacado = precoAtacado;
		this.precoVenda = precoVenda;
	}
	
	
	public String getCodigo(){
		return this.codigo;
	}
	public void setCodigo(String novoCodigo){
		this.codigo = novoCodigo;
	}
	public String getNome(){
		return this.nome;
	}
	public void setNome(String novoNome){
		this.nome = novoNome;
	}
	public double getPrecoAtacado(){
		return this.precoAtacado;
	}
	public void setPrecoAtacado(double novoValor){
		this.precoAtacado = novoValor;
	}
	public double getPrecoVenda(){
		return this.precoVenda;
	}
	public void setPrevoVenda(double novoValor){
		this.precoVenda = novoValor;
	}
	public String toString(){
		return "Codigo do produto "+this.codigo+"\n Produto de nome "+this.nome+"Ele foi Comprado a preço de atacado por "+this.precoAtacado+" e Vendido a preço de "+this.precoVenda;
	}
	public double RelatorioVenda(double precoAtacado, double precoVenda){
		double lucro = precoAtacado-precoVenda;
		return lucro;
		
		
	}

}
