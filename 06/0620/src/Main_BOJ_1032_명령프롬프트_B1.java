import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_BOJ_1032_명령프롬프트_B1 {

	private static int N;
	private static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][50];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int len = map[0].length;
		
		char[] res = map[0];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<len; j++) {
				if(res[j] == '?') continue;
				if(map[i][j] != res[j]) {
					res[j] = '?';
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<len; i++) {
			sb.append(res[i]);
		}
		System.out.println(sb);
	}

}
