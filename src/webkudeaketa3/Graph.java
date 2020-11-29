package webkudeaketa3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;
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
  	  	this.keys = new String[lista.size()];
  	  	
  	  	//hasieratzeko
		for (int i = 0; i < lista.size(); i++) {
			this.adjList[i]=new ArrayList<Integer>();
		}
		
		Iterator<WebOrri> iterar=lista.iterator();
		while(iterar.hasNext()){
			
			WebOrri web=iterar.next();
			 
			// 1. pausua:  “th” bete            
			
			gehituWebOrria(web);
			
			 
			// 2. pausua: “keys” bete			
			
			keys[th.get(web.getUrl())] = web.getUrl();
			
			// 3. pausua: “adjList” bete            
			
			int indizea=web.getIndizea();
			ArrayList<WebOrri> listaEstekatua=web.getWeborriLista();
			if(listaEstekatua!=null){
				Iterator<WebOrri> itr=listaEstekatua.iterator();
				
				while(itr.hasNext()){
					WebOrri weba=itr.next();
					adjList[indizea].add(weba.getIndizea());
				}
			}
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
		ArrayList<String> emaitza=new ArrayList<String>();
		String[] bidea =new String[th.size()];
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
        				 bidea[zbk]=url;
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
					 String hitza=bidea[i];
					 emaitza.add(hitza);
					 i=th.get(hitza);
				}else{
					bukatuta=true;
				}
			 }
				
			}
		 
		 return emaitza;
	}
	public void probaEnpirikoak(){
		Object[] values=th.keySet().toArray();
		long denbora=0;
		int n=100;
		int t=0;
		int f=0;
		
		for(int i=1;i<=n;i++){
			double r1=(Math.random() * ((values.length-1)));
			double r2=(Math.random() * ((values.length-1)));
			
			int z1=(int) Math.round(r1);
			int z2=(int) Math.round(r2);
			
			String randomValue1 = values[z1].toString();
			String randomValue2 = values[z2].toString();
			
			long startTime = System.currentTimeMillis();
			
			if(this.erlazionatuta(randomValue1, randomValue2)) {
				 	t++;
			}else {
				 	f++;
			}
			long endTime = System.currentTimeMillis();
				denbora = denbora + (endTime-startTime);
				 if(i% 10 == 0) {System.out.println(i+" proba egin ditut");
				
				 }

		}
		
		System.out.println(t+ "True kasu egon dira");
		System.out.println(f+ "False kasu egon dira");
		System.out.println((denbora/n)+" Milisegundo behar ditu batazbeste,konexioa egiaztatzeko");
	}
	
}
