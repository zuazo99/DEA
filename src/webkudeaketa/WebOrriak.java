package webkudeaketa;

import java.util.ArrayList;

public class WebOrriak { //klase hau EMA
	private ArrayList<webOrri> lista;
	private static webOrriak nireWebOrriak=null;
	
	private WebOrriak(){
		this.lista=new ArrayList<webOrri>();
	}
}
