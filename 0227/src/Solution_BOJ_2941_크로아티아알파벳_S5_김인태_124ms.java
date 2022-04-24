import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_BOJ_2941_크로아티아알파벳_S5_김인태_124ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = new char[101];
		Arrays.fill(str, '0');
		char[] tmp = br.readLine().toCharArray();
		for(int i=0; i < tmp.length; i++) {
			str[i]=tmp[i];
		}
		
		int cnt=0;
		
		for (int i = 0; str[i]!='0' ; i++) {
			if (str[i] == 'c') {
				if (str[i + 1] == '=' || str[i + 1] == '-') {
					cnt++;
					i = i + 1;
					continue;
				}
				else {
					cnt++;
				}
			}
			else if (str[i] == 'd') {
				if (str[i + 1] == 'z' && str[i + 2] == '=') {
					cnt++;
					i = i + 2;
					continue;
				}
				else if (str[i + 1] == '-') {
					cnt++;
					i = i + 1;
					continue;
				}
				else {
					cnt++;
				}
			}
			else if (str[i] == 'l' || str[i] == 'n') {
				if (str[i + 1] == 'j') {
					cnt++;
					i = i + 1;
					continue;
				}
				else {
					cnt++;
				}
			}
			else if (str[i] == 's' || str[i] == 'z') {
				if (str[i + 1] == '=') {
					cnt++;
					i = i + 1;
					continue;
				}
				else {
					cnt++;
				}
			}
			else {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
