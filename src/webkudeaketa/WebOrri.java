package webkudeaketa;

import java.io.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class WebOrri {
	
	private String url; //weborriaren url-a.
	private Integer indizea; //weborri bakoitzaren url-a.
	//private HashMap<String,WebOrri> gakoak=new HashMap<String, WebOrri>();//
	private ArrayList<Gako> gakoa;//gako zerrenda
	private ArrayList<WebOrri> weborriLista;//erlazionatuko weborrien lista
	
	public WebOrri(String webUrl, Integer ind) //ERAIKITZAILEAK
	{
	this.url=webUrl;
	this.indizea=ind;
	
	}
	
	public WebOrri(){
	
	
	}
	//setters and getters

	public String getUrl() {
		//postbaldintza: url-a bueltatuko du.
		return url;
	}


	public void setUrl(String url) {
		//aurrebaldintza: url bat sartuko da.
		//postbaldintza: url-a aktualizatuta geratuko da.
		this.url = url;
	}


	public Integer getIndizea() {
		//postbaldintza: indizea bueltatuko du.
		return indizea;
	}


	public void setIndizea(Integer indizea) {
		//aurrebaldintza: indize bat sartuko da.
		//postbaldintza: indizea aktualizatuta geratuko da.
		this.indizea = indizea;
	}


	public int compareTo(WebOrri lag) {
		//Bi aktoreen izenak konparatzen ditu
		return this.url.compareTo(lag.getUrl());
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
