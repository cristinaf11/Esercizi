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
import java.awt.Font;
import javax.swing.SwingConstants;

public class Finestra {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main_Finestra(String[] args) {
		
		
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
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogin.setBounds(78, 20, 200, 57);
		frame.getContentPane().add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(157, 88, 132, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUserName = new JLabel("user name:");
		lblUserName.setBounds(41, 81, 106, 37);
		frame.getContentPane().add(lblUserName);
		
		JButton btnEnter = new JButton("enter");
		btnEnter.setBounds(299, 82, 119, 69);
		frame.getContentPane().add(btnEnter);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 116, 132, 22);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("password:");
		lblNewLabel.setBounds(41, 117, 106, 20);
		frame.getContentPane().add(lblNewLabel);
		
	
		AzioneClick clickEnter = new AzioneClick(textField, passwordField);
		btnEnter.addActionListener(clickEnter);
		
		
		
	}
}

