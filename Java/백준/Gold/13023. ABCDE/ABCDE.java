import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean[] v;
	static boolean a = false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		v = new boolean[n];
		a = false;
		A = new ArrayList[n];
		for(int i = 0; i < n; i++) { 
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) { 
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}

		for(int i = 0; i < n; i++) {
			if(!v[i]) {
				DFS(i, 1);
				if(a == true) {
					break;
				}
			}
		}
		if(a == true) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}
	
	static void DFS(int idx, int depth) {
		if(depth == 5) {
			//System.out.println(a + "---");
			a = true;
			return;
		}
		//System.out.println(depth + "--- " + idx);
		
		v[idx] = true;
		for(int i : A[idx]) {
			if(v[i] == false) {
				DFS(i, depth + 1);
			}
		}
		v[idx] = false; //이 한줄 왜 추가하는지 확실히 알기. 
	}
}