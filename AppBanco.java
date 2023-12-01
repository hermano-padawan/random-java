package banc;

import java.util.ArrayList;
import java.util.Scanner;

public class AppBanco {

	public static void main(String[] args) {
		
		ArrayList<Client> clients = new ArrayList<Client>();

		
		int comprovador = 0;
		boolean condicion = true;
		
		while(condicion) {
			
			switch(opcio_menu()) {
			case 0:
				condicion = false;
				break;
			case 1:
				clients = crearClient(clients);
				break;
			case 2:
				comprovador = check_de_llista_clients_buida(clients);
				if (comprovador == 0) {
					System.out.println("Encara no hi ha clients creats. Tornes al menú.");
				} else {
					clients = borrarClient(clients, trobar_client_a_llista (clients));
				}
				break;
			case 3:
				comprovador = check_de_llista_clients_buida(clients);
				if (comprovador == 0) {
					System.out.println("Encara no hi ha clients creats. Tornes al menú.");
				} else {
				clients = crearComptaClient(clients, trobar_client_a_llista(clients));
				}
				break;
			case 4:
				comprovador = check_de_llista_clients_buida(clients);
				if (comprovador == 0) {
					System.out.println("Encara no hi ha clients creats. Tornes al menú.");
				} else {
					clients = ingressarDiners(clients, trobar_client_a_llista(clients));
				}
				break;
			case 5:
				comprovador = check_de_llista_clients_buida(clients);
				if (comprovador == 0) {
					System.out.println("Encara no hi ha clients creats. Tornes al menú.");
				} else {
					clients = treureDiners(clients, trobar_client_a_llista(clients));
				}
				break;
			case 6:
				comprovador = check_de_llista_clients_buida(clients);
				if (comprovador == 0) {
					System.out.println("Encara no hi ha clients creats. Tornes al menú.");
				} else {
					mostrar_pasta_de_clients(clients, trobar_client_a_llista(clients));
				}
				break;
			case 7:
				comprovador = check_de_llista_clients_buida(clients);
				if (comprovador == 0) {
					System.out.println("Encara no hi ha clients creats. Tornes al menú.");
				} else {
				mostrar_pasta_de_tots_els_clients(clients);
				}
				break;
			default:
				System.out.println("No has introduït bé la opció. TORNEM AL MENÚ.");
				
			}
		}
		System.out.println(clients);
		System.out.println("PROGRAMA COMPTES apagat.");
		trobar_client_a_llista(clients);

	} // --------------------------- final main -----------------------------
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	//////// primer, tres mètodes que faran d'assistents a tots els mètodes ///////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 1.- un retorn string que ens dona el nom que busquem de client
	
	static String nom_client(ArrayList<Client> llista_de_clients, String frase) {
		
		// abans de demanar el nom de client, mostrem la llista de clients actual
		
		Scanner input = new Scanner(System.in);
		System.out.println("La llista de clients ara és:");		
		llista_de_clients(llista_de_clients);
		
		// es demana el client
		
		System.out.println(frase); 
		String opcio = input.nextLine();
		
		return opcio;
	}
	
	// 2.- retorn de INDEX d'on està el client a llista de clients
	
	static int trobar_client_a_llista (ArrayList<Client> llista_de_clients) {
		
		int posicio = 0;
		boolean condicio = true;
		int i = 0;
		String nom = nom_client(llista_de_clients, "quin client hem de trobar?");
		
		while(condicio) {
			
			if (llista_de_clients.get(i).getNom().equals(nom)) {
				posicio = i;
				condicio = false;
			} else {
				posicio = -1;
			}
			
			if (i >= llista_de_clients.size()-1) {
				condicio = false;
			}
			i++;
		}
		
		return posicio;
	}
	
	// 3.- retorn de id de conta per trobar contes:
	
	static int demanar_id (ArrayList<Client> llista_de_clients, String frase) {
		
		Scanner input = new Scanner(System.in);
		System.out.println(frase);
		int identificador_escollit = input.nextInt();
		
		return identificador_escollit;
	}
	
	
	
	// 4.- Demanar els diners que volem ingressar o treure
	
