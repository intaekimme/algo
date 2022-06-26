import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}// 배열 초기화
		
		// 오름차순으로 정렬
		Arrays.sort(arr);
		// 중복조합
		ccomb(0, new int[M], 0);
		
		System.out.println(sb);
		
	}
	static void ccomb(int cnt, int[] selected, int startIdx){
		if(cnt == M) {
			StringBuilder tmp = new StringBuilder();
			for(int i=0;i<cnt;i++) {
				tmp.append(selected[i]).append(' ');
			}
			tmp.append('\n');
			String str = tmp.toString();
			
			if(!set.contains(str)) {
				set.add(str);
				sb.append(tmp);
			}
			
			return;
		}
		for(int i=startIdx;i<N;i++) {
			selected[cnt] = arr[i];
			ccomb(cnt+1, selected, i);
		}
	}
}

