import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 가로 : x, 	세로 : y
 * x >= a + 2h;
 * y >= b + 2h;
 * 
 * 상자의 부피(V) = a*b*h
 * 
 * ex) x = 3, y=3;
 * x(=3) >= a + 2h
 * y(=3) >= b + 2h
 * 
 * x-2h >= a;
 * y-2h >= b;
 * 
 * V = (x-2h) * (y-2h) * h
 * 	= (3-2h) * (3-2h) * h
 *  = (9 - 12h + 4h^2)*h
 *  = 4h^3 - 12h^2 + 9h
 *  
 *  = (2h-x)*(2h-y)*h
 *  
 * @author kit938639
 *
 */




public class Solution_IM_테스트용문제 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			double h = (x+y)/6;
			
			double V = x*y*h - 2*x*h*h -2*y*h*h + 4*h*h*h;
			
			System.out.println("#"+tc+" "+h);
			
		}
	}

}
