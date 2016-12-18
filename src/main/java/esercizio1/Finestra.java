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

public class Finestra {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	
	
	ArrayList<String> listaUsername = new ArrayList<String>();
	ArrayList<String> listaPassword = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
				
				
				System.out.println("evento riconosciuto"); // dopo click ok
				for (int i=0;i<listaUsername.size();i++)
				{
					System.out.println(listaUsername.get(i) + " " + listaPassword.get(i));
				}
			}
			
		});
		
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				// Quello che succede avviene a seguito del click sul pulsante.
				
				//lista di user che si aggiorna
				listaUsername.add(textField.getText());
						
				// lista di password che si aggiorna
				listaPassword.add(String.valueOf(passwordField.getPassword()));
				
				
				System.out.println("user:" + textField.getText());
				
				System.out.println("psw:" + String.valueOf(passwordField.getPassword()));
				//JOptionPane.showMessageDialog(null, "Click");
				
				
			}
		});
	}
}
