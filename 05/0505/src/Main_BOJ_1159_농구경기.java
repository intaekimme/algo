import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1159_농구경기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[26];

		for(int i=0; i<N; i++) {
			String player = br.readLine();
			arr[player.charAt(0)-97]++;
		}
		int cnt=0;
		for(int i=0; i<26; i++) {
			if(arr[i]>=5) {
				cnt++;
				System.out.print((char)(i+97));
			}
		}
		if(cnt==0) {
			System.out.println("PREDAJA");
		}
	}

}
