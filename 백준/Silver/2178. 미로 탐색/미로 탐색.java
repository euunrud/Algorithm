import java.util.*;

public class Main {
    static int m ;
    static int n;
    static int[][] nums;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    int sum = 0;

    public static int bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<int[]>();
        int result = 0;
        queue.offer(new int[]{0, 0, 1});

        visited[0][0] = true;
        int[] q;
        while (!queue.isEmpty()) {
            q = queue.poll();
            for (int k = 0; k < 4; k++) {
                int n1 = q[0] + dx[k];
                int n2 = q[1] + dy[k];

                if (n1 >= m || n1 < 0 || n2 >= n || n2 < 0) {
                    continue;
                }
                if (visited[n1][n2] == true) {
                    continue;
                }
                if (nums[n1][n2] == 0) {
                    continue;
                }
                queue.offer(new int[]{n1, n2, q[2] + 1});
                if (n1 == m - 1 && n2 == n - 1) {
                    result = q[2] + 1;
                }
                visited[n1][n2] = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        nums = new int[m][n];

        for (int i = 0; i < m; i++) {
             String str = sc.next();
             for(int j = 0; j < n; j++) {
                 nums[i][j] = str.charAt(j) - '0';
             }
        }
        visited = new boolean[m][n];
        int rslt = bfs(0, 0);
        System.out.println(rslt);
    }
}