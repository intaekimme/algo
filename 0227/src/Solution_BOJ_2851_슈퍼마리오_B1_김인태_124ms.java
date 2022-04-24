import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 누적합
 * 버섯을 먹는 것을 중단한다 = 누적합 종료
 * 100에 최대한 가깝게
 * 100에 가까운 수가 2개라면(거리가 같다면) 더 큰 수 선택
 * 
 * 100을 넘을 때 까지 입력을 계속 더한다.
 * 100을 넘으면 절댓값으로 거리 비교
 * 거리가 작은 것이 우선
 * 거리가 같다면 큰 값 우선
 * @author kit938639
 *
 */


public class Solution_BOJ_2851_슈퍼마리오_B1_김인태_124ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans=0;
		boolean isPrint=false;
		for(int i=0;i<10;i++) {
			int val = Integer.parseInt(br.readLine());
			ans += val;
			if(ans>=100) {
				int tmp = ans-val;	//	100 넘어가기 전 값
				if(100-tmp < ans-100) {
					System.out.println(tmp);
				}else {
					System.out.println(ans);
				}
				isPrint = true;
				break;
			}
		}	//	end of for
		if(!isPrint)
			System.out.println(ans);
		
	}	//	end of main

}	//	end of class


//10
//20
//30
//40
//50
//60
//70
//80
//90
//100

//100

//1
//2
//3
//5
//8
//13
//21
//34
//55
//89

//87

//40
//40
//40
//40
//40
//40
//40
//40
//40
//40

//120
