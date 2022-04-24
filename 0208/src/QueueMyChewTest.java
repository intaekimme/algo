import java.util.LinkedList;
import java.util.Queue;

public class QueueMyChewTest {

	public static void main(String[] args) {
		int N = 20;		//	마이쮸 개수
		int person = 1;	//	대기열에 새롭게	등장하는 사람의 번호
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {person, 1});
		
		while(N>0) {
			int [] p = queue.poll();
			int availableCount = (N>=p[1])?p[1]:N;
			N -= availableCount;
			
			if(N==0) {
				System.out.println("마지막 마이쮸를 가져간 사람 : "+p[0]+", 가져간 마이쮸 개수 : "+availableCount);
			}else {
				System.out.println("마지막 마이쮸를 가져간 사람 : "+p[0]+", 가져간 마이쮸 개수 : "+availableCount);
				
				//	받은	사람 넣기,	개수 한개 늘려
				p[1]++;
				queue.offer(p);
				//	새로운 사람 넣기
				queue.offer(new int[] {++person, 1});
			}
		}
	}

}
