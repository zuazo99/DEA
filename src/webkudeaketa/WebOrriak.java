package webkudeaketa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WebOrriak { //klase hau EMA,singleton patroia
	//atributuak
	private ArrayList<WebOrri> lista;
	private static WebOrriak nireWebOrriak=null;
	
	//eraikitzaileak
	private WebOrriak(){
		this.lista=new ArrayList<WebOrri>();
	}
	public static synchronized WebOrriak getNireWebOrriak(){
		if(nireWebOrriak==null){
			nireWebOrriak=new WebOrriak();
		}
		return nireWebOrriak;
	}
	
	public void listaKargatu(String nomF){
		try{
			FileReader fr=new FileReader(nomF);
			Scanner sc= new Scanner(fr);
			int i=0;
			while(sc.hasNextLine()){ //lortzen dugu fitxategiaren datuak y me dice si hay siguiente linea(Booleano)
				String linea=sc.nextLine(); //obtengo una linea del fichero
				String [] StringMoztu= linea.split(" "); //Lortzen dugu web orriaren bi datuak, bata linka eta indizea.
				WebOrri weborri= new WebOrri(); //objetu berrri bat sortzen dugu weborri motatakoa.
				//diria que en la posicion impares del array(StringMoztu) se guardan los indices y pares los links.
				weborri.setUrl(StringMoztu[i]);
				i++;
				weborri.setIndizea(Integer.parseInt(StringMoztu[i])); //parse lo que hace es convertir un string a int.
				this.lista.add(weborri);//gehitzen dugu weborri bat ArrayLista-ra
				i++;
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Ez da aurkitu fitxategia");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
