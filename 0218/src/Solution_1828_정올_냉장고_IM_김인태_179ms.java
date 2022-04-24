import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1828_정올_냉장고_IM_김인태_179ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Node[] arr = new Node[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.max, o2.max);
			}
		});
		
		int ans=1;
		int range = arr[0].max;
		for(int i=1;i<N;i++) {
//			System.out.println(arr[i].min);
			if(range<arr[i].min) {
				range = arr[i].max;
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	public static class Node{
		int min;
		int max;
		public Node(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}
}
