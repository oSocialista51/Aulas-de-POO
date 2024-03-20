package PjAula_1;
/**
 * @author Andre 
 * @data 06/02/24
 * Classe de Modelagem conceitual de Produto
 */
public class Produto {
	//Atributos
	int codigo;
	String descricao;
	float quantidade;
	
	//Métodos
	public void incluir(int id, String nome, float valor) {
		codigo = id;
		descricao = nome;
		quantidade = valor;
		//atividades de inclusao
}
	public void excluir() {
		//....
	}
	
	public static void main(String[] args) {
		System.out.println("Olá Mundo");
	}
}

