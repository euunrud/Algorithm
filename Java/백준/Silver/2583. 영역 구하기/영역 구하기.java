import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int n, m;
	static int[] list;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1= Integer.parseInt(st.nextToken());
			int y1= Integer.parseInt(st.nextToken());
			int x2= Integer.parseInt(st.nextToken());
			int y2= Integer.parseInt(st.nextToken());
			
			for(int j = x1; j < x2; j++) {
				for(int l = y1; l < y2; l++) {
					//System.out.println("x- " + j + ", y- " + l);
					arr[l][j] = 1;
				}
			}
		}
		
//		for(int i = 0; i < m; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int num = 0;
		list = new int[n*m/2];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 0) {
					//System.out.println("****i - " + i + " j - " + j + " cnt - " + cnt);
					cnt = DFS(i, j);
					list[num++] = cnt;
					cnt = 0;
				}
			}
		}
		
		System.out.println(num);
		Arrays.sort(list);
		int id = 0;
		for(int i = 0; i < list.length; i++) {
			if(list[i] != 0) {
				System.out.print(list[i] + " ");
			}
		}
		
	}
	
	static int DFS(int i, int j) {
		arr[i][j] = 1;
		cnt++;
		//System.out.println("i - " + i + " j - " + j + " cnt - " + cnt);
		if(i + 1 < arr.length && arr[i + 1][j] == 0) {
			DFS(i + 1, j);
		}
		if(i - 1 >= 0 && arr[i - 1][j] == 0) {
			DFS(i - 1, j);
		}
		if(j + 1 < arr[0].length && arr[i][j + 1] == 0) {
			DFS(i, j + 1);
		}
		if(j - 1 >= 0 && arr[i][j - 1] == 0) {
			DFS(i, j - 1);
		}
		
		return cnt;
	}
}