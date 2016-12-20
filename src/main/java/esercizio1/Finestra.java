package esercizio1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.List;

public class Finestra {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	
	
	ArrayList<String> listaUsername = new ArrayList<String>();
	ArrayList<String> listaPassword = new ArrayList<String>();
	ArrayList<Utenti> utentiLog= new ArrayList<Utenti>(); //nb List è un'interfaccia quindi posso instanziare solo oggetti che la implementino (eg. ArrayList)

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// vedo cosa c'è nel db
		
		/*List<Utenti> utentiArchiviati=null;
		  //utenti che fanno log in tramite interfaccia
		ModificaDB obj = new ModificaDB();
	
			utentiArchiviati= obj.listUser();  //richiamo lista da database
		
		Utenti[] lista_utenti= new Utenti[utentiArchiviati.size()]; //creo array oggetti utenti
		System.out.println("Lista utenti"); 
		for (int i=0;i<utentiArchiviati.size();i++) { 
			lista_utenti[i]=utentiArchiviati.get(i);
 			//System.out.println((i+1) + utentiArchiviati.toString()); 
			System.out.println((i+1) + lista_utenti[i].getUserName() + lista_utenti[i].getUserPassword()); 
 		} */
		
		//creo finestra
		 EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finestra window = new Finestra();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		 //controllo se credenziali fornite esistono nel db
		 
		
			
	}

	/**
	 * Create the application.
	 */
	public Finestra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(Color.BLUE);
		frame.setBackground(Color.BLUE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("password:");
		splitPane.setLeftComponent(lblNewLabel);
		
		passwordField = new JPasswordField();
		splitPane.setRightComponent(passwordField);
		
		JLabel lblLogin = new JLabel("login");
		frame.getContentPane().add(lblLogin, BorderLayout.NORTH);
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JLabel lblUserName = new JLabel("user name:");
		frame.getContentPane().add(lblUserName, BorderLayout.WEST);
		
		JButton btnEnter = new JButton("enter");
		frame.getContentPane().add(btnEnter, BorderLayout.EAST);
		
		
		ActionListener actionListener; 
		btnEnter.addActionListener(actionListener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//server.start();
				try(  PrintWriter out = new PrintWriter( "utenti.txt" )  ){
					for (int i=0;i<listaUsername.size();i++)
						out.println( listaUsername.get(i) + " " + listaPassword.get(i));
					
				    out.close();
				    
				    
				} catch (FileNotFoundException e1) {
					System.out.println("file non trovato");
					e1.printStackTrace();
				}
				
				// salva singolarmente user e password in due liste di stringhe
			/*	try(  PrintWriter out = new PrintWriter( "utenti.txt" )  ){
					for (int i=0;i<listaUsername.size();i++)
						out.println( listaUsername.get(i) + " " + listaPassword.get(i));
					
				    out.close();
				    
				    
				} catch (FileNotFoundException e1) {
					System.out.println("file non trovato");
					e1.printStackTrace();
				}*/
				
				
				
				//System.out.println("evento riconosciuto"); // dopo click ok
				/*for (int i=0;i<listaUsername.size();i++)
				{
					System.out.println(listaUsername.get(i) + " " + listaPassword.get(i));
				}*/
			}
			
		});
		
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean trovato=false;
				Utenti e=new Utenti();
				// Quello che succede avviene a seguito del click sul pulsante.
				
				//lista di oggetti tipo utente che si aggiorna
				
				e.setUserName(textField.getText());
				e.setUserPassword(String.valueOf(passwordField.getPassword()));
				utentiLog.add(e); 
				
				
				// lista di username che si aggiorna
				//listaUsername.add(textField.getText());
										
				// lista di password che si aggiorna
				//listaPassword.add(String.valueOf(passwordField.getPassword()));
				
				
				//System.out.println("user letto:" + textField.getText());
				//System.out.println("user salvato:" + e.getUserName());
				
				//System.out.println("psw:" + String.valueOf(passwordField.getPassword()));
				//JOptionPane.showMessageDialog(null, "Click");
				
				// vedo cosa c'è nel db
				
				List<Utenti> utentiArchiviati=null;
				  
				//utenti che fanno log in tramite interfaccia
				ModificaDB obj = new ModificaDB();
			
				utentiArchiviati= obj.listUser();  //richiamo lista da database
				
				Utenti[] lista_utenti= new Utenti[utentiArchiviati.size()]; //creo array oggetti utenti
				
				System.out.println("credenziali inserite: " + e.getUserName() + " " + e.getUserPassword());
				for (int i=0;i<utentiArchiviati.size();i++) { 
					lista_utenti[i]=utentiArchiviati.get(i);
		 			//System.out.println((i+1) + utentiArchiviati.toString()); 
					//System.out.println((i+1) + lista_utenti[i].getUserName() + lista_utenti[i].getUserPassword()); 
					
					//if((lista_utenti[i].getUserName() == e.getUserName()) && (lista_utenti[i].getUserPassword()==e.getUserPassword()))
					if ( (e.getUserName().equals(lista_utenti[i].getUserName())) && (e.getUserPassword().equals(lista_utenti[i].getUserPassword()))     ) 
						trovato=true;
				}
				//System.out.println("flag" + trovato);
					if (trovato==true) JOptionPane.showMessageDialog(null, "ok! Accesso consentito");
				else JOptionPane.showMessageDialog(null, "Credenziali non valide");
				
				
			}
		});
	}
}

