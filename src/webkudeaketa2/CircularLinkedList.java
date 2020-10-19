package webkudeaketa2;

import java.util.Iterator;

public class CircularLinkedList<T> implements ListADT<T> {
//ATRIBUTUAK
	private Node<T> last;
	private String deskr;
	private int count;
	
	private CircularLinkedList(String info, int count){//eraikitzailea
		
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
			this.last.hurrengoa=null;
			ezabatu=this.last.data;
		}
		else{
			ezabatu=this.last.hurrengoa.data;
			this.last.hurrengoa=this.last.hurrengoa.hurrengoa;
		}
		this.count--;
		return ezabatu;
	}
	public T removeLast() {
		
	}
	public T remove(T elem) {
		
	}
	public T first() {
		Node<T> lehena;
		lehena=this.last;
		lehena=lehena.hurrengoa;
		return lehena.data;
	}
	public T last() {
		
	}
	public boolean contains(T elem) {
		
	}
	public T find (T elem) {
		
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
