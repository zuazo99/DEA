package webkudeaketa;

import java.io.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class WebOrri {
	private String url; //la url de cada web, por ejemplo "jimperry.com", es ese formato
	private Integer indizea; //indice correspondiente a cada weborri
	
	private HashMap<String,WebOrri> gakoak=new HashMap<String, WebOrri>();//
	
	private ArrayList<Gako> gakoa;//gako zerrenda, es decir, un gako para cada web (todas las webs tienen un gako diferente)
	//no se si las arraylist van aquí, pero las pongo para acordarme de momento
	//private ArrayList<WebOrri> weborriLista;//web orrien zerrenda
	
	public WebOrri(String webUrl, Integer ind) //ERAIK.
	{
	this.url=webUrl;
	this.indizea=ind;
	
	}
	
	public WebOrri(){
	
	
	}
	//setters and getters

	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Integer getIndizea() {
		return indizea;
	}


	public void setIndizea(Integer indizea) {
		this.indizea = indizea;
	}


	
	
	
	
	
	public void listaKargatu(String nomF){
		/*try{
			FileReader fr=new FileReader(nomF);
			Scanner sc= new Scanner(fr);
			while(sc.hasNextLine()){ //lortzen dugu fitxategiaren datuak y me dice si hay siguiente linea(Booleano)
				String linea=sc.nextLine(); //obtengo una linea del fichero
				
			}
		//}
		//catch(){}*/
	}


	
}
