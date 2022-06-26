import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;


// 144ms
public class Solution_BOJ_2667_단지번호붙이기_김인태_144ms {

	static char[][] map;
    static int N, cnt;
    static boolean[][] visit;

    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = {  0, 0,-1, 1 };

    static Queue<Node> queue = new ArrayDeque<Node>();
    static ArrayList<Integer> al = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    
        map = new char[N][];
        visit = new boolean[N][N]; // default : false
    
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    
        //	모든 좌표 체크
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if( map[i][j] != '1' || visit[i][j] ) continue;
                bfs( i, j );
                al.add(cnt);
            }
        }
        
        //	출력 내용 정렬	
        Collections.sort(al);
        System.out.println(al.size());
        for (int n : al) {
            System.out.println(n);
        }

    }

    static void bfs(int y, int x ) {
        cnt = 1;
        visit[y][x] = true;
        queue.offer(new Node(y, x));
    
        while( ! queue.isEmpty() ) {
        
            Node node = queue.poll();
        
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
            
                if( ny < 0 || nx < 0 || ny >= N || nx >= N ) continue;
                if( map[ny][nx] != '1' || visit[ny][nx] ) continue;
            
                cnt++;
                visit[ny][nx] = true;
                queue.offer(new Node(ny, nx));
            }
        
        }
    }

    static class Node{
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
	
	
}	//	end of class