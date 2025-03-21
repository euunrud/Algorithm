import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] list;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) {
        	list[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	list[s].add(e);
        	list[e].add(s);
        }
        v = new boolean[n + 1];
        int cnt = 0;
        
        for(int i = 1; i < n + 1; i++) {
        	if(!v[i]) {
        		cnt++; // 한번 호출되면 연결된 노드들이 모두 호출되어서 호출된 개수가 곧 연결요소 개수
        		DFS(i);
        	}
        }
        
        System.out.print(cnt);
        
	}
	
	//재귀함수
	static void DFS(int idx) {
		if(v[idx] == true) {
			return;
		}
		v[idx] = true;
		for(int i : list[idx]) { //향상된 for문 사용.
			if(v[i] == false) {
				DFS(i);
			}
		}
	}
}