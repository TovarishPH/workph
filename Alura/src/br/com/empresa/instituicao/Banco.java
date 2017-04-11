package br.com.empresa.instituicao;

import java.util.List;
import java.util.Map;

import br.com.empresa.conta.Conta;

public class Banco {

	private String nomeDaInstituicao;
	private List<Conta> contas;
	private Map<String, Conta> assocNome;
	
	/**
	 * Método que adiciona uma conta
	 * @param c
	 */
	public void adicionaConta(Conta c){
		Map<String, Conta> assoc = null;
		assoc.put(c.getNome(), c);
		this.setAssocNome(assoc);
		this.contas.add(c);
	}
	
	/**
	 * Método que retorna uma conta específica
	 * @param x
	 * @return conta
	 */
	public Conta pega(int x){
		return this.contas.get(x);
	}
	
	/**
	 * @return quantidade de conta de um banco
	 */
	public int pegaQuantidadeDeContas(){
		return this.contas.size();
	}
	
	/**
	 * Busca conta pelo nome
	 * @param nome
	 * @return conta
	 */
	public Conta buscaPorNome(String nome){
		
		return null;
	}
	
	public String getNomeDaInstituicao() {
		return nomeDaInstituicao;
	}
	public void setNomeDaInstituicao(String nomeDaInstituicao) {
		this.nomeDaInstituicao = nomeDaInstituicao;
	}
	public List<Conta> getContas() {
		return contas;
	}
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public Map<String, Conta> getAssocNome() {
		return assocNome;
	}

	public void setAssocNome(Map<String, Conta> assocNome) {
		this.assocNome = assocNome;
	}
}
