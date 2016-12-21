package esercizio1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import esercizio1.FileTesto;
import esercizio1.ModificaDB;
import esercizio1.Utenti;

public class AzioneClick implements ActionListener {
	
	
	private JTextField jTxtF;
	private JPasswordField jPswF;

	
	public AzioneClick(JTextField jTxtF, JPasswordField jPswF) {
		this.jPswF = jPswF;
		this.jTxtF = jTxtF;
	}



	public void actionPerformed(ActionEvent e) {
		
		ArrayList<Utenti> utentiLog= new ArrayList<Utenti>();//nb List è un'interfaccia quindi posso instanziare solo oggetti che la implementino (eg. ArrayList)

		boolean trovato=false;
		Utenti nuovoUtente=new Utenti();
		// Quello che succede avviene a seguito del click sul pulsante.
		
		//lista di oggetti tipo utente che si aggiorna
		
		nuovoUtente.setUserName(jTxtF.getText());
		nuovoUtente.setUserPassword(String.valueOf(jPswF.getPassword()));
		utentiLog.add(nuovoUtente); 
		
		// vedo cosa c'è nel db
		
		List<Utenti> utentiArchiviati=null;
		  
		//utenti che fanno log in tramite interfaccia
		ModificaDB obj = new ModificaDB();
	
		utentiArchiviati= obj.listUser();  //richiamo lista da database
		
		Utenti[] lista_utenti= new Utenti[utentiArchiviati.size()]; //creo array oggetti utenti
		
		System.out.println("credenziali inserite: " + nuovoUtente.getUserName() + " " + nuovoUtente.getUserPassword());
		for (int i=0;i<utentiArchiviati.size();i++) { 
			lista_utenti[i]=utentiArchiviati.get(i);
 		if ( (nuovoUtente.getUserName().equals(lista_utenti[i].getUserName())) && (nuovoUtente.getUserPassword().equals(lista_utenti[i].getUserPassword()))     ) 
				trovato=true;
		}
	
			/*if (trovato==true) JOptionPane.showMessageDialog(null, "ok! Accesso consentito");
		else JOptionPane.showMessageDialog(null, "Credenziali non valide");
			

			 FileTesto mioTesto= new FileTesto();
			 String testo = new String("\n");
			 testo=testo.concat("utente:");
			 testo=testo.concat(nuovoUtente.getUserName());
			 testo=testo.concat(" , password:");
			 testo=testo.concat(nuovoUtente.getUserPassword());
			 testo= testo.concat(",messaggio:");
			 testo=testo.concat(String.valueOf(trovato));
			 
			 	
			 mioTesto.ScriviTesto("utente.txt", testo);*/
				
		
		
	}


	
}
