import java.util.List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class SisMercadoLCC implements SisMercado {
	private List<Usuario> usuario;
	private List<Produtos> ListaProdutos;
	private List<Cliente> cliente;
	private List<Vendas> vendas;
	private GravadorDeDadosMercadinho gravador;
	private List<ClientePF> clientePf;
	private List<ClientePJ> clientePj;
	
	
	public SisMercadoLCC(){
		this.cliente = new ArrayList<Cliente>();
		this.vendas = new ArrayList<Vendas>();
		this.usuario = new ArrayList<Usuario>();
		this.gravador = new GravadorDeDadosMercadinho();
		this.clientePf = new ArrayList<ClientePF>();
		this.clientePj = new ArrayList<ClientePJ>();
		this.ListaProdutos = new ArrayList<Produtos>();
	
	}public boolean verificaCodigoPF(String codigo){
		boolean validado = false;
		for(ClientePF u: this.clientePf){
			if(u.getCodigo().equals(codigo)){
				validado  = true;
				
			}
		}
		return validado;
	}
	
	public boolean verificaCodigoPJ(String codigo){
		boolean validado = false;
		for(ClientePJ u: this.clientePj){
			if(u.getCodigo().equals(codigo)){
				validado  = true;
			}
			
			
			
		}
		return validado;
	}
	
	

	
	
	public void CadastrarUsuario(Usuario u) throws UsuarioJaExisteException{
		if(existeLogin(u.getLogin()) == false){
			this.usuario.add(u);
			
		} else {
			
			throw new UsuarioJaExisteException("já exixte Usuario ");
		}
			
	}
	public boolean existeLogin(String login){
		for(Usuario u : this.usuario){
			if(u.getLogin().equals(login)){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean VerificarLogiin(String login, String senha){
		for(Usuario usu: usuario){
			if(usu.getLogin().equals(login)&&usu.getSenha().equals(senha)){
				return true;
				
			}
		}return false;
		 
			
		
	}
	public List<Usuario>PesquisarUsuarioComecandoCom(String prefixo){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		for(Usuario c:this.usuario){
			if(c.getNome().startsWith(prefixo)){
				lista.add(c);
			}
		}
		return lista;
	}
	public void CadastrarClientePF(ClientePF cpf)throws ClienteJaExistePfException{
			
			if(!verificaCodigoPF(cpf.getCodigo())){
				this.clientePf.add(cpf);				
			} else {
				
				throw new ClienteJaExistePfException("já existe Cliente ");
			}
				
		}
	
	
	public void CadastrarClientePJ(ClientePJ cnpj)throws ClienteJaExisteException{
		
		if(!verificaCodigoPJ(cnpj.getCodigo())){
			this.clientePj.add(cnpj);				
		} else {
			
			throw new ClienteJaExisteException("já existe Cliente ");
		}
			
	}
	
	
	
		
	public List<ClientePF>ObterListaDeClientesPF(){
		ArrayList<ClientePF> lista = new ArrayList<ClientePF>();
		for(ClientePF c : clientePf){
			lista.add(c);
		}
		return lista;
	}
	public List<ClientePJ>ObterListaDeClientesPJ(){
		ArrayList<ClientePJ> lista = new ArrayList<ClientePJ>();
		for(ClientePJ c : clientePj){
			lista.add(c);
		}
		return lista;
	}
	public List<Vendas>RelatorioDeLucro(){
		ArrayList<Vendas> RelatorioDeLucro = new ArrayList<Vendas>();
		for(Vendas v: this.vendas){
			RelatorioDeLucro.add(v);
		}
		return RelatorioDeLucro;
			
		
	}


	@Override
	public void CadastrarProduto(Produtos p) {
		this.ListaProdutos.add(p);
		
		
	}
	public List<Produtos> RelatorioDeVendas(){
		ArrayList<Produtos> lista = new ArrayList<Produtos>();
		for(Produtos p: this.ListaProdutos){
			lista.add(p);
		}
		return lista;
		
	}


	@Override
	public void CadastrarVendas(Vendas v) {
		this.vendas.add(v);
		
	}
	public void gravaClientePfEmArquivo()throws IOException{
		this.gravador.gravaClientePfEmArquivo(this.clientePf);
		
	}
	public void gravaClientePjEmArquivo()throws IOException{
		this.gravador.gravaClientePJEmArquivo(this.clientePj);
	}
	public void gravaUsuariosEmArquivo()throws IOException{
		this.gravador.gravaUsuarioEmArquivo(this.usuario);

	}
	public List<ClientePF> recuperaClienteNoArquivoPF() throws IOException{
		this.clientePf = this.gravador.recuperaClienteNoArquivoPF();
		return clientePf;
	}
	public List<ClientePJ> recuperaClienteNoArquivoPJ() throws IOException{
		this.clientePj = this.gravador.recuperaClienteNoArquivoPJ();
		return clientePj;
	}
	public List<Usuario> recuperaUsuarioNoArquivo() throws IOException{
		this.usuario = this.gravador.recuperaUsuariosNoArquivo();
		return usuario;
	}
	
	
}
