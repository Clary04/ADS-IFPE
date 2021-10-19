package Avaliacao;

public class Poupanca extends Conta{

	final double juros = 4.37; 
	
	public Poupanca(int numero, Banco banco, Cliente cliente, double saldo) {
		super(numero, banco, cliente, saldo);
	}
		
	public double getJuros() {
		return juros;
	}

	public double RenderJuros() {
		
		return super.getSaldo()+super.getSaldo()*(this.juros/100);
		
	}
}
