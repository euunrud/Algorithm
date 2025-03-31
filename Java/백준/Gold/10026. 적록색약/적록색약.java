
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static char[][] arr;
	static char[][] arr2;
	static boolean[][] vst;
	static char c;
	static int n;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        arr2 = new char[n][n];
        vst = new boolean[n][n];
        
        for(int i = 0; i< n; i++) {
            String s = br.readLine();
        	for(int j = 0; j < n; j++) {
        		char c = s.charAt(j);
        		arr[i][j] = c;
        		if(c == 'G') {
        			arr2[i][j] = 'R';
        		}else {
        			arr2[i][j] = c;
        		}
        	}
        }
        
        int cnt = 0;
        for(int i = 0; i< n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(vst[i][j] != true) {
        			DFS(arr[i][j], i, j);
        			cnt++;
        		}
        	}
        }
        
        vst = new boolean[n][n];
        arr = arr2;
        int cnt2 = 0;
        for(int i = 0; i< n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(vst[i][j] != true) {
        			DFS(arr[i][j], i, j);
        			cnt2++;
        		}
        	}
        }
        
        System.out.println(cnt + " " + cnt2);
	}
	
	static void DFS(char c, int i, int j) {
		if(vst[i][j] == true) {
			return;
		}
		vst[i][j] = true;
		if(i > 0 && c == arr[i - 1][j]) {
			DFS(arr[i - 1][j], i - 1, j);
		}
		if(i < n - 1 && c == arr[i + 1][j]) {
			DFS(arr[i + 1][j], i + 1, j);
		}
		if(j > 0 && c == arr[i][j - 1]) {
			DFS(arr[i][j - 1], i, j - 1);
		}
		if(j < n - 1 && c == arr[i][j + 1]) {
			DFS(arr[i][j + 1], i, j + 1);
		}
		return;
	}
}
