package webkudeaketa2;

public class Node<T> {
	T data;
	Node<T> hurrengoa;
	
	public Node(T pData){
		this.data = pData;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getHurrengoa() {
		return hurrengoa;
	}

	public void setHurrengoa(Node<T> hurrengoa) {
		this.hurrengoa = hurrengoa;
	}
	
}
