package pkg1;

public class Membro {
	private String nome;
	private String funcao;
	private String username;
	private boolean status;
	
	public Membro(String nome, String funcao, String username, boolean status) {
		this.nome = nome;
		this.funcao = funcao;
		this.username = username;
		this.status = status;
	}

	public Membro(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
