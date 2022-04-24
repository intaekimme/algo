import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_회전초밥_sol {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		int[] check = new int[d+1];
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
//		int cnt=0;
//		for(int i=0;i<k;i++) {
//			if(check[arr[i]]==0) cnt++;
//			check[arr[i]]++;
//		}
		
		int r=0;
		int ans = 0;
		for(int i=0; i<n; i++) {
			while(ans<k && r<n) {
				if(check[arr[r]]==0) {
					check[arr[r]]++;
					ans++;
					r++;
				}else {
					r++;					
				}
			}
			if(ans==k) {
				if(check[c]==0) ans++;
			}
			check[arr[i]]--;
			ans--;
		}
		
		System.out.println(ans);
	}

}
