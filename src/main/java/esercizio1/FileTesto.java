package esercizio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileTesto {
	public static void main(String[] args) throws IOException {
		 FileTesto mioTesto= new FileTesto(); 
		
		//mioTesto.CreaTesto("casa.txt");
		//mioTesto.ScriviTesto("casa.txt");
		//mioTesto.LeggiTesto("casa.txt");
		
		
	}

	//creo file  Txt vuoto dando in ingresso nome del file
	public void CreaTesto(String nomefile){
		
		try(  PrintWriter out = new PrintWriter(nomefile)  ){
			out.close();
	    } catch (FileNotFoundException e1) {
		System.out.println("file non trovato");
		e1.printStackTrace();
		}
		
		
	}
	
	//apro file Txt e leggo cosa c'è 
	public void LeggiTesto(String nomefile){
		try( BufferedReader in = new BufferedReader(new FileReader(nomefile))){
				
				String line;
				ArrayList <String> testo = new ArrayList<String>();
				while((line = in.readLine()) != null)
				{
					 testo.add(line);
				    System.out.println(line);
				}
				in.close();
				System.out.println( testo.toString());
				
		    } catch (IOException e1) {
		    		System.out.println("file non trovato");
		    		e1.printStackTrace();
		    }
		
	}
	
	//apro file Txt e aggiungo in coda il nuovo testo
		public void ScriviTesto(String nomefile, String testo){
			
			try(FileWriter fw = new FileWriter(nomefile, true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
				 out.println(testo);
				    //out.println("\nmore text \n");
				    //more code
				    //out.println("more text");
				    //more code
				} catch (IOException e) {
					System.out.println("file non trovato");
					e.printStackTrace();
				}
			
		}
}
