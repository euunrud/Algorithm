import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] arr;
    static List<int[]> teachers = new ArrayList<>();
    static boolean answer = false;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int idx, int cnt) {
        if (answer) return;
        if (cnt == 3) {
            if (check())
                answer = true;
            return;
        }

        for (int i = idx; i < n * n; i++) {
            int x = i / n;
            int y = i % n;

            if (arr[x][y] == 'X') {
                arr[x][y] = 'O';
                dfs(i + 1, cnt + 1);
                arr[x][y] = 'X';
            }
        }
    }

    static boolean check() {
        for (int[] t : teachers) {
            int x = t[0];
            int y = t[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = x;
                int ny = y;
                while (true) {
                    nx += dx[d];
                    ny += dy[d];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                        break;
                    if (arr[nx][ny] == 'O')
                        break;
                    if (arr[nx][ny] == 'S')
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = st.nextToken().charAt(0);
                if (arr[i][j] == 'T')
                    teachers.add(new int[]{i, j});
            }
        }

        dfs(0, 0);
        System.out.println(answer ? "YES" : "NO");
    }
}
