package webkudeaketa2;

import java.util.Iterator;

public class UnorderedCircularLinkedList<T>  extends CircularLinkedList<T> implements UnorderedListADT<T>{
	

		private UnorderedCircularLinkedList(String info, int count){
			super(info, count);

		}
		public void setDescr(String izena) {
			// TODO Auto-generated method stub
			
		}

		public String getDescr() {
			// TODO Auto-generated method stub
			String nombre="jon";//proba bat
			
			return null;
		}

		public T removeFirst() {
			// TODO Auto-generated method stub
			return null;
		}

		public T removeLast() {
			// TODO Auto-generated method stub
			return null;
		}

		public T remove(T elem) {
			// TODO Auto-generated method stub
			return null;
		}

		public T first() {
			// TODO Auto-generated method stub
			return null;
		}

		public T last() {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean contains(T elem) {
			// TODO Auto-generated method stub
			return false;
		}

		public T find(T elem) {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		public void addToFront(T elem) {
				Node berria= new Node();
				berria.data=elem;
				if (first()==null) {
					first() = berria;
					last() = berria;
				}
				else{
					berria.hurrengoa=first();
					first()=berria;
			}
			
		}

		public void addToRear(T elem) {
			// TODO Auto-generated method stub
			if (isEmpty()){
				addToFront(elem);
			}
			else{
				Node aux = first();
				while( aux != null){
					aux=aux.hurrengoa;

				}
				Node berria = new Node();
				berria.data = elem;
				aux.hurrengoa=berria;
			}


			
		}

		public void addAfter(T elem, T target) {
			// TODO Auto-generated method stub
			
		}
}
