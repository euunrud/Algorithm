import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int[][] arr;
	static boolean[][] vs;
	static int n;
	static int m;
	static int rslt;
	static void BFS() {
		Queue<int[]> que =new LinkedList<>();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1}; //아래, 위, 왼, 오
		que.offer(new int[]{1, 1, 1});
		vs[1][1] = true;
		while(!que.isEmpty()) {
			int[] q = que.poll();
			if(q[0] == n &&  q[1] == m) {
				rslt = q[2];
				break;
			}
			for(int i = 0; i < 4; i++) {
				int x = q[0] + dx[i];
				int y = q[1] + dy[i];
				if(x > n || y > m) {
					continue;
				}
				if(vs[x][y] == false && arr[x][y] == 1) {
					que.offer(new int[] {x, y, q[2] +1});
					vs[x][y] = true;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        arr = new int[n + 1][m + 1];
        vs = new boolean[n + 1][m + 1];
        
        for(int i = 1; i <= n; i++) {
        	String s = br.readLine();
        	for(int j = 1; j <= m; j++) {
            	arr[i][j] = s.charAt(j - 1) - '0';
        	}
        }
        
        BFS();
        System.out.println(rslt);
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.offer(null);
	}
}
