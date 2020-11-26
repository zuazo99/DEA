package webkudeaketa3;

import java.util.ArrayList;
import java.util.HashMap;

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
			for (int i = 0; i < adjList.length; i++) {
				adjList[i]=web.getWeborriLista();
				
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
	
	public boolean erlazionatuta(String a1, String a2){
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
		
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean aurkitua = false;
		boolean[] aztertuak = new boolean[th.size()];

                 // KODEA INPLEMENTATU    
		
		return aurkitua;

	}
}
