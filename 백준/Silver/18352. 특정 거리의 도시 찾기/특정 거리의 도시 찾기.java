import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) 
            g[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(x);
        dist[x] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (dist[cur] == k) continue;

            for (int nxt : g[cur]) {
                if (dist[nxt] != -1) continue;
                dist[nxt] = dist[cur] + 1;
                q.offer(nxt);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            if (dist[i] == k) 
                sb.append(i).append('\n');
        

        if (sb.length() == 0) 
            System.out.print(-1);
        else 
            System.out.print(sb.toString());
    }
}
