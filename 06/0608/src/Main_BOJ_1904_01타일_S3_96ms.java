import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치수열 문제
 * N=1 일 때
 * f(1) = 1
 * 
 * N=2 일 때
 * f(2) = 00
 * 		  11 으로 총 2
 * 
 * N=3 일 때
 * f(3) = 00 1
 * 		  11 1 - f(2)의 결과에 1을 붙임 
 * 		  
 * 		  1 00 - f(1)의 결과에 00을 붙임 으로 총 3
 * 
 * N=4 일 때
 * f(4) = 001 1
 * 		  111 1
 * 		  100 1 - f(3)의 결과에 1을 붙임
 * 		
 * 		  00 00
 * 		  11 00 - f(2)의 결과에 00을 붙임 으로 총 5
 * 
 * N=5 일 때
 * f(5) = 0011 1
 * 		  1111 1
 * 		  1001 1
 * 		  0000 1
 * 		  1100 1 - f(4)의 결과에 1을 붙임
 * 
 * 		  001 00
 * 		  111 00
 * 		  100 00 - f(3)의 결과에 00을 붙임
 * 과 같은 규칙성을 지님
 * 
 * 타입주의!
 * long 타입으로는 결과를 다 구하고 마지막에 나머지 연산을 하는 방식으로는 표현 불가
 * BigInteger 타입으로는 heap space 영역 침범함
 * 
 * int 형으로 사용하는 대신 다 구하고 마지막에 나머지 연산을 하는 것이 아닌
 * 모듈러 덧셈 연산 이용
 * f(n) mod m = (f(n-2) mod m + f(n-1) mod m ) mod m
 * 
 * 모듈러 연산 추가 자료 : https://ko.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/modular-addition-and-subtraction
 * @author kit938639
 *
 */
public class Main_BOJ_1904_01타일_S3_96ms {

	private static int N;
	private static int[] arr;
	private static final int m = 15746;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[1_000_001];
		arr[1] = 1;
		arr[2] = 2;
		for(int i=3; i<=N; i++) {
			arr[i] = (arr[i-2] % m + arr[i-1] % m) % m;
		}
		
		System.out.println(arr[N]);
	}

}
