package banc;

import java.util.ArrayList;

public class Client {
	
	private String nom;
	private ArrayList<Conta> llista;

	public Client(String nom) {
		this.nom = nom;
		llista = new ArrayList<Conta>();	
	}

	// GETTERS
	public String getNom() {
		return nom;
	}
	
	public ArrayList<Conta> getLlistaContas() { //quan demanem aixo a la app, et fa un toString() de cada objecte de Conta.
		return llista; // 
	}
	
	// SETTERS
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void afegirCompte(Conta nova) {
        llista.add(nova);
    }
	
	
	// to string()
	public String toString() {
		return "Aqest client es diu " + nom + " i té les comptes " + llista;
		}
	
	// metode per obtenir llista de contes del client:
	
	public void mostrarComptesClient() {
		for (int i = 0; i <= llista.size()-1; i++) {
			System.out.println("Compte :" +llista.get(i).getIdentificador());
		}
	}
	
	public void mostrarComptesClientAmbSaldo() {
		int contador = 0;
		for (int i = 0; i <= llista.size()-1; i++) {
			System.out.println("Compte: " + llista.get(i).getIdentificador());
			System.out.println("Amb: " + llista.get(i).getSaldo() + " bitcoins");
			contador += 1;		
		}
	}
	
	public void sumarDiners(int id, int btc) {
		
		for (int i = 0; i <= llista.size()-1; i++) {
			if(id == llista.get(i).getIdentificador()) {
				llista.get(i).setSaldo_ingres(btc);
			}
		}
	}
	
	public void restarDiners(int id, int btc) {
		
		for (int i = 0; i <= llista.size()-1; i++) {
			if(id == llista.get(i).getIdentificador()) {
				llista.get(i).setSaldo_retirar(btc);
			}
		}
	}
	
	public void mostrar_id_i_saldo () {
		System.out.print(nom + " té:\n");
		for (int i = 0; i <= llista.size()-1; i++) {
			System.out.println("A la conta amb id " 
				+ llista.get(i).getIdentificador() + " hi ha: " + llista.get(i).getSaldo() + " bitcoins");
		}
	}
	
	public int comprovador_de_comptes_existents() {
		
		int resultat = 0;
		
		for (int i = 0; i <= llista.size()-1; i++) {
			resultat += 1;
			}
		if (resultat == 0) {
			resultat = 0;
		} else {
			resultat = 1;
		}
		
		return resultat;
	}
	
	public int comprovador_id_repetida(int identificador_escollit) {
		int repeticio = 0;
		
		for (int i = 0; i <= llista.size()-1; i++) {
			if (llista.get(i).getIdentificador() == identificador_escollit) {
				repeticio = -1;
			}
		}
		return repeticio;
	}
	
} // --------- final class -------------------------
	
