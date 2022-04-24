import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * HashSet을 통한 풀이
 * 비교 대상이 되는 자료가 중복이 없다는 조건이 있고
 * 입력값이 자로 내에 존재하는지 여부만 필요하기에
 * Hash를 통해 확인
 * Integer 변환 없이 String으로 바로 비교
 * @author kit938639
 *
 */


public class Main_BOJ_10815_숫자카드_S4_김인태_1084ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			set.add(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			if(set.contains(st.nextToken()))
				sb.append(1).append(" ");
			else
				sb.append(0).append(" ");
		}
		
		System.out.println(sb);
	}
}
