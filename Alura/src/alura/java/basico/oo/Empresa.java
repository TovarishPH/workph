package alura.java.basico.oo;

public class Empresa {
	private String nome;
	private String cnpj;
	private Funcionario[] funcionarios;
	private int posicaoLivre;
	
	public Empresa(int qtdFuncionarios){
		this.funcionarios = new Funcionario[qtdFuncionarios];
	}
	
	public void adicionarFuncionario(Funcionario f){
		this.funcionarios[posicaoLivre] = f;
		posicaoLivre++;
	}
	
	public void mostraEmpregados(){
		for(int i = 0; i < funcionarios.length; i++){
			if(this.funcionarios[i] != null){
				System.out.println("Funcionário: " + i + ") " + funcionarios[i].getNome());
				System.out.println("R$: " + funcionarios[i].getSalario());
			}
		}
	}
	
	public void mostraTodasAsInformacoes(){
		for (int i = 0; i < posicaoLivre; i++) {
			System.out.println("***** ***** *****");
			this.funcionarios[i].mostra();
		}
	}
	
	public boolean contem(Funcionario f) {
		for (int i = 0; i < posicaoLivre; i++) {
			if(funcionarios[i] == f){
				return true;
			}
		}
		return false;
		
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String novoNome){
		this.nome = novoNome;
	}
	
	public String getCnpj(){
		return this.cnpj;
	}
	
	public void setCnpj(String novoCnpj){
		this.cnpj = novoCnpj;
	}
	
	public Funcionario getFuncionario(int posicao){
		return this.funcionarios[posicao];
	}
	
	public void setFuncionario(Funcionario novoFuncionario, int posicao){
		this.funcionarios[posicao] = novoFuncionario;
	}
}
