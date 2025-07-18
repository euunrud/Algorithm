import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] list;
	static boolean[] vst;
	static int n, m;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
        	list[i] = new ArrayList<Integer>();
        }

        StringTokenizer st;
        for(int i = 0; i< m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	list[a].add(b); 
        	list[b].add(a); //양방향 
        }
        
        vst = new boolean[n + 1];
        int cnt = bfs(0);
        System.out.println(cnt);
	}
	
	static int bfs(int cnt) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		vst[1] = true;
		//System.out.println("--"+ list[1].get(0));
		while(!q.isEmpty()) {
			int num = q.poll();
			cnt++;
			//System.out.println("num " + num + " c " + cnt);
			for(int i = 0; i < list[num].size(); i++) {
				//System.out.println("num" + num + ", " + list[num].get(i));
				if(vst[list[num].get(i)] == false) {
					q.add(list[num].get(i));
					vst[list[num].get(i)] = true;
				}
			}
		}
		
		return cnt - 1;
	}
}