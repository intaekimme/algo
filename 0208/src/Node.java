
public class Node {
	String data;	//	data 필드
	Node link;		//	link 필드
	
	public Node(String data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}

	public Node(String data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
	
	
	
}
