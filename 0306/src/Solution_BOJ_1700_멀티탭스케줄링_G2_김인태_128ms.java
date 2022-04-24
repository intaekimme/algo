import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_1700_멀티탭스케줄링_G2_김인태_128ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] tab = new int[N];

		int[] ready = new int[K];

		for (int i = 0; i < K; i++) {
			ready[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;

		for (int i = 0; i < K; i++) {
			boolean pluggedIn = false;

			// 해당 기기가 꽂혀있는지 확인
			for (int j = 0; j < N; j++)
				if (tab[j] == ready[i])	{
					pluggedIn = true;
					break;
				}
			if (pluggedIn)	continue;

			// 비어있는 구멍 확인
			for (int j = 0; j < N; j++) {
				if (tab[j]==0) {
					tab[j] = ready[i];
					pluggedIn = true;
					break;
				}
			}
			if (pluggedIn) continue;
			
			// 가장 나중에 다시 사용되거나 앞으로 사용되지 않는 기기 찾고
			int idx=0, deviceIdx = -1;
			
			for (int j = 0; j < N; j++) {
				int lastIdx = 0;
				for (int k = i + 1; k < K; k++) {
					if (tab[j] == ready[k])	break;
					lastIdx++;
				}
				if (lastIdx > deviceIdx) {
					idx = j;
					deviceIdx = lastIdx;
				}
			}
			ans++;
			// 앞서 찾은 기기가 꽂혀있던 곳에 현재 꽂을 예정이였던 기기를 꽂음
			tab[idx] = ready[i];

		}
		System.out.println(ans);

	} // end of main

} // end of class

//		첫 시도
//		here: for (int i = 0; i < K; i++) {	//	ready
//			for (int j = 0; j < N; j++) {	//	tab
//				if(tab[j]==0) {	//	tab에 빈 자리가 있으면 꽂는다.	ㄱ
//					tab[j]=ready[i];
//					break;
//				}
//				if(tab[j]==ready[i]) break;	//	해당 제품 한 번 더 사용
//				if(j==N-1) {	//	tab에 빈 자리가 없다. 교체가 필요하다.
//					int last=0;	//	교체 대상
//					for (int l = 0; l < N; l++) {	//	tab을 기준으로 ready에 없으면 앞으로 사용하지 않을 제품이므로 교체 대상
//						for (int l2 = i+1; l2 < K; l2++) {	//	ready
//							if(tab[l]==ready[l2]) break;	//	ready에서 발견하면 사용할 제품이므로 교체 대상 아님
//							else {
//								last=tab[l];	//	ready에서 발견되지 않았으면 사용하지 않을 제품
//							}
//						}
//						if(i==K-1) {	//	마지막에 교체해야 하는 경우
//							tab[0]=ready[i];
//							ans++;
//							break here;	
//						}
//					}
//					for (int l = 0; l < N; l++) {	//	tab에서 교체 대상을 찾아 교체하고 카운트 증가
//						if(tab[l]==last) {
//							tab[l]=ready[i];
//							ans++;
//						}
//					}
//				}
//			}
//		}