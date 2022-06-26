import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exer1 {

	static int N, numbers[], totalCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		
		int M = Integer.parseInt(br.readLine());
		switch (M) {
		case 1:	//	주사위 던지기1 : 중복순열
			dice1(0);
			break;
		case 2:	//	주사위 던지기2 : 순열
			dice2(0, new boolean[7]);
			break;
		case 3:	//	주사위 던지기3 : 중복조합
			dice3(0, 1);
			break;
		case 4:	//	주사위 던지기4 : 조합
			dice4(0, 1);
			break;
		default:
			break;
		}
		System.out.println("총 경우의 수 : " + totalCnt);
	}	//	end of main
	
	//	중복순열
	public static void dice1(int cnt) {
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=1;i<=6;i++) {
			numbers[cnt] = i;
			dice1(cnt+1);
		}
	}
	
	
	//	순열
	public static void dice2(int cnt, boolean[] check) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=1; i<=6; i++) {
			if(check[i])	continue;
			
			numbers[cnt] = i;
			check[i] = true;
			dice2(cnt+1, check);
			check[i] = false;
		}
	}
	
	//	중복조합
	public static void dice3(int cnt, int start) {
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <=6; i++) {
			numbers[cnt] = i;
			dice3(cnt+1, i);
		}
	}
	
	// 	조합
	public static void dice4(int cnt, int start) {
		if(cnt==N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=start;i<=6;i++) {
			numbers[cnt] = i;
			dice4(cnt+1, i+1);
		}
	}

}	//	end of class
