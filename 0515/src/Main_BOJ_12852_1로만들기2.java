import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main_BOJ_12852_1로만들기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] table = new int[n+1];
		int[] path = new int[n+1];
		
		for(int i=2; i<=n; i++) {
			int min = Integer.MAX_VALUE;
			if(i%3==0 && table[i/3] + 1 < min) {
				min = table[i/3] + 1;
				path[i] = i/3;
			}
			if(i%2==0 && table[i/2] + 1 < min) {
				min = table[i/2] + 1;
				path[i] = i/2;
			}
			if(table[i-1]+1 < min){
				min = table[i-1] + 1;
				path[i] = i-1;
			}
			table[i] = min;
		}
		System.out.println(Arrays.toString(table));
		
		StringBuilder sb = new StringBuilder();
		sb.append(table[n]).append("\n");
		while(n>0) {
			sb.append(n).append(" ");
			n = path[n];
		}
		System.out.println(sb);
	}

}
