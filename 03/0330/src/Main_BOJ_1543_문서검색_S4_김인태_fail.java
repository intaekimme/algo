import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1543_문서검색_S4_김인태_fail {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] doc = br.readLine().toCharArray();
		char[] word = br.readLine().toCharArray();
				
		
		int idx = 0;		//	doc 커서
		int dlen = doc.length;
		int wlen = word.length;
		
		int cnt = 0;
		
		while(idx + wlen -1 <= dlen-1) {
			if(doc[idx]==word[0]) {
				if(doc[idx+wlen-1] == word[wlen-1]) {
					for(int i=1; i<=wlen-1; i++) {
						if(doc[idx+i] != word[i]) break;
						if(i==wlen-1) {
							cnt++;
							idx = idx+wlen;
							break;
						}
					}
				}else {
					idx = idx+wlen;
				}
			}else {
				idx++;
			}
		}	//	end of while
		
		System.out.println(cnt);
	}

}
