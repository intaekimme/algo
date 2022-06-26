import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_1919_애너그램만들기_B2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int[] alph1 = new int[26];
		int[] alph2 = new int[26];
		
		for(int i=0; i<str1.length; i++){
			alph1[str1[i] - 'a']++;
		}
		for(int i=0; i<str2.length; i++){
			alph2[str2[i] - 'a']++;
		}
		
//		System.out.println(Arrays.toString(alph1));
//		System.out.println(Arrays.toString(alph2));
		
		int ans = 0;
		for(int i=0; i<26; i++) {
			ans += Math.max(alph1[i], alph2[i]) - Math.min(alph1[i], alph2[i]);
		}
		System.out.println(ans);
	}

}
