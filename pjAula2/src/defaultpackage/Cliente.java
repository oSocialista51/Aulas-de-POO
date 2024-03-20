package defaultpackage;

public class Cliente {
	//Atributos
	private int codigo;
	private String nome;
	private int numeroTelefone;
	private String email;
	
	//M�todos
	public void inserir(int codigo, String nome, 
				int numeroTelefone, String email) {
		this.codigo = codigo;
		this.nome = nome;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
	}
	
	public void alterar(int codigo, String nome, 
			int numeroTelefone, String email) {
		this.codigo = codigo;
		this.nome = nome;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		if(codigo > 0) {
			this.codigo = codigo;
		}else {
			System.err.println("C�digo Inv�lido!");
		}
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroTelefone() {
		return numeroTelefone;
	}
	public void setNumeroTelefone(int numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
	
}
