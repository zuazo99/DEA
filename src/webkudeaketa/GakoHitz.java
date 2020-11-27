package webkudeaketa;

import java.util.ArrayList;

import webkudeaketa2.UnorderedCircularLinkedList;

public class GakoHitz {
	//atributuak
	private String hitza;
	private ArrayList<WebOrri> lista;
	private UnorderedCircularLinkedList<WebOrri> zerrenda;
	
	public GakoHitz(String pHitza){
		this.hitza=pHitza;
		this.lista=new ArrayList<WebOrri>();
		this.zerrenda= new UnorderedCircularLinkedList<WebOrri>(null, 0, null);
	}
	
	
	public void gehituWebaUnorderedLinkedList(WebOrri web){
		this.zerrenda.addToFront(web);
	}
	
	public String getHitza() {
		return hitza;
	}
	public void setHitza(String hitza) {
		this.hitza = hitza;
	}
	public ArrayList<WebOrri> getLista() {
		return lista;
	}
	public void setLista(ArrayList<WebOrri> lista) {
		this.lista = lista;
	}
	
	public void gehituWeba(WebOrri web){
		if(web!=null && !this.lista.contains(web)){
			this.lista.add(web);
		}
	}
	public UnorderedCircularLinkedList<WebOrri> getZerrenda(){
		return zerrenda;
	}
	
	
}