	static int quants_diners(String frase) {
		
		System.out.println(frase);
		Scanner input = new Scanner(System.in);
		int btc = input.nextInt();
		
		return btc;
	}
	
	
	/// a partir d'aquí comencen els mètodes principals:
	
	
	////////////////////////
	//  INICI DEL SWITCH
	// - opcio_menu
	// - check_de_llista_clients_buida
	/////////////////////////////////
	
	static int opcio_menu() {	
		
		Scanner input = new Scanner(System.in);
		
		int opcio = 0;		
		System.out.println("\nQuè vols fer?");
		System.out.println("0.- Sortir de l'aplicació");
		System.out.println("1.- Crear client");
		System.out.println("2.- Eliminar client");
		System.out.println("3.- Crear compta d'un client");
		System.out.println("4.- Ingressar diners en la compta d'un client");
		System.out.println("5.- Treure diners de la compta d'un client");
		System.out.println("6.- Veure els saldos d'un client");
		System.out.println("7.- Mostrar TOT (clients, les seves comptes amb quanta pasta)");
		opcio = input.nextInt();
		
		return opcio;
	}
	
	static int check_de_llista_clients_buida(ArrayList<Client> llista_de_clients) {
		
		int resultat = 0;
		for (int i = 0; i <= llista_de_clients.size()-1; i++) {
			resultat += 1;
			}
		if (resultat == 0) {
			resultat = 0;
		} else {
			resultat = 1;
		}
		
		return resultat;
	}
	
	// ----------------------------- final menu i switch --------------------------------------
	
	
	///////////////////////////////////
	/// CASE 1 - CREAR CLIENT
	////////////////////////////////////
	
	static ArrayList<Client> crearClient (ArrayList<Client> clients) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("digues el nom del client:");
		String nom = input.nextLine();
		
