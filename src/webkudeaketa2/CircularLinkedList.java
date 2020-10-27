package webkudeaketa2;

import java.util.Iterator;

public class CircularLinkedList<T> implements ListADT<T> {
//ATRIBUTUAK
	private Node<T> last;
	private String deskr;
	private int count;
	
	public CircularLinkedList(String info, int count){//eraikitzailea
		
		this.last=new Node<T>();
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
		if(this.last==this.last.hurrengoa){
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
	public T first() {
		Node<T> lehena;
		lehena=this.last;
		lehena=lehena.hurrengoa;
		return lehena.data;
	}
	public T last() { //listako azken elementua ematen du
	
		
		return this.last.data;
	}
	public boolean contains(T elem) { //Egiazkoa bueltatuko du aurkituz gero, eta false bestela
		
	}
	public T find (T elem) { //Elementua bueltatuko du aurkituz gero, eta null bestela
		
		
		
	}
	public boolean isEmpty() {
		boolean hutsa=false;
		if(this.last.hurrengoa==null){
			hutsa=true;
		}
		
		return hutsa;
	}
	public int size() {
		int kopurua=0;
		
		
		
		
		return kopurua;
	}
	public Iterator<T> iterator(){
		
	}
}
