package br.unisal.Modelagem;

/** Classe de Modegaem Conceitual de Produto
 * 
 * @author Heitor Moreira
 * @data 16/04/2024
 */

public class Produto {
	//Atributos
	private int codigo;
	private String descricao;
	private UnidadeMedida un;
	private double largura;
	private double comprimento;
	private Situacao situacao;
	private String localizacao;
	
	//Métodos
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public UnidadeMedida getUn() {
		return un;
	}
	public void setUn(UnidadeMedida un) {
		this.un = un;
	}
	public double getLargura() {
		return largura;
	}
	public void setLargura(double d) {
		this.largura = d;
	}
	public double getComprimento() {
		return comprimento;
	}
	public void setComprimento(double d) {
		this.comprimento = d;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	@Override
	public String toString() {
		return "Código: " + getCodigo() + "Descricao: " + getDescricao() + "UnidadeMedida: " + getUn().getDescricao() + "Largura" + getLargura() + "Comprimento: " + getComprimento() + "Situaçao: " + getSituacao() + " Localização: " + getLocalizacao();
		}
}