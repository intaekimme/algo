import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1100_하얀칸_B2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int res = 0;
		for(int i=1; i<=8; i++) {
			char[] arr = br.readLine().toCharArray();
			if(i%2==1) {
				res += check(1, arr);
			}else {
				res += check(0, arr);
			}
		}
		
		System.out.println(res);
	}

	private static int check(int l, char[] arr) {
		int cnt=0;
		if(l==1) {
			for(int i=0; i<8; i++) {
				if(i%2==0 && arr[i]=='F') cnt++;
			}
		}else {
			for(int i=0; i<8; i++) {
				if(i%2==1 && arr[i]=='F') cnt++;
			}
		}
		return cnt;
	}
}
