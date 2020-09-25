package webkudeaketa;

import java.util.*;

public class GakoHitzak { //EMA orduan singleton patroia
	//atributuak
	private ArrayList<Gako> listagako;
	private static GakoHitzak nireGakoHitzak=null;
	
	//eraikitzaileak
	
	private GakoHitzak(){
		this.listagako= new ArrayList<Gako>();
	}
	
	public static synchronized GakoHitzak getNireGakoHitzak(){
		if(nireGakoHitzak==null){
			nireGakoHitzak=new GakoHitzak();
		}
		return nireGakoHitzak;
	}
	
}
