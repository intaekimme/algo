import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10815_숫자카드_S4_김인태_792ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int offset = 10000001;
		boolean[] arr = new boolean[20000001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(st.nextToken()) + offset] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			if(arr[Integer.parseInt(st.nextToken()) + offset])
				sb.append(1).append(" ");
			else 
				sb.append(0).append(" ");
		}
		
		System.out.println(sb);
	}

}
