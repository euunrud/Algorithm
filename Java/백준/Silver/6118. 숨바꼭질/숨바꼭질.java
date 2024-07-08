import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static int minNode, distResult, cntNode;
    static List<Integer>[] node;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        node = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        
        for (int i = 1; i <= N; i++) {
            node[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            node[from].add(to);
            node[to].add(from);
        }

        solve();

        bw.write(minNode + " " + distResult + " " + cntNode);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void solve() {
        Queue<int[]> q = new LinkedList<>();
        visit[1] = true;
        q.offer(new int[]{1, 0});
        
        while (!q.isEmpty()) {
            int[] a = q.poll();
            int now = a[0];
            int dist = a[1];
            
            if (dist > distResult) {
                distResult = dist;
                minNode = now;
                cntNode = 1;
            } else if (dist == distResult) {
                if (minNode > now) {
                    minNode = now;
                }
                cntNode++;
            }
            
            for (int next : node[now]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.offer(new int[]{next, dist + 1});
                }
            }
        }
    }
}
