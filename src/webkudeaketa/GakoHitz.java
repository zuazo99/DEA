package webkudeaketa;

import java.util.ArrayList;

public class GakoHitz {
	//atributuak
	private String hitza;
	private ArrayList<WebOrri> lista;
	
	public GakoHitz(String pHitza){
		this.hitza=pHitza;
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
	
	
}
