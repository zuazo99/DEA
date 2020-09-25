package webkudeaketa;

import java.util.ArrayList;

public class WebOrri {
	private String url; //la url de cada web, por ejemplo "jimperry.com", es ese formato
	private Integer indizea; //indice correspondiente a cada weborri
	private ArrayList<Gako> gakoak;//gako zerrenda, es decir, un gako para cada web (todas las webs tienen un gako diferente)
	//no se si las arraylist van aquí, pero las pongo para acordarme de momento
	private ArrayList<WebOrri> weborriLista;//web orrien zerrenda
	
	public WebOrri(String webUrl, Integer ind) //ERAIK.
	{url=webUrl;
	indizea=ind;
	}
}
