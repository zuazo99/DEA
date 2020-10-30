package webkudeaketa2;

import java.util.Iterator;

public class UnorderedCircularLinkedList<T>  extends CircularLinkedList<T> implements UnorderedListADT<T>{
	

		private UnorderedCircularLinkedList(String info, int count){
			super(info, count, null);

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
