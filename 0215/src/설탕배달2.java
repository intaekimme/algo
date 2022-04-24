import java.util.Arrays;
import java.util.Scanner;

public class 설탕배달2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] dp=new int[n+1];
		System.out.println(Arrays.toString(dp));
		try {
			dp[3]=1;
			dp[5]=1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (int i = 6; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp));
			if(dp[i-3]!=0) {
				dp[i]=dp[i-3]+1;	
			}
			System.out.println(Arrays.toString(dp));
			
			if(dp[i-5]!=0) {
				if(dp[i-3]!=0) {
					dp[i]=Math.min(dp[i-3], dp[i-5])+1;
				}else {
					dp[i]=dp[i-5]+1;
				}
			}
			System.out.println(Arrays.toString(dp));
		}
		if(dp[n]==0) {
			System.out.println(-1);
		}else {
			System.out.println(dp[n]);
		}
	}

}
