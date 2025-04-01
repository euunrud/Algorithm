import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
	static boolean[][] vst;
	static int num;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        vst = new boolean[n][m];
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }

        int rslt = -1;
        int cnt = 0;
        while(true) {
        	cnt = 0;
        	vst = new boolean[n][m];
	        for(int i = 0; i < n; i++) {
	        	for(int j = 0; j < m; j++) {
	        		if(arr[i][j] > 0 && vst[i][j] == false) {
	        			//System.out.println("i " + i + " j " + j + " " + arr[i][j]);
	        			DFS(i, j);
	        			cnt++;
	        		}
	        	}//System.out.println(arr[1][3] +", " + arr[1][2] + ", "+arr[3][3]);
	        }
        	rslt++;
        	//System.out.println(rslt + " Rr " + cnt);
	        if(cnt == 0) {
	        	rslt = 0;
	        	break;
	        }
	        if(cnt > 1) {
	        	break;
	        }
        }        
        System.out.println(rslt);
	}
	
	static void DFS(int i, int j) {
		if(arr[i][j] <= 0 || vst[i][j] == true) {
			return;
		}
		vst[i][j] = true;
		
		int cnt = 0;
		if(i + 1 < arr.length && arr[i + 1][j] < 1) {
			cnt++;
		}
		if(i - 1 >= 0 && arr[i - 1][j] < 1) {
			cnt++;
		}
		if(j + 1 < arr[0].length && arr[i][j + 1] < 1) {
			cnt++;
		}
		if(j - 1 >= 0 && arr[i][j - 1] < 1) {
			cnt++;
		}
		
		if(i + 1 < arr.length) {
			DFS(i + 1, j);
		}
		if(i - 1 >= 0) {
			DFS(i - 1, j);
		}
		if(j + 1 < arr[0].length) {
			DFS(i, j + 1);
		}
		if(j - 1 >= 0) {
			DFS(i, j - 1);
		}

		arr[i][j] -= cnt;
		return;
	}	
}