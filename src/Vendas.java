
public class Vendas  {
	private double atacado;
	private double venda;
	private double lucro;
	
	
	public Vendas(){
		this.atacado = 0.00;
		this.venda = 0.00;
		this.lucro = 0.00;
	}
	
	public Vendas (double vendido, double comprado){
		this.lucro = vendido - comprado;
		
	}
	public double getAtacado(){
		return this.atacado;
	}
	public void setAtacado(double valorNovo){
		this.atacado = valorNovo;
	}
	public double getVenda(){
		return this.venda;
	}
	public void setVenda(double NovoValor){
		this.venda = NovoValor;
	}
	public double getLucro(){
		return this.lucro;
	}
	public void setLucro(double novoValor){
		this.lucro = novoValor;
	}
	public String toString(){
		return "o lucro foi de "+this.getLucro();
	}

}
