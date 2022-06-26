import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 바로 이전 값만이 영향을 미치기에 배열이 필요가 없다. 입력을 받으면서 동시에 증가와 감소를 센다.
 * @author kit938639
 *
 */
public class Main_BOJ_2491_수열_S4 {

	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
 
        int max = 1;
        int iCnt = 1, dCnt = 1;
 
        int prev = Integer.parseInt(st.nextToken());
 
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
 
            iCnt = prev <= num ? iCnt + 1 : 1;
            dCnt = prev >= num ? dCnt + 1 : 1;
 
            max = iCnt > dCnt ? Math.max(max, iCnt) : Math.max(max, dCnt);
            prev = num;
        }
 
        System.out.println(max);
 
    }
}
