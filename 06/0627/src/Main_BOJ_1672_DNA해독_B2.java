import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_BOJ_1672_DNA해독_B2 {

	static char[][] rule = {{'A','C','A','G'},
			{'C','G','T','A'},
			{'A','T','C','G'},
			{'G','A','G','T'}
	};
	
	static char[] dna;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dna = br.readLine().toCharArray();
		
		if(N==1) {
			System.out.println(dna[0]);
			System.exit(0);
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('G', 1);
		map.put('C', 2);
		map.put('T', 3);
		
		if(N==2) {
			System.out.println(rule[map.get(dna[N-2])][map.get(dna[N-1])]);
			System.exit(0);
		}
		
		char res = rule[map.get(dna[N-2])][map.get(dna[N-1])];
		for(int i = N-3; i>=0; i--) {
			res = rule[map.get(dna[i])][map.get(res)];
		}
		System.out.println(res);
		
//		System.out.println(Arrays.toString(dna));
	}

}
