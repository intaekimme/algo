import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2 {
	
	
	private static char[] ch;
	private static int[] alph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ch = br.readLine().toCharArray();
		
		alph = new int[26];
		for(int i=0; i<ch.length; i++) {
			alph[ch[i]-'a']++;
		}
		
		int max = 0;
		int idx = 0;
		for(int i=0; i<26; i++) {
			if(alph[i] > max) {
				max = alph[i];
				idx = i;
			}
		}
		
//		System.out.println((char)(idx+'a')+", "+);
		
	}
}
