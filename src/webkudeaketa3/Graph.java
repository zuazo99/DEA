package webkudeaketa3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import webkudeaketa.WebKatalogoa;
import webkudeaketa.WebOrri;

public class Graph {
	
      HashMap<String, Integer> th;
      String[] keys;
      ArrayList<Integer>[] adjList;
      
      public Graph(){
    	  this.th=new HashMap<String, Integer>();
    	  
      }
	
	public void grafoaSortu(ArrayList<WebOrri> lista){
		// Post: web-en zerrendatik grafoa sortu
		//       Nodoak web-en url-ak dira
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
			adjList= new ArrayList[th.size()];
			
			//for (int indizea=web.getIndizea(); indizea < adjList.length; indizea++) {
				int indizea=web.getIndizea();
				Iterator<WebOrri> itr=web.getWeborriLista().iterator();
				
					while(itr.hasNext()){
						WebOrri weba=itr.next();
						adjList[indizea].add(weba.getIndizea());
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
	
	public boolean erlazionatuta(String a1, String a2){
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
		
		
		/*
		Iterator<Integer> itr=adjList[pos1].iterator();
		while(itr.hasNext()){
			int zbk=itr.next();
			aztertuGabeak.add(zbk);
			aztertuak[zbk]=true;
		}
		*/
        

	}
}
