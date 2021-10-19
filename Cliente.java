package Avaliacao;

public class Cliente {

	private String Nome, CPF;
	
	public Cliente(String Nome, String CPF) {
		this.Nome = Nome; 
		this.CPF = CPF;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
}
