package alura.java.basico.oo;

public class Funcionario {
	private String nome;
	private double salario;
	private String departamento;
	private DataAdmissao dataEntrada;
	private String rg;
	private static int identificador;
	
	public Funcionario(){
		//construtor padrão
		Funcionario.identificador++;
	}
	
	public Funcionario(String nomeObrigatorio){
		this.nome = nomeObrigatorio;
		Funcionario.identificador++;
	}
	
	public void recebeAumento(double valor){
		this.salario += valor;
	}
	
	public double getCalculoGanhoAnual(){
		double salarioAnual = this.salario * 12;
		return salarioAnual;
	}
	
	public void mostra(){
		System.out.println("Nome: " + this.nome);
		System.out.println("ID: " + Funcionario.getIdentificador());
		System.out.println("Departamento: " + this.departamento);
		System.out.println("Data de entrada: " + this.dataEntrada.getDataFormatada());
		System.out.println("Rg.: " + this.rg);
		System.out.println("Salário: " + this.salario);
		System.out.println("Salário anual: "+ getCalculoGanhoAnual());
	}
	
	public static int getIdentificador(){
		return Funcionario.identificador;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nomeModificado){
		this.nome = nomeModificado;
	}
	
	public double getSalario(){
		return this.salario;
	}
	
	public void setSalario(double novoSalario){
		this.salario = novoSalario;
	}
	
	public String getDepartamento(){
		return this.departamento;
	}
	
	public void setDepartamento(String novoDepartamento){
		this.departamento = novoDepartamento;
	}
	
	public DataAdmissao getDataAdmissao(){
		return this.dataEntrada;
	}
	
	public void setDataAdmissao(DataAdmissao novaData){
		this.dataEntrada = novaData;
	}
	
	public String getRg(){
		return this.rg;
	}
	
	public void setRg(String novoRg){
		this.rg = novoRg;
	}
	
}
