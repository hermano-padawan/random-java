package banc;

public class Conta {
	
	private int saldo;
	private int identificador;
	
	public Conta (int id) {
		saldo = 0;
		identificador = id;
	}
	
	// GETTER
	
	public int getIdentificador() {
		return identificador;
	}


	public int getSaldo() {
		return saldo;
		}
	
		
	// SETTER		
	
	public void setSaldo (int diners) {
		saldo = diners;
	}
	
	public void setIdentificador(int id) {
		identificador = id;
	}
	
	public void setSaldo_ingres (int diners) {
		saldo = saldo + diners;
	}
	
	public void setSaldo_retirar (int diners) {
		saldo = saldo - diners;
	}

	// To String

	public String toString() {
		return "En la compta num " + identificador  + " el client té " + saldo + " bitcoins";
	}
	
}
