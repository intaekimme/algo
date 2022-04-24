import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 첫 접근 : 짝수이면 2개, 홀수이면 1개 생성 -> 틀림 9만되도 2개 가능
 * 두번째 접근 : n의 약수집합에서 nC2? 조합?
 * @author kit938639
 *
 */

public class Solution_BOJ_8320_직사각형을만드는방법_B2_김인태 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		for(int i=1;i<=N;i++) {
			if(i%2==1)
				ans++;
			else
				ans+=2;
		}
		
		System.out.println(ans-1);
	}

}