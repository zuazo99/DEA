package webkudeaketa2;

public class OrderedCircularLinkedList<T extends Comparable<T>> extends CircularLinkedList<T> implements OrderedListADT<T>  {

	public OrderedCircularLinkedList(String info, int count, T elem) {
		super(info, count, elem);
		// TODO Auto-generated constructor stub
	}

	public void add(T elem){
		boolean atera = false,aurkituta = false,begiratuta=false;
		Node<T> act,ant;
		Node<T> berria=new Node<T>(elem);
		
		if(isEmpty()){ //lista hutsa badago
			last=berria;
			berria.hurrengoa=last;
			count++;
		}else{
			act=last.hurrengoa;
			ant=null;
			while(!(atera || aurkituta || begiratuta)){
				if(act.data.compareTo(elem)>0){
					atera=true;
				}
				else if(act.data.compareTo(elem)==0){
					aurkituta=true;
				}
				else if(act==last){
					begiratuta=true;
				}
				else{
					ant=act;
					act=act.hurrengoa;
				}
			}
			if(!aurkituta){
				if(begiratuta && act.data.compareTo(elem)<0 ){
					berria.hurrengoa=act;
					last.hurrengoa=berria;
					last=berria;
					count++;
					
				}else if(act==last.hurrengoa){
					berria.hurrengoa=last.hurrengoa;
					last.hurrengoa=berria;
					count++;
				}
				else{
					berria.hurrengoa=act;
					ant.hurrengoa=berria;
					count++;
					
				}
			}
		}
	}
	


	
	public void merge(OrderedCircularLinkedList<T> z) { 
		// parametro bidezko zerrendako elementuak gehitu dira zerrendara. (O(n) metodoa izan behar du)
		boolean begiratuta=false;
		if(!z.isEmpty()){
			Node<T> unekoaBigarrenLista = z.last;
			this.add(unekoaBigarrenLista.data);
			unekoaBigarrenLista=unekoaBigarrenLista.hurrengoa;
			while(unekoaBigarrenLista!=z.last){
				this.add(unekoaBigarrenLista.data);
				unekoaBigarrenLista=unekoaBigarrenLista.hurrengoa;
			}
		}
		
	}
}
