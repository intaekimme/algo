import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2263_트리의순회 {

	private static int N;
	private static int[] in, post, in_idx;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		in = new int[N+1];
		post = new int[N+1];
		in_idx = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
//		중위 순회 값 입력
		for(int i=1; i<=N; i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}
//		후위 순회 값 입력
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}
//		중위순회로 얻은 노드들에 대한 인덱스 값
		for(int i=1; i<=N; i++) {
			in_idx[in[i]] = i;
		}
//		System.out.println(Arrays.toString(in));
//		System.out.println(Arrays.toString(in_idx));
		
		sb = new StringBuilder();
		getPreOrder(1, N, 1, N);
		System.out.println(sb);
	}

	private static void getPreOrder(int is, int ie, int ps, int pe) {
		if(is > ie || ps > pe) return;
		int root = post[pe];
		sb.append(root).append(" ");
		int rootIdx = in_idx[root];
		int left = rootIdx - is;
		
		getPreOrder(is, rootIdx-1, ps, ps+left-1);
		getPreOrder(rootIdx+1, ie, ps+left, pe-1);
	}

}
