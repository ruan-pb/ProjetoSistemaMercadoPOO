import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MenuTestaMercadinho {
	public static void main(String args []) throws IOException{
		boolean sair = false;
		boolean voltar = false;
		SisMercadoLCC sistema = new SisMercadoLCC();
		try{
			sistema.recuperaClienteNoArquivoPF();
			JOptionPane.showMessageDialog(null, "Dados de Clientes de CPF recuperados com sucesso");
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Agenda Iniciada vazia CPF");
			
		}
		try{
			sistema.recuperaClienteNoArquivoPJ();
			JOptionPane.showMessageDialog(null, "Dados de Clientes de CNPJ recuperados com sucesso");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Agenda Iniciada vazia CNPJ");
		}
		try{
			sistema.recuperaUsuarioNoArquivo();
			JOptionPane.showMessageDialog(null, "Dados dos Usuarios recuperados com sucesso");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Agenda Iniciada vazia USUARIOS");
		}
		
		
		
		while(!sair){
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção\n(1) Ja tem cadastro de usuario: \n(2) não possui cadastro e quer se cadastrar\n(3)Sair"));
			if(opcao == 1){
				String login = JOptionPane.showInputDialog("LOGIN: ");
				String senha = JOptionPane.showInputDialog("SENHA: ");
				if(sistema.VerificarLogiin(login, senha) == true){
					System.out.println("Seja Bem-Vindo ao Sistema ");
					while(!voltar){
						int menu = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção\n(1) Cadastrar Cliente\n(2) Obter Lista de Clientes\n(3) Pesquisa Usuarios começados com... \n(4) Cadastrar Produto\n(5) Relatório de Vendas\n(6) Cadastrar Venda\n(7) relatório de lucro\n(8) sair"));
						if(menu == 1){
							int qual = Integer.parseInt(JOptionPane.showInputDialog(" Digite uma opção: \n(1) Pessoa Fisica(CPF) \n(2) Pessoa Juridica (CNPJ) "));
							if(qual == 1){
								String nome = JOptionPane.showInputDialog("Informe o nome para cadastro: ");
								String cpf = JOptionPane.showInputDialog("Informe seu cpf: ");
								ClientePF c = new ClientePF(nome,cpf);
								
								try {
									
									sistema.CadastrarClientePF(c);
									sistema.gravaClientePfEmArquivo();
									JOptionPane.showMessageDialog(null, "Pessoa fisica cadastrada");
								} catch (ClienteJaExistePfException e) {
									JOptionPane.showMessageDialog(null, "Pessoa fisica não cadastrada" + e.getMessage());
								}
								
									
								}else if(qual == 2){
							 		try {
							 			
							 			String nome = JOptionPane.showInputDialog("Informe o nome para cadastro: ");
								 		String cnpj = JOptionPane.showInputDialog("Informe seu cnpj: ");
							 			ClientePJ j = new ClientePJ(nome,cnpj);
							 			sistema.CadastrarClientePJ(j);
							 			sistema.gravaClientePjEmArquivo();
							 			JOptionPane.showMessageDialog(null, "Pessoa Juridica cadastrada");
							 		} catch (ClienteJaExisteException e) {
							 			JOptionPane.showMessageDialog(null, "Pessoa Juridica não cadastrada" + e.getMessage());
							 		}
								
							
								}else{
									System.out.println("Opção Invalida!!");
									continue;
							}
						
						}
						else if(menu == 2){
							int escolha = Integer.parseInt(JOptionPane.showInputDialog("\n(1)obter lista de Cliente de CPF\n(2) obter lista de cliente de CNPJ"));
							if(escolha == 1){
								System.out.println("Lista de clientes: \n "+ sistema.ObterListaDeClientesPF());
								
							}else if(escolha == 2){
								System.out.println("Lista de clientes: \n "+ sistema.ObterListaDeClientesPJ());
								
							}
							
						}
						else if(menu == 3){
							String prefixo = JOptionPane.showInputDialog("Informe o prefixo do nome do usuario que voce deseja saber: " );
							System.out.println("Nomes com :"+prefixo+" São:\n "+sistema.PesquisarUsuarioComecandoCom(prefixo));
						}
						else if(menu == 4){
							String codigo = JOptionPane.showInputDialog("Informe o codigo do produto: ");
							String nome = JOptionPane.showInputDialog("Informe o nome do produto");
							double atacado = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço de atacado"));
							double venda = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço da revenda"));
							Produtos p = new Produtos(codigo,nome,atacado,venda);
							sistema.CadastrarProduto(p);
							
						}
						else if(menu == 5){
							System.out.println("Relatório de vendas: "+sistema.RelatorioDeVendas());
						}
						else if(menu == 6){
							double vendido = Double.parseDouble(JOptionPane.showInputDialog("Produto Vendido foi a que preço: ? "));
							double comprado = Double.parseDouble(JOptionPane.showInputDialog("O produto foi comprado por: ?"));
							Vendas v = new Vendas(vendido, comprado);
							sistema.CadastrarVendas(v);
							
							
							
						}
						else if(menu == 7 ){
							System.out.println(sistema.RelatorioDeLucro());
						}
						
						else{
							voltar = true;
						}
						
				  }
				}else{
					System.out.println("Opção Invalida!!");
				}
			}else if(opcao==2){
				List<Usuario> lista = new ArrayList<Usuario>();
				String nome = JOptionPane.showInputDialog("Informe seu nome para o cadastro: ");
				JOptionPane.showMessageDialog(null, "Informe um login para seu uso diario logo a seguir");
				String login = JOptionPane.showInputDialog("Login... ");
				JOptionPane.showMessageDialog(null, "Informe uma senha para o seu login logo em seguida: ");
				String senha = JOptionPane.showInputDialog("Senha...");
				Usuario usu = new Usuario(login,nome, senha);
				lista.add(usu);
				
				
				try {
					sistema.CadastrarUsuario(usu);
					sistema.gravaUsuariosEmArquivo();
					JOptionPane.showMessageDialog(null,"cadastro aceito");
				} catch (UsuarioJaExisteException e) {
					JOptionPane.showMessageDialog(null, "Usuário já existe" + e.getMessage());
				}
			}
			else{
				sair = true;
			}
			
		
		
		
		
		}
	}

}

