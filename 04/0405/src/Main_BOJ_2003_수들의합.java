import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2003_수들의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int r=0;
		int l=0;
		int sum=0;
		int cnt=0;
		while(true) {
			if(sum>=m) sum-=arr[l++];
			else if(r==n) break;
			else sum+=arr[r++];
			if(sum==m) cnt++;
		}
		System.out.println(cnt);
	}

}


//for(int i=0; i<n; i++) {
//	while(sum<m && l<n) {
//		sum+=arr[l++];
//	}
//	if(sum==m) cnt++;
//	sum-=arr[i];
//}