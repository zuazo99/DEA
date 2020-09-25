package webkudeaketa;

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
}
