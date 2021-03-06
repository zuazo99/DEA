package webkudeaketa;

import java.io.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
import webkudeaketa2.UnorderedCircularLinkedList;
public class WebOrri {
	
	private String url; //weborriaren url-a.
	private Integer indizea; //weborri bakoitzaren url-a.
	private ArrayList<GakoHitz> listaGakoa;//gako zerrenda
	private ArrayList<WebOrri> weborriLista;//erlazionatuko weborrien lista
	
	public WebOrri(String webUrl, Integer ind) //ERAIKITZAILEAK
	{
	this.url=webUrl;
	this.indizea=ind;
	this.listaGakoa=new ArrayList<GakoHitz>();
	this.weborriLista=new ArrayList<WebOrri>();
	
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
		//Bi webeen url-ak konparatzen ditu
		return this.url.compareTo(lag.getUrl());
	}
	
	
	public void gehituWebEstekatua(WebOrri web){
		if(web!=null && !this.weborriLista.contains(web)){
			this.weborriLista.add(web);
		}
	}
	public void webEstekatuakPrinteatu(){
		Iterator<WebOrri> itr=this.weborriLista.iterator();
		while(itr.hasNext()){
			WebOrri web=itr.next();
			System.out.println(web.getUrl());
		}
	}
	
	public void gehituGakoa(GakoHitz gakoa){
		if(gakoa!=null && !this.listaGakoa.contains(gakoa)){
			this.listaGakoa.add(gakoa);
		}
	}

	public ArrayList<WebOrri> getWeborriLista() {
		return weborriLista;
	}

	public void setWeborriLista(ArrayList<WebOrri> weborriLista) {
		this.weborriLista = weborriLista;
	}
	
	

	

	
}
