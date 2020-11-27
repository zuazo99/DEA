package webkudeaketa;

import webkudeaketa2.Node;
import webkudeaketa2.UnorderedCircularLinkedList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class WebKatalogoa { //klase hau EMA,singleton patroia
	//atributuak
	private ArrayList<WebOrri> lista;
	private UnorderedCircularLinkedList<WebOrri> zerrenda;
	private static WebKatalogoa nireWebOrriak=null;
	private HashMap<String,WebOrri> mapaWebOrriak=new HashMap<String, WebOrri>();//la busqueda por url de key utilizamos la url 
		
	//eraikitzaileak
	private WebKatalogoa(){
		this.zerrenda=new UnorderedCircularLinkedList<WebOrri>(null, 0, null);
		this.mapaWebOrriak=new HashMap<String, WebOrri>();
		this.lista=new ArrayList<WebOrri>();
		
	}
	public static synchronized WebKatalogoa getNireWebOrriak(){
		if(nireWebOrriak==null){
			nireWebOrriak=new WebKatalogoa();
		}
		return nireWebOrriak;
	}
	private Iterator<WebOrri> getNireIteradorea(){//no se si hay que hacerlo, lo he hecho por si acaso
		return this.lista.iterator();
	}
	public HashMap<String, WebOrri> getMapaWebOrriak() {
		return mapaWebOrriak;
	}
	
	public WebOrri bilatuWebOrri(String url){
		//aurre: String motako url-a sartuko da
		//post: url-a bueltatuko du eta null itzuliko du weborria ez badago
		return this.mapaWebOrriak.get(url);
	}
	
	public void gehituWebOrria(WebOrri web){
		//aurre: weborri bat sartuko da parametro bezala
		//post:weborria HashMapean ez badago bertara gehituko da.
		if(!this.mapaWebOrriak.containsKey(web.getUrl())){
			this.mapaWebOrriak.put(web.getUrl(), web);
		//this.lista.addToRear(web);
		}
	}
	public void gehituWebOrriakUnorderedCircularLinkedList(WebOrri web){
		this.zerrenda.addToFront(web);
	}
	public void gehituArrayList(int x,WebOrri web){
		 this.lista.add(x,web);
	}
	public void ezabatuWeb(String pWeb) {
		int id = this.string2Id(pWeb);
		WebOrri eWeb = this.bilatuWebOrri(pWeb);
		this.lista.remove(id); //arraylist batetik ezabatu
		this.mapaWebOrriak.remove(pWeb); //hasmapetik ezabatu
		}
	
	public WebOrri[] WebOrriHashMapToArray(HashMap<String, WebOrri> mapa){
		//aurre: HashMap bat sartuko da parametro bezala.
		//post: HashMap-a WebOrri lista batean bihurtuko da.
		//beste metodo batzuk gauzatzeko erabilitak
		Object[] lag=mapa.keySet().toArray();
		WebOrri[] emaitza= new WebOrri[lag.length];
		for(int i=0; i<lag.length; i++){
			emaitza[i]=mapa.get(lag[i]);
		}
		return emaitza;
	}
	
	
	public String id2String(int x){
		//Postbaldintza: osoko bat emanda, dagokion web-orria itzuliko du
		WebOrri web=this.lista.get(x);
		String url=null;
		if(web!=null){
			url= web.getUrl();
		}
		return url;
	}
	
	public int string2Id(String s){
		//aurre: String bat (weborri bat) sartuko da parametro bezala.
		//post: Weborii horri dagokion indizea bueltatuko du, adibidez: string2Id(“0-apr-creditcards.com”) → 18
		WebOrri web=null;
		if(this.mapaWebOrriak.containsKey(s)){
			web=this.mapaWebOrriak.get(s);
		}
		return web.getIndizea();
	}
	
	
	public ArrayList<WebOrri> irteerakoEstekak(String s){
		//aurre:url bat emanda
		//post:estekatutako WebOrrien zerrenda
		//bueltatuko du
		if(this.mapaWebOrriak.containsKey(s) || s.equals(null)){
			WebOrri web=this.bilatuWebOrri(s);
			return web.getWeborriLista();
		}else{
			System.out.println("Ez dago izen hori duen Web orririk");
		}
		return null;
	}
	
	public WebOrri[] ordenatuWebOrriMapa(){
		//post: quickSort algortimoa erabiliz weborrien
		//mapa ordenatzen ditu, oso eraginkorra -> O(nlog2n)
		WebOrri[] weborri=this.WebOrriHashMapToArray(mapaWebOrriak);
		quickSort(weborri);
		
		return weborri;
	}
	
		//QuickSort algoritmoa, web orriak ordenatzeko

	
	 public void quickSort(WebOrri[] taula){
			quickSort(taula, 0, taula.length-1);
		  }

	 private void quickSort(WebOrri[ ] taulaBat, int hasiera, int bukaera){
			if ( bukaera - hasiera> 0 ) { // taulan elementu bat baino gehiago
			  int indizeaZatiketa = zatiketa(taulaBat, hasiera, bukaera);
			  quickSort(taulaBat, hasiera, indizeaZatiketa - 1);
			  quickSort(taulaBat, indizeaZatiketa + 1, bukaera);
			}
	 }

	private int zatiketa(WebOrri[] taula, int i, int f) {
			WebOrri lag = taula[i];
			int ezker = i;
			int eskuin = f;
			while ( ezker < eskuin ){
			  while ( taula[ezker].compareTo(lag) <= 0 && ezker < eskuin)
				ezker++;
			  while ( taula[eskuin].compareTo(lag) > 0 )
				eskuin--;
			  if ( ezker < eskuin ) {
				taula = swap(taula, ezker, eskuin);
			  }
			}
			taula[i] = taula[eskuin];
			taula[eskuin] = lag;
			return eskuin;
	}

	private WebOrri[] swap(WebOrri[] taula, int ezker, int eskuin) {
			//quickSort() metodoan erabiltzen da
			WebOrri lag = taula[ezker];
			taula[ezker] = taula[eskuin];
			taula[eskuin] = lag;
			return taula;
	}
	
	
	

	//Fitxategiak tratatzeko metodoak
	
	public void listaKargatuWeb(){
		
		//postbaldintza: fitxategiko datuak kargatuko dira dagokion datu egituran.
		
		try{
			Scanner sc= new Scanner(new FileReader("index"));
			String [] StringMoztu=null;
			WebOrri weborri=null;
			GakoHitz gako=null;
			String subString=null;
			String url=null;
			String indizea=null;
			while(sc.hasNext()){
				StringMoztu=sc.nextLine().split(" ");
				url=StringMoztu[0];
				indizea=StringMoztu[1];
				weborri=new WebOrri(url, Integer.parseInt(indizea));
				this.gehituWebOrria(weborri);//hasmap-era gehitu
				this.gehituArrayList(weborri.getIndizea(),weborri);//arraylist-era gehitu
				this.subStringPosibleak(weborri);
				
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
	
	
	
	public void subStringPosibleak(WebOrri web){
		String emaitza=null;
		GakoHitz gako=null;
		int buk;
		for(int has=0;has<web.getUrl().length(); has++){
			buk=has+3;
			while(buk<web.getUrl().length()){
				emaitza=web.getUrl().substring(has, buk);
				
				gako=GakoHitzKatalogoa.getNireGakoHitzak().gakoaItzuli(emaitza);
				if(gako!=null){
					gako.gehituWeba(web);
					gako.gehituWebaUnorderedLinkedList(web);
					web.gehituGakoa(gako);
				}
				buk++;
			}
		}
		
	}
	public void datuakIrakurriEstekak(){
		String url,url2=null;
		int kont=0;
		try {
			Scanner sc= new Scanner(new FileReader("pld-arcs-1-N"));
			WebOrri web,estekaWeb=null;
			String [] moztu;
			
			String indizea,indizea2=null;
			
			int i;
			while(sc.hasNext()){
				moztu=sc.nextLine().split("\\s+-->");
				String [] estekatuta=null;
				if(moztu.length>=2){
					estekatuta=moztu[1].split("\\s");
				}
				
				url=this.id2String(Integer.parseInt(moztu[0]));
				
				web=this.bilatuWebOrri(url);
				
				if(estekatuta!=null){
					i=1;
					while(i<estekatuta.length){
						web.gehituWebEstekatua(this.bilatuWebOrri(id2String(Integer.parseInt(estekatuta[i]))));
						i++;
					}
				}else{
					System.out.println("Ez dago inolako url honekin konektatuta :(");
					kont++;
				}
				
			}
			System.out.println(kont+"url daude inorekin konektatuta");
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int irakurriZenb() throws NumberFormatException {
		//postbaldintza: zenbaki bat irakurriko du.
		Scanner sc = new Scanner(System.in);
		int zenb = 0;
		boolean denaOndo=false;
		do{
			try{
				String sar=sc.nextLine();
				zenb= Integer.parseInt(sar);
				denaOndo=true;
			}catch(NumberFormatException e){
				System.out.println("Sartutakoa ez da zenbaki bat");
			}
		}while(!denaOndo);
		return zenb;
	}
	
	public void idatziFitxategia(WebOrri[] webak, String helbidea) {
		//Fitxategia existitzen bada ezabatu egiten du,
		//eta berria sortzen du
		Path file = Paths.get(helbidea);
		try {
		  Files.deleteIfExists(file);
		  Files.createFile(file);
		} catch (IOException e) {
		  System.err.println("ERROREA fitxategia sortzen");
		}
		for(int i = 0; i < webak.length; i++) {
		  byte[] data = (webak[i].getUrl()+"\n").getBytes();
		  try {
			Files.write(file, data, StandardOpenOption.APPEND);
		  } catch (IOException e) {
			System.err.println("ERROREA fitxategian idazterakoan");
		  }
		}
	  }
	
	public void idatziFitxategiaWeb(WebOrri[] webak){
		FileWriter fichero = null;
		try {

			fichero = new FileWriter("ordenatuta.txt");

			// Escribimos linea a linea en el fichero
			for (WebOrri x : webak) {
				fichero.write(x + "\n");
			}

			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}
	
	
	//Nagusia, exekutatuko dena.
	
	public static void main(String[] args) {
		//postbaldintza: kontsolan kontrol menu bat agertuko da aukerekin.
		int aukera=1000;
		boolean irten=false;
		GakoHitzKatalogoa.getNireGakoHitzak().listaKargatuGakoak(); //words.txt
		WebKatalogoa.getNireWebOrriak().listaKargatuWeb(); //index
		WebKatalogoa.getNireWebOrriak().datuakIrakurriEstekak(); //pId-arcs-1-N
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(WebKatalogoa.getNireWebOrriak().lista.size()+" weborri ezberdin daude");
		System.out.println("Lista hau "+ WebKatalogoa.getNireWebOrriak().zerrenda.getClass().getName() + " da");
		
		while(!irten){
			
			System.out.println("Ongi etorri web kudeaketa aplikaziora.");
			System.out.println("Zer egin nahi duzu?\n");
			System.out.println("Aukera hauek dituzu:\n");
			System.out.println("1. Web-orri bat bilatu (1 bat idatzi aukeratzeko)\n ");
			System.out.println("2. Web-orri berri bat txertatu (2 bat idatzi aukeratzeko)\n ");
			System.out.println("3. Web-orri bat ezabatu (3 bat idatzi aukeratzeko)\n ");
			System.out.println("4. Web-orri bat emanda, estekatutako zerrenda bueltatu (4 bat idatzi aukeratzeko)\n ");
			System.out.println("5. Gako hitz bat emanda, gako hitza duten web-orrien zerrenda bueltatu (5 bat idatzi aukeratzeko)\n ");
			System.out.println("6. Web-orrien zerrenda ordenatua lortu (alfabetikoki) (6 bat idatzi aukeratzeko)\n ");
			System.out.println("7. Web-orrien zerrenda ordenatua lortu (alfabetikoki) (6 bat idatzi aukeratzeko)\n ");

			System.out.println("8. Grafoa sortu (8 bat idatzi aukeratzeko)\n ");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			boolean aukeraEgokia=false;
			while(!aukeraEgokia){
				aukera=WebKatalogoa.irakurriZenb();
				if(aukera>=1 && aukera<=6){
					aukeraEgokia=true;
				}
				else{
					System.out.println("Aukeratu 1-etik 6-rako zenbaki bat");
				}
			}
					
					if (aukera == 1){
						System.out.println("Idatzi bilatu nahi duzun url-a eta Enter tekla sakatu:\n");
						Scanner eskaner = new Scanner(System.in);
						String urlbilatu=eskaner.nextLine();
						System.out.println("Hona hemen bilaketaren emaitza:\n");
						WebOrri web=WebKatalogoa.getNireWebOrriak().bilatuWebOrri(urlbilatu);
						System.out.println(web.getUrl()+" "+web.getIndizea());
						
						
					} else if (aukera==2) {
						System.out.println("Lehenik eta behin idatzi txertatu nahi duzun WebOrriaren url-a eta Enter tekla sakatu:\n");
						WebOrri webberria= new WebOrri();
						Scanner eskaner = new Scanner(System.in);
						webberria.setUrl(eskaner.nextLine());
						System.out.println("Orain idatzi sartu nahi duzun WebOrriaren indizea eta Enter tekla sakatu:\n");
						webberria.setIndizea(WebKatalogoa.getNireWebOrriak().irakurriZenb());
						getNireWebOrriak().gehituWebOrria(webberria);
						System.out.println("EGINDA!\n");

					} else if (aukera==3) {
						//se ejecutarï¿½ el mï¿½todo llamado weborriaEzabatu(); que borrarï¿½ una weborri
						System.out.println("Lehenik eta behin idatzi ezabatu nahi duzun WebOrriaren url-a eta Enter tekla sakatu:\n");
						Scanner sc = new Scanner(System.in);
						String pWeb=sc.nextLine();
						WebKatalogoa.getNireWebOrriak().ezabatuWeb(pWeb);
					} else if (aukera==4) {
						System.out.println("Lehenik eta behin idatzi WebOrriaren url-a eta Enter tekla sakatu:\n");
						Scanner sc = new Scanner(System.in);
						String s=sc.nextLine();
						
						System.out.println("");
						System.out.println("");
						ArrayList<WebOrri> lista=null;
						
							lista=WebKatalogoa.getNireWebOrriak().irteerakoEstekak(s);
							Iterator<WebOrri> itr=lista.iterator();
							while(itr.hasNext()){
								WebOrri web=itr.next();
								System.out.println(web.getUrl());
							}
						
						/*
						for(WebOrri x : lista){
							System.out.println(x.getUrl()+" "+ x.getIndizea());
						}
						*/
					} else if (aukera==5) {
						System.out.println("Lehenik eta behin idatzi sartu gako hitza eta Enter tekla sakatu:\n");
						Scanner sc = new Scanner(System.in);
						String s=sc.nextLine();
						ArrayList<WebOrri> lista=null;
						lista=GakoHitzKatalogoa.getNireGakoHitzak().word2Webs(s);
						for(WebOrri x : lista){
							System.out.println(x.getUrl());
						}
						//UnorderedCircularLinkedList<WebOrri> zerrenda=new UnorderedCircularLinkedList<WebOrri>(null, 0, null);
						//zerrenda=GakoHitzKatalogoa.getNireGakoHitzak().word2WebsUnordered(s);
						//System.out.println(zerrenda.size() +" weborri kopurua daude "+s+" gakoarekin");
						
					} else if (aukera==6) {
						WebOrri[] web=null;
						web=WebKatalogoa.getNireWebOrriak().ordenatuWebOrriMapa();
						for(int i=0;i<web.length;i++){
							System.out.println(web[i].getUrl()+" "+web[i].getIndizea());
							
						}
					} else if (aukera==7) {
						System.out.println("Lehenik eta behin idatzi sartu nahi duzun helbidea:\n");
						Scanner sc = new Scanner(System.in);
						String s=sc.nextLine();
						WebOrri [] webLista=WebKatalogoa.getNireWebOrriak().ordenatuWebOrriMapa();
						WebKatalogoa.getNireWebOrriak().idatziFitxategia(webLista, s); //Lehenengo aukera
						WebKatalogoa.getNireWebOrriak().idatziFitxategiaWeb(webLista); //Bigarren aukera
					}
					
					else {
						//System.out.println("Ez duzu ondo aukeratu, saiatu berriro;");
						irten=true;
					}	
		}
	
	}
	
	
}

	

