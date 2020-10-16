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
		
	}
	public String getDescr(){
		//TODO
	}
	public T removeFirst() {
		
	}
	public T removeLast() {
		
	}
	public T remove(T elem) {
		
	}
	public T first() {
		
	}
	public T last() {
		
	}
	public boolean contains(T elem) {
		
	}
	public T find (T elem) {
		
	}
	public boolean isEmpty() {
		
	}
	public int size() {
		
	}
	public Iterator<T> iterator(){
		
	}
}
