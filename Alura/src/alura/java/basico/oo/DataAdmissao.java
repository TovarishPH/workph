package alura.java.basico.oo;

public class DataAdmissao {
	private int dia;
	private int mes;
	private int ano;

	public DataAdmissao(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;

		if (!this.validaData(dia, mes, ano)) {
			System.out.println("Data " + getDataFormatada() + " inválida");
		} else {
			System.out.println(this.getDataFormatada());
		}
	}

	public void preencheData(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public String getDataFormatada() {
		return this.dia + "/" + this.mes + "/" + this.ano;
	}

	private boolean validaData(int dia, int mes, int ano) {
		// Validando meses com 30 dias
		if ((this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) && this.dia < 31) {
			return true;
		} else if (this.dia <= 31) {
			return true;
		}

		// Validando fevereiro
		if (this.mes == 2 && anoBissexto()) { // Validando mes 2
			if (this.dia <= 29) {
				return true;
			} else if (this.dia < 29) {
				return true;
			}
		}
		return false;
	}

	private boolean anoBissexto() {
		if (this.ano % 400 == 0) {
			return true;
		} else if (this.ano % 4 == 0 && this.ano % 100 != 0) {
			return true;
		}
		return false;
	}

	//Método Main
	public static void main(String[] args) {

		// DataAdmissao data = new DataAdmissao(29, 2, 2015);
		DataAdmissao data = new DataAdmissao(31, 5, 2015);

	}

}
