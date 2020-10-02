package webkudeaketa;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class WebOrriak { //klase hau EMA,singleton patroia
	//atributuak
	private ArrayList<WebOrri> lista;
	private static WebOrriak nireWebOrriak=null;
	private HashMap<String,WebOrri> listak=new HashMap<String, WebOrri>();//la busqueda por url de key utilizamos la url 
		
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
	
	public void listaKargatu(String nomF){
		try{
			FileReader fr=new FileReader(nomF);
			Scanner sc= new Scanner(fr);
			int i=0;
			while(sc.hasNextLine()){ //lortzen dugu fitxategiaren datuak y me dice si hay siguiente linea(Booleano)
				String linea=sc.nextLine(); //obtengo una linea del fichero
				String [] StringMoztu= linea.split(" "); //Lortzen dugu web orriaren bi datuak, bata linka eta indizea.
				WebOrri weborri= new WebOrri(); //objetu berrri bat sortzen dugu weborri motatakoa.
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
	
	public static int irakurriZenb() throws NumberFormatException {
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
		
		int aukera=1000;
		boolean irten=false;
		WebOrriak.nireWebOrriak.listaKargatu("index");
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
				aukera=WebOrriak.irakurriZenb();
				if(aukera>=1 && aukera<=6){
					aukeraEgokia=true;
				}
				else{
					System.out.println("Aukeratu 1-etik 6-rako zenbaki bat");
				}
			}
					//He hecho todo con ifs que seguramente sean 0 eficientes pero creo que es lo mejor.
					if (aukera == 1){
						//se ejecutar� el m�todo llamado weborriaBilatu(); que buscar� una weborri
					} else if (aukera==2) {
						//se ejecutar� el m�todo llamado weborriaTxertatu(); que meter� una weborri
					} else if (aukera==3) {
						//se ejecutar� el m�todo llamado weborriaEzabatu(); que borrar� una weborri
					} else if (aukera==4) {
						//se ejecutar� el m�todo llamado getEstekatutakoZerrenda(); (o algo asi) que devolver� una zerrenda de web orri
					} else if (aukera==5) {
						//se ejecutar� el m�todo llamado getGakoWeborrienZerrenda(); (o algo asi) que devolver� una zerrenda de zerrenda de weborri que contengan el gako hitza introducido
					} else if (aukera==6) {
						//se ejecutar� el m�todo llamado zerrendaOrdenatuaLortu; que devolver� una lista ordenada de weborri
					} else {
						//System.out.println("Ez duzu ondo aukeratu, saiatu berriro;");
						irten=true;
					}	
		}
	
	}
	
}
