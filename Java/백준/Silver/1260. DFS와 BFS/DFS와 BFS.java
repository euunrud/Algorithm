import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // DFS와 BFS
	static int n, m;
	static ArrayList<Integer>[] list;
	static boolean[] vst;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[n + 1];
        vst = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
        	list[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int n1 = Integer.parseInt(st.nextToken());
        	int n2 = Integer.parseInt(st.nextToken());
        	
        	list[n1].add(n2);
        	list[n2].add(n1);
        }
        
        for(int i = 1; i <= n; i++) {
        	Collections.sort(list[i]);
        }
        DFS(v, 1);
        System.out.println();
        vst = new boolean[n + 1];
        BFS(v);
        
        return;
	}
	
	static void DFS(int num, int cnt) {
		if(vst[num] == true) {
			return;
		}
		System.out.print(num + " ");
		vst[num] = true;
		for(int i = 0; i < list[num].size(); i++) {
			if(vst[list[num].get(i)] == false) {
				DFS(list[num].get(i), cnt + 1);
			}
		}
		return;
	}
	

	static void BFS(int num) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(num);
		vst[num] = true;
		
		while(!que.isEmpty()) {
			int node = que.poll();
			System.out.print(node + " ");
			for(int i : list[node]) {
				if(vst[i] == false) {
					que.add(i);
					vst[i] = true;
				}
			}
		}
		return;
	}
}