		clients.add(new Client(nom));
		return clients;
	}
	
	//----------------------- final Case 1 ------------------------------------------------
	
	///////////////////////////////////
	/// CASE 2 - ELIMINAR CLIENT
	/// sub mètodes: 
	//// - llista_de_clients
	//// - nom_client
	////////////////////////////////////
	
	static ArrayList<Client> borrarClient(ArrayList<Client> llista_de_clients, int index) {		
		
		int posicio = index;
		
		if (posicio >= 0 ) {
			llista_de_clients.remove(llista_de_clients.get(index));
		} else {
			System.out.println("No, bro, aquest client NO està a la llista.");
		}
		
		// Tornem a ensenyar llista ACTUALITZADA amb un mètode
		
		System.out.println("Després de l'opcio de BORRAR la LLISTA de CLIENTS queda així:");
		
		llista_de_clients(llista_de_clients);
		
		return llista_de_clients;
	}
	
	// sub metode case 2 - mostra llista de clients creats
	
	static void llista_de_clients(ArrayList<Client> llista_de_clients) {
		
		for (int i = 0; i <= llista_de_clients.size()-1; i++) {
			System.out.println((i+1) + ".- " + llista_de_clients.get(i).getNom());
		}
	}
	
	
	// ------------------------------------ final case 2 -------------------------------------------
	
	
	///////////////////////////////////
	// CASE 3 - CREAR CONTA
	/// sub mètodes: 
	//// - nom_client
	//// treu info de constructor Client:
	//// comprovador_id_repetida, afegirCompte, mostrar_id_i_saldo
	////////////////////////////////////
	
	
	static ArrayList<Client> crearComptaClient(ArrayList<Client> llista_de_clients, int index) {
		
		if (index == -1) {
			System.out.println("Aquest client no està a la llista, tornes al menú");
		} else {	
			
			int id = demanar_id(llista_de_clients, "digues una id per anomenar a la conta");
			
			int repeticio = llista_de_clients.get(index).comprovador_id_repetida(id);
			
			if (repeticio != -1) {
				
				Conta novaConta = new Conta(id);
				llista_de_clients.get(index).afegirCompte(novaConta);
			
				// per informació al cient, li mostrem la conta que acaba de crear amb el saldo que té:
				llista_de_clients.get(index).mostrar_id_i_saldo();
			} else {
				System.out.println("Estas repetint una id. Tornes al menú.");
			}
		}
		return llista_de_clients;
		
	}

	
	// ------------------------ final case 3 -----------------------------------------------------
	
	
	///////////////////////////////////
	// CASE 4 - INGRESSAR DINERS EN CONTA
	/// sub mètodes: 
	//// - nom_client 
	//// - comprovar_si_client_te_compta
	//// - quants_diners
	//// treu info de constructor Client:
	//// -mostrarComptesClient, sumarDiners, mostrar_id_i_saldo
	////////////////////////////////////
	
	static ArrayList<Client> ingressarDiners(ArrayList<Client> llista_de_clients, int index) {
		
		if (index == -1) {
			System.out.println("Aquest client no existeix, t'has equivocat, tornes al menú");
		} else {
		
			int prova = comprovar_si_client_te_compta(llista_de_clients, index);
		
			if (prova == 1) {
			
				System.out.println("Aquest client té aquestes comptes:");
				llista_de_clients.get(index).mostrarComptesClient();
			
				int id = demanar_id(llista_de_clients, "en quina compta vols ingressar diners?");
			
				llista_de_clients.get(index).sumarDiners(id, quants_diners("quants diners vols ingressar?"));
				
				System.out.println("Estimat client, per la teva info:");
				llista_de_clients.get(index).mostrar_id_i_saldo();		
			} else {
				System.out.println("Bro, aquest client no té comptes associades encara. Tornes al menú.");			
			}
		}
		return llista_de_clients;
	}
	
	// sub metode case 4 --> comprova si el client ja té alguna compta feta o zero.
	
	static int comprovar_si_client_te_compta(ArrayList<Client> llista_de_clients, int index) {
		
		int prova = llista_de_clients.get(index).comprovador_de_comptes_existents();
		
		return prova;
	}
	
	
	// ------------------------------------- final case 4 ---------------------------------------------------------
	
	
	///////////////////////////////////
	// CASE 5 - RETIRAR DINERS EN CONTA
	/// sub mètodes: 
	//// - nom_client 
	//// - comprovar_si_client_te_compta
	//// - quants_diners
	//// treu info de constructor Client:
	//// -mostrarComptesClient, restarDiners, mostrar_id_i_saldo
	////////////////////////////////////
	
		
	static ArrayList<Client> treureDiners(ArrayList<Client> llista_de_clients, int index) {
		
		if (index == -1) {
			System.out.println("Aquest client no existeix, t'has equivocat, tornes al menú");
		} else {
			int prova = comprovar_si_client_te_compta(llista_de_clients, index);
		
			if (prova == 1) {
			
				System.out.println("Aquest client té aquestes comptes:");
				llista_de_clients.get(index).mostrarComptesClient();
			
				int id = demanar_id(llista_de_clients, "en quina compta vols treure diners?");
					
				llista_de_clients.get(index).restarDiners(id, quants_diners("quants diners vols treure?"));
				
				System.out.println("Estimat client, per la teva info:");
				llista_de_clients.get(index).mostrar_id_i_saldo();		
			} else {
				System.out.println("Bro, aquest client no té comptes associades encara. Tornes al menú.");			
			}
		}
		return llista_de_clients;
	}
	
	///////////////////////////////////
	/// CASE 6 - MOSTRAR DINERS D'UN CLIENT
	////////////////////////////////////
	
	static void mostrar_pasta_de_clients(ArrayList<Client> llista_de_clients, int index) {		
		
		if (index == -1) {
			System.out.println("Aquest client no existeix, t'has equivocat, tornes al menú");
		} else {
			llista_de_clients.get(index).mostrar_id_i_saldo();
		}
					
	}
	
	///////////////////////////////////
	/// CASE 7 - MOSTRAR DINERS D'UN CLIENT
	/// treu info de constructor Client -> mostrarComptesClientAmbPasta
	////////////////////////////////////
	
	static void mostrar_pasta_de_tots_els_clients(ArrayList<Client> llista_de_clients) {
		
		for (int i = 0; i <= llista_de_clients.size()-1; i++) {
			System.out.println("El client " + llista_de_clients.get(i).getNom() + " té:");
			llista_de_clients.get(i).mostrarComptesClientAmbSaldo();
		}
	}
	
	
			

} // --------------------------- final class --------------------------------------------------
