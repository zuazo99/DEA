package webkudeaketa2;

public class OrderedCircularLinkedList<T extends Comparable<T>> extends CircularLinkedList<T> implements OrderedListADT<T>  {

	public OrderedCircularLinkedList(String info, int count, T elem) {
		super(info, count, elem);
		// TODO Auto-generated constructor stub
	}

	public void add2(T elem){
		boolean atera = false,aurkituta = false,begiratuta=false;
		Node<T> act,ant;
		Node<T> berria=new Node<T>(elem);
		
		if(isEmpty()){ //lista hutsa badago
			last=berria;
			berria.hurrengoa=last;
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
					
				}else if(act==last.hurrengoa){
					berria.hurrengoa=last.hurrengoa;
					last.hurrengoa=berria;
				}
				else{
					berria.hurrengoa=act;
					ant.hurrengoa=berria;
					
				}
			}
		}
	}
	
	public void add(T elem) {
		Node<T> berria = new Node<T>(elem);
		boolean lehena =false;
		boolean irten =false;
		boolean posbai =false;
		//hiru boolear, lehena pasatu den jakiteko
		//hau da, bukle infinitoa ez egiteko, irten, elem jada istan badago, listan ez sartzeko,
		//eta posbai, elem-ren posizioa aurkitzean aktibatuko dena.
		if (last.hurrengoa==null){//kasu basikoa, lista hutsa
			count++;
			last.hurrengoa=new Node<T>(elem);
			last.hurrengoa.hurrengoa=last.hurrengoa; //hau da, lehenaren hurrengoa-->lehena

		}else{
			Node<T> unekoa = last.hurrengoa;
			while(!posbai && !lehena && !irten){
				if(unekoa.data.compareTo(elem)>0){//elem ez dago listan eta sartuko dugu
					count++;
					if (unekoa==last.hurrengoa){//unekoa lehena bada
						berria.hurrengoa=last.hurrengoa;
						last.hurrengoa.hurrengoa=berria;
						last.hurrengoa=berria;
					}else{//elem erdian txertatzeko
						berria.hurrengoa=unekoa;
						unekoa.hurrengoa=berria.hurrengoa.hurrengoa;
					}
					posbai=true;
				}else{
					if (unekoa.data.equals(elem)){
						irten=true;
					}else {
						unekoa=unekoa.hurrengoa;
					}if (unekoa==last.hurrengoa){
						lehena=true;
					}

				}if (lehena){//amaieran
					berria.hurrengoa=unekoa;
					unekoa.hurrengoa=last.hurrengoa;
				}
			}
		}
	}

	@Override
	public void merge(OrderedCircularLinkedList<T> z) {

	}
}
