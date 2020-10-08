package webkudeaketa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GakoHitzKatalogoa { //EMA orduan singleton patroia
	//atributuak
	private ArrayList<GakoHitz> listagako;
	private HashMap<String,GakoHitz> mapaGako=new HashMap<String, GakoHitz>();//la busqueda por url de key utilizamos la url
	private static GakoHitzKatalogoa nireGakoHitzak=null;
	
	//eraikitzaileak
	
	private GakoHitzKatalogoa(){
		this.listagako= new ArrayList<GakoHitz>();
	}
	
	public static synchronized GakoHitzKatalogoa getNireGakoHitzak(){
		if(nireGakoHitzak==null){
			nireGakoHitzak=new GakoHitzKatalogoa();
		}
		return nireGakoHitzak;
	}
	
	public GakoHitz bilatuWebOrri(String s){
		//aurre: String motako hitza sartuko da
		//post: bueltatuko du eta null itzuliko du weborria ez badago
		return this.mapaGako.get(s);
	}
	
	public void gehituWebOrria(GakoHitz gako){
		//aurre: weborri bat sartuko da parametro bezala
		//post:weborria HashMapean ez badago bertara gehituko da.
		if(!this.mapaGako.containsKey(gako.getHitza())){ //devuelve true si la clave indicada existe 
			this.mapaGako.put(gako.getHitza(), gako);
		}
	}
	public void gehituArrayList(GakoHitz gako){
		 this.listagako.add(gako);
	}
	
	
	
	
	
	//Fitxategiak tratatzeko metodoak
	
		public void listaKargatu(){
			//aurrebaldintza: fitxategiko datuak string bezala sartuko dira.
			//postbaldintza: fitxategiko datuak kargatuko dira dagokion datu egituran.
			
			try{
				Scanner sc= new Scanner(new FileReader("words.txt"));
				GakoHitz gako=null;
				String hitza=null;
				
				while(sc.hasNext()){
					hitza=sc.nextLine();
					gako=new GakoHitz(hitza);
					this.gehituWebOrria(gako);//hasmap-era gehitu
					this.gehituArrayList(gako);//arraylist-era gehitu
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
		public void webakKargatu(HashMap<String, WebOrri> mapa){
			
			
			for(Map.Entry<String,GakoHitz> x:this.mapaGako.entrySet()){
				String hitza=x.getKey();
				GakoHitz gakoa=x.getValue();
				for(Map.Entry<String, WebOrri> y:mapa.entrySet()){
					String url=y.getKey();
					WebOrri weba=y.getValue();
					if(url.contains(hitza)){
						gakoa.gehituWeba(weba);
					}
				}
			}
		}
}
