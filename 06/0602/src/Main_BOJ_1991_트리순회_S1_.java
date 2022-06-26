import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1991_트리순회_S1_ {

	static class Node {
		char data;
		Node left;
		Node right;
		
		public Node(char name) {
			super();
			this.data = name;
			this.left = null;
			this.right = null;
		}
		
	}
	
	static class Tree {
		public Node root;
		
		public void createNode(char data, char leftData, char rightData) {
			if(root == null) {
				root = new Node(data);
				root.left = leftData != '.' ? new Node(leftData) : null;
				root.right = rightData != '.' ? new Node(rightData) : null;
			}else {
				searchNode(root, data, leftData, rightData);
			}
		}

		public void searchNode(Node node, char data, char leftData, char rightData) {
			if(node == null) {
				return;
			}else if (node.data == data) {
				node.left = leftData != '.' ? new Node(leftData) : null;
				node.right = rightData != '.' ? new Node(rightData) : null;
			}else {
				searchNode(node.left, data, leftData, rightData);
				searchNode(node.right, data, leftData, rightData);
			}
		}
		
		public void preOrder(Node node) {
			if(node != null) {
				System.out.print(node.data);
				if(node.left != null) preOrder(node.left);
				if(node.right != null) preOrder(node.right);
			}
		}
		
		public void inOrder(Node node) {
			if(node != null) {
				if(node.left != null) inOrder(node.left);
				System.out.print(node.data);
				if(node.right != null) inOrder(node.right);				
			}
		}
		
		public void postOrder(Node node) {
			if(node != null) {
				if(node.left != null) postOrder(node.left);
				if(node.right != null) postOrder(node.right);				
				System.out.print(node.data);
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		Tree tree = new Tree(); 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			tree.createNode(root, left, right);
		}
		
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}
}
