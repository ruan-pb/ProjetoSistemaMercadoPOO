
public class ClientePF extends Cliente {
	private String cpf;
	
	public ClientePF(String nome, String cpf){
		super(nome);
		this.cpf = cpf;
	}
	public String getCodigo(){
		return this.cpf;
	}
	public String getCpf(){
		return this.cpf;
	}
	
	
		
}
	


