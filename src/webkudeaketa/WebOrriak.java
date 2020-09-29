package webkudeaketa;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

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
				i++;
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
	public static void Nagusia(String[] args) {
		Scanner eskaner = new Scanner(System.in);
		System.out.println("Ongi etorri web kudeaketa aplikaziora.");
		System.out.println("Zer egin nahi duzu?\n");
		System.out.println("Aukera hauek dituzu:\n");
		System.out.println("1. Web-orri bat bilatu (1 bat idatzi aukeratzeko)\n ");
		System.out.println("2. Web-orri berri bat txertatu (2 bat idatzi aukeratzeko)\n ");
		System.out.println("3. Web-orri bat ezabatu (3 bat idatzi aukeratzeko)\n ");
		System.out.println("4. Web-orri bat emanda, estekatutako zerrenda bueltatu (4 bat idatzi aukeratzeko)\\n ");
		System.out.println("5. Gako hitz bat emanda, gako hitza duten web-orrien zerrenda bueltatu (5 bat idatzi aukeratzeko)\n ");
		System.out.println("6. Web-orrien zerrenda ordenatua lortu (alfabetikoki) (7 bat idatzi aukeratzeko)\n ");
		Integer aukera=eskaner.nextInt();
		boolean irten=false;
		while (!irten) || ((aukera!=1) && (aukera!=2) && (aukera!=3) && (aukera!=4) && (aukera!=5) && (aukera!=6)){
			//He hecho todo con ifs que seguramente sean 0 eficientes pero creo que es lo mejor.
			if (aukera == 1){
				//se ejecutará el método llamado weborriaBilatu(); que buscará una weborri
			} else if (aukera==2) {
				//se ejecutará el método llamado weborriaTxertatu(); que meterá una weborri
			} else if (aukera==3) {
				//se ejecutará el método llamado weborriaEzabatu(); que borrará una weborri
			} else if (aukera==4) {
				//se ejecutará el método llamado getEstekatutakoZerrenda(); (o algo asi) que devolverá una zerrenda de web orri
			} else if (aukera==5) {
				//se ejecutará el método llamado getGakoWeborrienZerrenda(); (o algo asi) que devolverá una zerrenda de zerrenda de weborri que contengan el gako hitza introducido
			} else if (aukera==6) {
				//se ejecutará el método llamado zerrendaOrdenatuaLortu; que devolverá una lista ordenada de weborri
			} else {
				System.out.println("Ez duzu ondo aukeratu, saiatu berriro;");
				irten=true;
			}
		Nagusia(String[]); //Para que se vuelva a ejecutar		
		
	}
	
}
