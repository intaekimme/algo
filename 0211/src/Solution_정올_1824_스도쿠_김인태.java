import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_정올_1824_스도쿠_김인태 {

	static int[][] map;
	static ArrayList<Integer> block;
	static ArrayList<ArrayList<Integer>> row;
	static ArrayList<ArrayList<Integer>> col;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[9][];
		
		//	map 채우기
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = new int[9];
			for(int j=0;j<9;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int[][] checked = new int[9][];
		for(int i=0;i<9;i++) {
			checked[i] = new int[10];
			for(int j=0;j<9;j++) {
				if(map[i][j]!=0) {
					checked[i][map[i][j]]++;
				}	
			}
		}
		
		
		row = new ArrayList<ArrayList<Integer>>();
		int t=0;
		while(t<9) {
			block = new ArrayList<Integer>();
			for(int j=1; j<=9; j++) {
				int tmp = checked[t][j];
				if(tmp!=1)
					block.add(j);					
			}
			row.add(block);
			t++;
		}
		System.out.println(row.toString());
		
//		for(int i=0;i<row.size();i++) {
//			System.out.println(row.get(i));
//		}
		
		
		checked = new int[9][];
		for(int i=0;i<9;i++) {
			checked[i] = new int[10];
			for(int j=0;j<9;j++) {
				if(map[j][i]!=0) {
					checked[i][map[j][i]]++;
				}	
			}
		}
		
//		for(int i=0;i<9;i++) {
//			System.out.println(Arrays.toString(checked[i]));
//		}
		
		col = new ArrayList<ArrayList<Integer>>();
		t=0;
		while(t<9) {
			block = new ArrayList<Integer>();
			for(int j=1; j<=9; j++) {
				int tmp = checked[t][j];
				if(tmp!=1)
					block.add(j);
			}
			col.add(block);
			t++;			
		}
		
		System.out.println(col.toString());
		
//		for(int i=0;i<col.size();i++) {
//			System.out.println(col.get(i));
//		}
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {	//	  i
				block = row.get(i);		//	[[1], [3, 4], [4, 9], [5], [2, 7], [7], [3, 4], [4, 8], [1]]
				int rowSize = block.size();		//	9
				ArrayList<Integer> tmp = new ArrayList<Integer>();
										//	    j
				tmp = col.get(j);		//	[[1, 4], [4, 7], [9], [5], [3, 8], [7], [3], [2, 4], [1, 4]]
				int colSize = tmp.size();		//	9
				
				for(int r=0; r<rowSize; r++) {
					int c=0;
					while(colSize>0) {
						if(block.get(r)==tmp.get(c)) {
							map[i][j] = tmp.get(c);
							
							col.get(j).remove(c);
							row.get(i).remove(r);
							colSize = col.get(j).size();
							c++;
						}						
					}
				}
				
			}
		}
		
		
		for(int i=0;i<9;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		
	}
	
	public static void sol() {
		
	}
	
	

}
