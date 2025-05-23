
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int[][] arr;
	static boolean[][] vs;
	static int len = 0;
	static boolean f;
	
	static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		que.offer(new int[] {1,1,1});
		vs[1][1] = true;
		while(!que.isEmpty()) {
			int[] q = que.poll();
			for(int i = 0; i < 4; i++) {
				int x = q[0] + dx[i];
				int y = q[1] + dy[i];

				if(x >= 100 || y >= 100 || x < 0 || y < 0) {
					continue;
				}
				if(arr[x][y] == 3) {
					f = true;
					len = q[2] + 1;
					break;
				}
				if(vs[x][y] == false && arr[x][y] == 0) {
					que.offer(new int[] {x, y, len + 1});
					vs[x][y] = true;
				}
			}
			if(f) {
				break;
			}
		}
		
	
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 0; tc < 10; tc++) {
			arr= new int[100][100];
			vs = new boolean[100][100];
			f = false;
			int num = Integer.parseInt(br.readLine());
			for(int i = 0; i < 100; i++) {
				String s = br.readLine();
				for(int j = 0; j < 100; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			}
			bfs();
			System.out.print("#"+ (tc + 1) + " ");
			System.out.println(f == true ? 1 : 0);
		}
		
		//System.out.println(len);
	}
}
