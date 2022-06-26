import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_3036_링_S3_김인태 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<N;i++) {
			int gcd = gcd(arr[0], arr[i]);
			sb.append(arr[0]/gcd).append("/").append(arr[i]/gcd).append("\n");
		}
		
		System.out.println(sb);
	}	//	end of main
	
	
	public static int gcd(int a, int b) {
		int r=0;
		if(a<b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		while(b!=0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}	//	end of gcd

}	//	end of class


//	for(int i=1;i<N;i++) {
//		boolean flag=true;
//		if(arr[i]!=1 && arr[i]!=arr[0]) {
//			for(int j=2; j<=Math.max(arr[0], arr[i]) ;j++) {
//				if(arr[0]%j==0 && arr[i]%j==0) {
//					int[] tmp = new int[2];
//					tmp[0] = arr[0];
//					tmp[1] = arr[i];
//					while(tmp[0]%j==0 && tmp[1]%j==0) {
//						tmp[0]/=j;
//						tmp[1]/=j;
//					}
//					sb.append(tmp[0]).append("/").append(tmp[1]).append("\n");
//					flag = false;
//					break;
//				}
//			}	//	end of inner for
//			if(flag)
//				sb.append(arr[i]).append("/").append(arr[0]).append("\n");
//		}	//	end of if
//		else {
//			if(arr[i]==1)	sb.append(arr[0]).append("/").append(1).append("\n");
//			if(arr[i]==arr[0])	sb.append(1).append("/").append(1).append("\n");
//		}
//	}	//	end of outter for