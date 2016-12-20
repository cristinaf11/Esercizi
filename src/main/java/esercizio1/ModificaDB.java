package esercizio1;

import java.util.List;
import java.util.Iterator;
import java.util.Random;
import java.util.ArrayList;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import util.HibernateUtil;

public class ModificaDB {

	/*public static void main(String[] args) {
		ModificaDB obj = new ModificaDB();
		List<Utenti> utentiArchiviati=null;
		
		
		//Long userId1=obj.saveUser("utente1", "20ps");
		
		//Long userId2=obj.saveUser("u2", "2d02s");

		//Long userId3=obj.saveUser("user4", "gdxgsd");
		utentiArchiviati= obj.listUser();  // chiamo lista campi da db
		
		
		Utenti[] lista_utenti= new Utenti[utentiArchiviati.size()];  //creo array oggetti utenti
		System.out.println("Lista utenti"); 
	
		
		for (int i=0;i<utentiArchiviati.size();i++) { 
			lista_utenti[i]=utentiArchiviati.get(i);
 			System.out.println((i+1) + utentiArchiviati.toString()); 
 		}
		
		
		System.out.println("Lista utenti"); 
				for (int i=0;i<utentiArchiviati.size();i++) { 
		 			System.out.println((i+1) + utentiArchiviati.toString()); 
		 		} 

		System.out.println("fine esecuzione main");

	}
	*/


// crea tabella, campi e inserisce i dati

public Long saveUser(String userName, String userPassword)
{
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	Transaction transaction = null;
	Long userId = null;
	try {
		
		
		transaction = session.beginTransaction();
		
		// Creo un oggetto di tipo User
		Utenti utente = new Utenti();
		utente.setUserName(userName);
		utente.setUserPassword(userPassword);
		//course.setCourseId(5L);
		userId = (long) session.save(utente); // session.save ritorna un long 
		
		
		transaction.commit();
	} catch (HibernateException e) {
		transaction.rollback();
		e.printStackTrace();
	} finally {
		
		session.close();
	}
	return userId;
}


	
	// leggo dati da db

public List<Utenti> listUser(){
	List<Utenti> users=null;


	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	try {
		transaction = session.beginTransaction();
		
		users = session.createQuery("from Utenti").list();
		System.out.println("Lista utenti in database"); 
	
		for (Iterator iterator = users.iterator(); iterator.hasNext();)
		{
			Utenti utenti = (Utenti) iterator.next();
			System.out.println(utenti.getUserName() + " " + utenti.getUserPassword());
			//listaUtenti.add(utenti);
		}
		
		transaction.commit();
		//return users;
		

	} catch (HibernateException e) {
		transaction.rollback();
		e.printStackTrace();
			
	} catch (Exception e){
		System.out.println("eccezione rilevata");
		
	}finally {
	
		session.close();
		
	}
	return users;
	}


}