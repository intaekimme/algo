import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 배열 초기화
		
		// 수열은 사전순으로 증가해야하므로 배열을 초기에 오름차순으로 정렬
		Arrays.sort(arr);
		
		// 중복 x , 조합
		comb(0, new int[M], 0);
		System.out.print(sb);
	}
	static void comb(int cnt, int[] selected, int startIdx) {
		if(cnt == M) {
			for(int i=0;i<cnt;i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i=startIdx;i<N;i++) {
			selected[cnt]= arr[i];
			comb(cnt+1, selected, i+1);
		}
	}
}
