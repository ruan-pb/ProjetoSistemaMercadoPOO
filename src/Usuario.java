
public class Usuario {
	private String login;
	private String nome;
	private String senha;
	
	public Usuario(String login, String nome, String senha){
		this.login = login;
		this.nome = nome;
		this.senha = senha;
	}
		
	public Usuario(String login, String nome){
		this.login = login;
		this.nome = nome;
		this.senha = "";
		
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	public String getLogin(){
		return this.login;
	}
	public void setLogin(String lo){
		this.login = lo;
	}
	public String getNome(){
		return this.nome;
	}
	public void setNome(String n){
		this.nome = n;
	}
	public String getSenha(){
		return this.senha;
	}
	public void setSenha(String s){
		this.senha = s;
	}
	public String toString(){
		return " nome: "+this.nome+" de login: "+this.login;
	


}
}