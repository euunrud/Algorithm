import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static boolean[] vst;
	static int m;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n + 1];
        vst = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
        	arr[i] = i;
        }
        
        int[] rslt = new int[m + 1];
        for(int i = 1; i <= n; i++) {
        	DFS(i, 1, rslt);
        }
	}
	
	static void DFS(int num, int k, int[] r) {
		r[k - 1] = num; 
		if(k == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(r[i] +" ");
			}
			System.out.println();
			return;
		}
		if(k > m || vst[num] == true) {
			return;
		}
		vst[num] = true;
		for(int i = num + 1; i < arr.length; i++) {
			DFS(i, k + 1, r);
		}
		vst[num] = false;
	}
}