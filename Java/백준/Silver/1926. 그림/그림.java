import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int num;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        arr = new int[m][n];
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int max = 0;
        int cnt = 0;
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(arr[i][j] == 1) {
        			num = 0;
        			DFS(i, j, 1);
        			cnt++;
        		}
        		if(num > max) {
        			max = num;
        		}
        	}
        }
        
        System.out.println(cnt + "\n" + max);
	}
	
	static void DFS(int i, int j, int k) {
		if(arr[i][j] == 0) {
			return;
		}
		arr[i][j] = 0;
		num++;
		if(i + 1 < arr.length) {
			DFS(i + 1, j, k++);
		}
		if(i - 1 >= 0) {
			DFS(i - 1, j, k++);
		}
		if(j + 1 < arr[0].length) {
			DFS(i, j + 1, k++);
		}
		if(j - 1 >= 0) {
			DFS(i, j - 1, k++);
		}
		return;
	}
}