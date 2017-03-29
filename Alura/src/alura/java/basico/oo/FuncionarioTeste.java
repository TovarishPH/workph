package alura.java.basico.oo;

import alura.java.basico.oo.Funcionario;

public class FuncionarioTeste {

	public static void main(String[] args) {

		Funcionario f = new Funcionario();
		DataAdmissao data = new DataAdmissao(04, 04, 2001);
		f.setNome("HueBrson");
		f.setRg("0192837465");
		f.setDepartamento("Fiverr Worker");
		f.setDataAdmissao(data);
		f.setSalario(1000);
		
		f.mostra();
		
		Funcionario f2 = new Funcionario();
		DataAdmissao data2 = new DataAdmissao(02,02,2002);
		f2.setNome("Rildo");
		f2.setRg("98765421");
		f2.setDepartamento("Static worker number 2");
		f2.setDataAdmissao(data2);
		f2.setSalario(1200);
		
		f2.mostra();
	}

}
