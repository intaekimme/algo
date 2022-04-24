import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정올_2577_회전초밥_김인태 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] kind = new int[d+1];
		int[] belt = new int[N];
		
		for(int i=0;i<N;i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		// 찾기 시작

		int ans = 0;
		for(int i=0; i<k; i++) {
			if(kind[belt[i]]==0) {
				ans++;
			}
			kind[belt[i]]++;
		}
		System.out.println(Arrays.toString(kind));
		int cnt = ans; // 초밥 가짓수
		for(int i=0; i<N; i++) {
			if(cnt>=ans) {
				if(kind[c]==0) ans = cnt+1;
				else ans = cnt;
			}
			kind[belt[i]]--;
			if(kind[belt[i]]==0) cnt--;
			if(kind[belt[(i+k)%N]]==0) cnt++;
			kind[belt[(i+k)%N]]++;
		}
		
		
		System.out.println(ans);
	}

}

//중복연산을 초래한다.
//while(left < N) {	// left 커서가 belt 배열의 끝을 넘으면 모두 탐색한 것이다.
//	int cnt=0;
//	// 연속 k개 체크, 우측이 배열의 범위를 벗어날 수 있으므로 모드연산
//	for(int i=left; i<=right; i++) {
//		if(kind[belt[i%N]] != true) {
//			kind[belt[i%N]] = true;
//			cnt++;
//		}
//	}
//	// 쿠폰 체크
//	if(kind[c] != true) cnt++;
//	
//	if(max<cnt) max = cnt; // 다 센 초밥의 가짓수가 지금까지의 최대 가짓수보다 많으면 갱신
//	
//	// belt 배열 초기화
//	Arrays.fill(kind, false);
//	
//	// 윈도우 이동
//	left++;
//	right++;
//}