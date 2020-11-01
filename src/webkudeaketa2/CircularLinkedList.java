package webkudeaketa2;

import java.util.Iterator;
import java.util.ListIterator;

public class CircularLinkedList<T> implements ListADT<T> {
//ATRIBUTUAK
	protected Node<T> last;
	protected String deskr;
	protected int count;
	
	public CircularLinkedList(String info, int count,T elem){//eraikitzailea
		
		this.last=new Node<T>(elem); 
		this.deskr=info;
		this.count=count;
		
	}

	public void setDescr(String izena) {
		this.deskr=izena;
	}
	public String getDescr(){
		return this.deskr;
	}
	public T removeFirst() {
		T ezabatu = null;
		if(this.last==this.last.hurrengoa){
			this.last=null;
			ezabatu=this.last.data;
		}
		else{
			ezabatu=this.last.hurrengoa.data;
			this.last.hurrengoa=this.last.hurrengoa.hurrengoa;
		}
		this.count--;
		return ezabatu;
	}
	public T removeLast() { //listako azken elementua kendu da
		T ezabatu=this.last.data;
		Node<T> act,ulti;
		
		if(this.isEmpty()){
			return null;
		}
		
		
		else if(this.last==this.last.hurrengoa){
			this.last=null;
			this.count--;
		}
		else{
			act=this.last.hurrengoa;
			while(act.hurrengoa!=this.last){
				act=act.hurrengoa;
			}
			ulti=act;
			act.hurrengoa=this.last.hurrengoa;
			this.last=ulti;
			this.count--;
		}
		
		return ezabatu;
		
	}
	public T remove(T elem) {
		Node<T> act,ant;
		boolean enc=false;
		T ezabatu=null;
		if(!this.isEmpty()){
			act=this.last.hurrengoa;
			ant=this.last;
		
			while(!enc){
				if(act.data.equals(elem)){
					ezabatu=act.data;
					enc=true;
				}
				else{
					ant=act;
					act=act.hurrengoa;
				}
			}
			if(enc){
				if(act==this.last){
					if(ant==act){ //estamos en el primero y hay que borrarlo
						this.last=null;
						this.count--;
					}
					else{
						ant.hurrengoa=act.hurrengoa;
						this.last=ant;
						this.count--;
					}
				}else{
				ant.hurrengoa=act.hurrengoa;
				this.count--;
				}
			}
		}
		return ezabatu;
	}
	public T first() { // listako lehen elementua ematen du
		T emaitza=null;
		Node<T> lehena;
		if(!isEmpty()){
			lehena=this.last;
			if(lehena.hurrengoa==this.last){
				emaitza=last.data;
			}
			else{
				lehena=lehena.hurrengoa;
				emaitza=lehena.data;
			}
		}
		return emaitza;
	}
	public T last() { //listako azken elementua ematen du
		return this.last.data;
	}
	public boolean contains(T elem) { //Egiazkoa bueltatuko du aurkituz gero, eta false bestela
		boolean aurkituta = false,atera;
		Node<T> act;
		if(!this.isEmpty()){ //hutsa ez bada
			act=this.last.hurrengoa;
			atera=false;
			while(!aurkituta && !atera){
				if(act==this.last){ //estamos en el primero y este el elemento o no hay que salir del bucle
					if(act.data.equals(elem)){
						aurkituta=true;
					}
					else{
						atera=true;
					}
				}else if(act.data.equals(elem)){ //erdiko nodo batean gaude 
					aurkituta=true;
				}else{
					act=act.hurrengoa;
				}
				
			}
		}
		return aurkituta;
	}
	
	public T find (T elem) { //Elementua bueltatuko du aurkituz gero, eta null bestela
		Node<T> act;
		boolean aurkituta=false,atera;
		T emaitza=null;
		if(!this.isEmpty()){ //hutsa ez bada
			act=this.last.hurrengoa;
			atera=false;
			while(!aurkituta && !atera){ //(!act.data.equals(elem))
				if(act==this.last){ //estamos en el primero y este el elemento o no hay que salir del bucle
					if(act.data.equals(elem)){
						aurkituta=true;
						emaitza=act.data;
					}
					else{
						atera=true;
					}
				}else if(act.data.equals(elem)){ //erdiko nodo batean gaude 
					aurkituta=true;
					emaitza=act.data;
				}else{
					act=act.hurrengoa;
				}
			}
		}
		return emaitza;
		
	}
	public boolean isEmpty() {
		boolean hutsa=false;
		if(this.last==null){
			hutsa=true;
		}
		
		return hutsa;
	}
	public int size() {	
		return this.count;
	}
	public Iterator<T> iterator() { return new ListIterator(); } 
	
	private class ListIterator implements Iterator<T>{
	
		private Node<T> current;
		private boolean berrizBisitatu;
		private int index = 0;
			public ListIterator(){
				if(!isEmpty()){
					current=last.hurrengoa;
					berrizBisitatu=true;
				}
			}
	
			public boolean hasNext() {
				if(isEmpty() || (current==last.hurrengoa && !berrizBisitatu)){
					return false;
				}
					return true;			
			}
			
			
			public T next() {
				T data=current.data;
				berrizBisitatu=false;
				current=current.hurrengoa;
				index++;
				return data;
			}


			

			
		}
	
}

