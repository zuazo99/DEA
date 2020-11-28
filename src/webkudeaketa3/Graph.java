package webkudeaketa3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import webkudeaketa.WebKatalogoa;
import webkudeaketa.WebOrri;

public class Graph {
	
      HashMap<String, Integer> th; //URl bakoitzeko, identifikatzailea
      String[] keys; //Identifikatzaile bakoitzeko, url
      ArrayList<Integer>[] adjList; //URl bakoitza zein URl-ekin erlazionatuta dagoen
      
      public Graph(){
  
      }
	
	public void grafoaSortu(ArrayList<WebOrri> lista){
		// Post: web-en zerrendatik grafoa sortu
		//       Nodoak web-en url-ak dira
		this.th=new HashMap<String, Integer>();
  	  	this.adjList= new ArrayList[lista.size()];
  	  
		for (WebOrri web : lista) {
			 // 1. pausua:  “th” bete            
			// KODEA INPLEMENTATU
			gehituWebOrria(web);
			
			 // 2. pausua: “keys” bete			
			keys = new String[th.size()];
			for (String k: th.keySet()) 
				keys[th.get(k)] = k;
			
			// 3. pausua: “adjList” bete            
			// KODEA INPLEMENTATU
			
			//hasieratzeko
			for (int i = 0; i < lista.size(); i++) {
				this.adjList[i]=new ArrayList<Integer>();
				
			}
			
			//for (int indizea=web.getIndizea(); indizea < adjList.length; indizea++) {

				int indizea=web.getIndizea();
				ArrayList<WebOrri> listaEstekatua=web.getWeborriLista();
				if(listaEstekatua!=null){
					Iterator<WebOrri> itr=listaEstekatua.iterator();
				
					while(itr.hasNext()){
						WebOrri weba=itr.next();
						adjList[indizea].add(weba.getIndizea());
					}
				}
			//}
		}     
	}
	
	//th HashMap-era gehitzeko datuak.
	public void gehituWebOrria(WebOrri web){
		//aurre: weborri bat sartuko da parametro bezala
		//post:weborria HashMapean ez badago bertara gehituko da.
		if(!this.th.containsKey(web.getUrl())){
			this.th.put(web.getUrl(), web.getIndizea());
		}
	}
	
	public void print(){
	   for (int i = 0; i < adjList.length; i++){
		System.out.print("Element: " + i + " " + keys[i] + " --> ");
		for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
		
		System.out.println();
	   }
	}
	
	public boolean erlazionatuta(String a1, String a2){ //zabalera
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
		
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean aurkitua = false;
		boolean[] aztertuak = new boolean[th.size()];
		
		aztertuGabeak.add(pos1);
		aztertuak[pos1]=true;
		
		 while(!(aztertuGabeak.isEmpty()|| aurkitua)){
        	 int unekoa=aztertuGabeak.remove();
			 if(unekoa==pos2){
        		 aurkitua=true;
        	 }else{
        		 Iterator<Integer> itr=adjList[unekoa].iterator();
        		 while(itr.hasNext()){
        			 int zbk=itr.next();
        			 if(!aztertuak[zbk]){
        				 aztertuGabeak.add(zbk);
        				 aztertuak[zbk]=true;
        			 }
        		 }
        		 
        	 }
         }
		 return aurkitua;
	}
	
	public ArrayList<String> erlazionatutaBidea(String a1, String a2){
		ArrayList<String> bidea=new ArrayList<String>();
		ArrayList<String> emaitza=new ArrayList<String>();
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean aurkitua = false;
		boolean[] aztertuak = new boolean[th.size()];
		
		aztertuGabeak.add(pos1);
		aztertuak[pos1]=true;

		 while(!(aztertuGabeak.isEmpty()|| aurkitua)){
			 int unekoa=aztertuGabeak.remove();
			 if(unekoa==pos2){
        		 aurkitua=true;
        	 }else{
        		 Iterator<Integer> itr=adjList[unekoa].iterator();
        		 while(itr.hasNext()){
        			 int zbk=itr.next();
        			 if(!aztertuak[zbk]){
        				 aztertuGabeak.add(zbk);
        				 String url=keys[unekoa];
        				 bidea.add(zbk,url );
        				 aztertuak[zbk]=true;
        			 }
        		 }
        		 
        	 }
		 
		 
		 }
		 
		 
		 if(!aurkitua){
			 emaitza=null;
		 }else{
			 boolean bukatuta=false;
			 int i=pos2;
			 emaitza.add(a2);
			 while(!bukatuta){
				if(i!=pos1){
					 String hitza=bidea.get(i);
					 emaitza.add(hitza);
					 i=th.get(hitza);
				}else{
					bukatuta=true;
				}
			 }
				
			}
		 
		 return emaitza;
	}
}
