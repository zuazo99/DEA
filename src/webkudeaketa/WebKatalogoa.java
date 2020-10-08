package webkudeaketa;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class WebKatalogoa { //klase hau EMA,singleton patroia
	//atributuak
	private ArrayList<WebOrri> lista;
	private static WebKatalogoa nireWebOrriak=null;
	private HashMap<String,WebOrri> mapaWebOrriak=new HashMap<String, WebOrri>();//la busqueda por url de key utilizamos la url 
		
	//eraikitzaileak
	private WebKatalogoa(){
		this.lista=new ArrayList<WebOrri>();
		this.mapaWebOrriak=new HashMap<String, WebOrri>();
		
	}
	public static synchronized WebKatalogoa getNireWebOrriak(){
		if(nireWebOrriak==null){
			nireWebOrriak=new WebKatalogoa();
		}
		return nireWebOrriak;
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
		}
	}
	public void gehituArrayList(WebOrri web){
		 this.lista.add(web);
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
		WebOrri web=this.bilatuWebOrri(s);
		return web.getWeborriLista();
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
	
	public void listaKargatu(){
		//aurrebaldintza: fitxategiko datuak string bezala sartuko dira.
		//postbaldintza: fitxategiko datuak kargatuko dira dagokion datu egituran.
		
		try{
			Scanner sc= new Scanner(new FileReader("index"));
			String [] StringMoztu=null;
			WebOrri weborri=null;
			String url=null;
			String indizea=null;
			while(sc.hasNext()){
				StringMoztu=sc.nextLine().split(" ");
				url=StringMoztu[0];
				indizea=StringMoztu[1];
				weborri=new WebOrri(url, Integer.parseInt(indizea));
				this.gehituWebOrria(weborri);//hasmap-era gehitu
				this.gehituArrayList(weborri);//arraylist-era gehitu
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
	
	/*
	public void listaKargatu(String nomF){
		//aurrebaldintza: fitxategiko datuak string bezala sartuko dira.
		//postbaldintza: fitxategiko datuak kargatuko dira dagokion datu egituran.
		try{
			FileReader fr=new FileReader(nomF);
			Scanner sc= new Scanner(fr);
			WebOrri weborri=null;
			String linea;
			int i=0;
			while(sc.hasNextLine()){ //lortzen dugu fitxategiaren datuak y me dice si hay siguiente linea(Booleano)
				linea=sc.nextLine(); //obtengo una linea del fichero
				String [] StringMoztu= linea.split(" "); //Lortzen dugu web orriaren bi datuak, bata linka eta indizea.
				weborri= new WebOrri(); //objetu berrri bat sortzen dugu weborri motatakoa.
				//diria que en la posicion impares del array(StringMoztu) se guardan los indices y pares los links.
				weborri.setUrl(StringMoztu[i]);
				i++;
				weborri.setIndizea(Integer.parseInt(StringMoztu[i])); //parse lo que hace es convertir un string a int.
				this.lista.add(weborri);//gehitzen dugu weborri bat ArrayLista-ra
				//i++;
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
	*/
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
	
	
	
	
	public static void main(String[] args) {
		//postbaldintza: kontsolan kontrol menu bat agertuko da aukerekin.
		int aukera=1000;
		boolean irten=false;
		WebKatalogoa.getNireWebOrriak().listaKargatu();
		GakoHitzKatalogoa.getNireGakoHitzak().listaKargatu();

		while(!irten){
			//Scanner eskaner = new Scanner(System.in);
			System.out.println("Ongi etorri web kudeaketa aplikaziora.");
			System.out.println("Zer egin nahi duzu?\n");
			System.out.println("Aukera hauek dituzu:\n");
			System.out.println("1. Web-orri bat bilatu (1 bat idatzi aukeratzeko)\n ");
			System.out.println("2. Web-orri berri bat txertatu (2 bat idatzi aukeratzeko)\n ");
			System.out.println("3. Web-orri bat ezabatu (3 bat idatzi aukeratzeko)\n ");
			System.out.println("4. Web-orri bat emanda, estekatutako zerrenda bueltatu (4 bat idatzi aukeratzeko)\n ");
			System.out.println("5. Gako hitz bat emanda, gako hitza duten web-orrien zerrenda bueltatu (5 bat idatzi aukeratzeko)\n ");
			System.out.println("6. Web-orrien zerrenda ordenatua lortu (alfabetikoki) (7 bat idatzi aukeratzeko)\n ");
			//Integer aukera=eskaner.nextInt();
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
						System.out.println("Lehenik eta behin idatzi sartu nahi duzun WebOrriaren url-a eta Enter tekla sakatu:\n");
						WebOrri webberria= new WebOrri();
						Scanner eskaner = new Scanner(System.in);
						webberria.setUrl(eskaner.nextLine());
						System.out.println("Orain idatzi sartu nahi duzun WebOrriaren indizea eta Enter tekla sakatu:\n");
						webberria.setIndizea(WebKatalogoa.getNireWebOrriak().irakurriZenb());
						getNireWebOrriak().gehituWebOrria(webberria);
						System.out.println("EGINDA!\n");
						
						
					} else if (aukera==3) {
						//se ejecutarï¿½ el mï¿½todo llamado weborriaEzabatu(); que borrarï¿½ una weborri
					} else if (aukera==4) {
						//se ejecutarï¿½ el mï¿½todo llamado getEstekatutakoZerrenda(); (o algo asi) que devolverï¿½ una zerrenda de web orri
						System.out.println("Lehenik eta behin idatzi sartu nahi duzun WebOrriaren url-a eta Enter tekla sakatu:\n");
						
						Scanner sc = new Scanner(System.in);
						String s=sc.nextLine();
				
						ArrayList<WebOrri> lista=null;
						lista=WebKatalogoa.getNireWebOrriak().irteerakoEstekak(s);
						for(WebOrri x:lista){
							System.out.println(x.getUrl());
						}
					} else if (aukera==5) {
						//se ejecutarï¿½ el mï¿½todo llamado getGakoWeborrienZerrenda(); (o algo asi) que devolverï¿½ una zerrenda de zerrenda de weborri que contengan el gako hitza introducido
						GakoHitzKatalogoa.getNireGakoHitzak().webakKargatu(WebKatalogoa.getNireWebOrriak().getMapaWebOrriak());
						System.out.println("Lehenik eta behin idatzi sartu nahi duzun WebOrriaren url-a eta Enter tekla sakatu:\n");
						Scanner sc = new Scanner(System.in);
						String s=sc.nextLine();
						ArrayList<WebOrri> lista=null;
						lista=GakoHitzKatalogoa.getNireGakoHitzak().word2Webs(s);
						for(WebOrri x:lista){
							System.out.println(x.getUrl());
						}
					} else if (aukera==6) {
						//se ejecutarï¿½ el mï¿½todo llamado zerrendaOrdenatuaLortu; que devolverï¿½ una lista ordenada de weborri
						WebOrri[] web=null;
						web=WebKatalogoa.getNireWebOrriak().ordenatuWebOrriMapa();
						for(int i=0;i<web.length;i++){
							System.out.println(web[i].getUrl()+" "+web[i].getIndizea());
							//i=web[i].
						}
					} else {
						//System.out.println("Ez duzu ondo aukeratu, saiatu berriro;");
						irten=true;
					}	
		}
	
	}
	
	
}
