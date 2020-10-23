package webkudeaketa2;

public interface IndexedListADT<T> extends ListADT<T> {

	public void addPosizioan(int index, T elem);
	public void set(int index, T elem);
	public void add(T elem);
	public T get(int index);
	public int indexOf(T elem);
	public T remove(int index);
	
}
