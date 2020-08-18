import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
public interface SisMercado {
	public void CadastrarUsuario(Usuario u)throws UsuarioJaExisteException;
	public void  CadastrarClientePF(ClientePF cpf)throws ClienteJaExistePfException;
	public void  CadastrarClientePJ(ClientePJ cnpj)throws ClienteJaExisteException;
	public void CadastrarProduto(Produtos p);
	public void CadastrarVendas(Vendas v);
	public boolean VerificarLogiin(String login, String senha );
	public List<Usuario>PesquisarUsuarioComecandoCom(String prefixo);
	public List<ClientePF>ObterListaDeClientesPF();
	public List<ClientePJ>ObterListaDeClientesPJ();
	public void gravaClientePfEmArquivo()throws IOException;
	public void gravaClientePjEmArquivo()throws IOException;
	public List<ClientePF> recuperaClienteNoArquivoPF() throws IOException;
	public List<ClientePJ> recuperaClienteNoArquivoPJ() throws IOException;
	public void gravaUsuariosEmArquivo()throws IOException;
	public List<Usuario> recuperaUsuarioNoArquivo() throws IOException;
	
	

}
