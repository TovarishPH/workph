package br.com.empresa.conta;

public abstract class Conta implements Comparable<Conta>{

	protected String nome;
	protected double saldo;
	protected int numero;
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void saca(double valor) {
		this.saldo -= valor;
	}
	
	public void deposita(double valor) {
		if(valor < 0){
			throw new ValorInvalidoException(valor);
		}else {
			saldo += valor;
		}
	}
	
	public abstract void atualiza(double taxaSelic);
	
	@Override
	public String toString() {
		return "este objeto é uma conta, com saldo R$" + this.saldo;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int compareTo(ContaPoupanca outraConta) {
		if(this.getSaldo() > outraConta.getSaldo()){
			return 1;
		}else if( this.getSaldo() < outraConta.getSaldo()){
			return -1;
		}else{
			return 0;
		}
	}

}
