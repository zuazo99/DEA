package webkudeaketa2;

import java.util.Iterator;

public class UnorderedCircularLinkedList<T>  extends CircularLinkedList<T> implements UnorderedListADT<T>{
	

		private UnorderedCircularLinkedList(String info, int count){
			super(info, count, null);

		}
		public void setDescr(String izena) {
			
			
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

		public void addToFront(T elem) { //elementua gehitzen du hasieran
				
				Node<T> ulti,leh = null;
				
				if (super.isEmpty()) {
					last = new Node<T>(elem);
					//last.data=elem;
					last.hurrengoa = last;
					ulti=last;
					leh=last;
				}
				else if(last.hurrengoa==null){
					last.hurrengoa=new Node<T>(elem);
					ulti=last.hurrengoa;
					leh=last.hurrengoa;
					//ulti.data=elem;
					ulti.hurrengoa=last;
				}
				else{
					Node<T> berria= new Node<T>(elem);
					//berria.data=elem;
					berria.hurrengoa=leh;
					last.hurrengoa=berria;
					leh=berria;
				}
					/*
					berria.hurrengoa=first();
					first()=berria;
					*/
			}
			


		public void addToRear(T elem) { //azkenengo posizioan gehitu elementua
			// TODO Auto-generated method stub
			if (super.isEmpty()){
				addToFront(elem);
			}
			else{
				Node<T> aux = last.hurrengoa;
				Node<T> berria = new Node<T>(elem);
				berria.hurrengoa=aux;
				last.hurrengoa=berria;
				last=berria;
			}


			
		}

		public void addAfter(T elem, T target){ // elementua gehitzen du target elementuaren ondoren (target zerrendan dago)
			// TODO Auto-generated method stub
			Node<T> act=this.last.hurrengoa;
			boolean aurkituta=false;
			while(act!=this.last && !aurkituta){
				if(act.data.equals(target)){
					aurkituta=true;
				}else{
					act=act.hurrengoa;
				}
			}
			if(aurkituta){
				Node<T> berria=new Node(elem);
				//berria.data=elem;
				berria.hurrengoa=act.hurrengoa;
				act.hurrengoa=berria;
			}
		}
}
