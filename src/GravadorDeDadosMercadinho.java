import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class GravadorDeDadosMercadinho {
	public static final String NOME_DE_CLIENTEPF = "clientesCPF.txt  ";
	public static final String NOME_DE_CLIENTEPJ = "clientesCNPJ.txt  ";
	public static final String NOME_DO_USUARIO = "usuarios.txt  ";
	
	
	public void gravaUsuarioEmArquivo(List<Usuario> listaUsuarios) throws IOException {
		List<String> dadosUsuarios = new ArrayList<String>();
		for(Usuario u: listaUsuarios){
			dadosUsuarios.add(u.getNome()+"-"+u.getLogin());
		}
		gravaTextoEmArquivo(dadosUsuarios, NOME_DO_USUARIO );
	}
	
	public List<Usuario> recuperaUsuariosNoArquivo() throws IOException{
		List<String> dadosUsuarios = recuperaTextoDeArquivo(NOME_DO_USUARIO);
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for(String s: dadosUsuarios){
			String [] dados = s.split("-");
			Usuario usu = new Usuario(dados[0],dados[1]);
			usuarios.add(usu);
		}
		return usuarios;
	}
	
	public void gravaClientePfEmArquivo(List<ClientePF> listaClientesPF) throws IOException {
		List<String> dadosClientesPf =  new ArrayList<String>();
		for(ClientePF f: listaClientesPF){
			dadosClientesPf.add(f.getNome()+"-"+f.getCodigo());
			
		}
		gravaTextoEmArquivo(dadosClientesPf,NOME_DE_CLIENTEPF );
		
		
	}
	public void gravaClientePJEmArquivo(List<ClientePJ> listaClientesPJ) throws IOException {
		List<String> dadosClientePj = new ArrayList<String>();
		for(ClientePJ j: listaClientesPJ){
			dadosClientePj.add(j.getNome()+"-"+j.getCodigo());
		}
		gravaTextoEmArquivo(dadosClientePj,NOME_DE_CLIENTEPJ);
		
	}
	
	public List<ClientePJ> recuperaClienteNoArquivoPJ() throws IOException{
		List<String> dadosClientesPf = recuperaTextoDeArquivo(NOME_DE_CLIENTEPF);
		List<ClientePJ> clientesPj = new ArrayList<ClientePJ>();
		for(String s: dadosClientesPf){
			String [] dados = s.split("-");
			ClientePJ cpf = new ClientePJ(dados[0], dados[1]);
			clientesPj.add(cpf);
		}
		return clientesPj;
	}
	public List<ClientePF> recuperaClienteNoArquivoPF() throws IOException{
		List<String> dadosClientePf = recuperaTextoDeArquivo(NOME_DE_CLIENTEPJ);
		List<ClientePF> clientesPf = new ArrayList<ClientePF>();
		for(String s: dadosClientePf){
			String [] dados = s.split("-");
			ClientePF cnpj = new ClientePF(dados[0], dados [1]);
			clientesPf.add(cnpj);
			
		}
		return clientesPf;
	}

	public void gravaTextoEmArquivo(List<String> texto, String nomeArquivo) throws IOException{
		BufferedWriter gravador = null;
		try{
			gravador  = new BufferedWriter(new FileWriter(nomeArquivo));
			for(String s: texto){
				gravador.write(s+"\n");
			}
		}finally{
			if(gravador != null){
				gravador.close();
				
			}
		} 
		
	}public List<String> recuperaTextoDeArquivo(String nomeArquivo) throws IOException{
		BufferedReader leitor = null;
		List<String> textoLido = new ArrayList<String>();
		try{
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String texto = null;
			do{
				texto = leitor.readLine();
				if(texto != null){
					textoLido.add(texto);
				}
				
			} while(texto != null);
		}finally{
			if(leitor != null){
				leitor.close();
			}
		}
		return textoLido;
		
	
	}
	
	


	
}