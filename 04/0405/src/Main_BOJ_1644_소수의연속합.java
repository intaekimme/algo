import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;

// 틀렸습니다
// 한번 더 풀어보기
public class Main_BOJ_1644_소수의연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
			
		// ArrayList로 구현
		ArrayList<Boolean> primeList;
		
		// 사용자로부터의 콘솔 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		// n <= 1 일 때 종료
		if (n <= 1) {
			System.out.println(0);
			return;
		}
		
		// n+1만큼 할당
		primeList = new ArrayList<Boolean>(n + 1);
		// 0번째와 1번째를 소수 아님으로 처리
		primeList.add(false);
		primeList.add(false);
		// 2~ n 까지 소수로 설정
		for (int i = 2; i <= n; i++)
			primeList.add(i, true);
		
		// 2 부터 ~ i*i <= n
		// 각각의 배수들을 지워간다.
		for (int i = 2; (i * i) <= n; i++) {
			if (primeList.get(i)) {
				for (int j = i * i; j <= n; j += i)
					primeList.set(j, false);
				// i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
			
//		StringBuffer sb = new StringBuffer();
//		sb.append("{");
			for (int i = 0; i <= n; i++) {
				if (primeList.get(i) == true) {
					list.add(i);
//				sb.append(i);
//				sb.append(",");
				}
//			if(i%100==0) sb.append("\n");
			}
//		sb.setCharAt(sb.length() - 1, '}');
			
//		System.out.println(sb.toString());
//		System.out.println(primeList.size());
			
		int r=0;
		int cnt=0;
		int sum=0;
		int size = list.size();
		for(int i=0; i<size; i++) {
			while(sum<n && r<size) {
				sum+=list.get(r);
				r++;
			}
			if(sum==n) cnt++;
			sum-=list.get(i);
		}
		
		System.out.println(cnt);
	}

}
