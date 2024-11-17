import java.util.*;
class Main {
    static boolean[][] visited;
    static int size;
    static int cnt;
    static int[] cnts;
    static int[][] nums;
    public static int bfs(int n, int m, int t) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {n, m});
        visited[n][m] = true;
        int sum = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        //System.out.println(n + " *** " + m);
        while(!queue.isEmpty()) {
            int[] num = queue.poll();
            for (int i = 0; i < 4; i++) {
                int n1 = num[0] + dx[i];
                int m1 = num[1] + dy[i];

                if (n1 >= t || m1 >= t || n1 < 0 || m1 < 0) {
                    continue;
                }
                if (visited[n1][m1] == true) {
                    continue;
                }
                if(nums[n1][m1] == 0) {
                    continue;
                }
                //System.out.println("n1" + n1 + " m1 " + m1 + " sum - " + sum);
                queue.offer(new int[] {n1, m1});
                visited[n1][m1] = true;
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        nums = new int[t][t];
        cnt = 0;
        cnts = new int[t * t];
        //System.out.println(cnts.length);
        visited = new boolean[t][t];
        for(int i = 0; i < t; i++) {
            String str = sc.next();
            for(int j = 0; j < t; j++) {
                nums[i][j] = str.charAt(j) - '0';
                visited[i][j] = false;
            }
        }
        for(int i = 0; i<t; i++) {
            for(int j = 0; j < t; j++) {
                //System.out.println("i - " + i + " j - " + j + "n - " + nums[i][j] + "v * " + visited[i][j] );
                if(visited[i][j] == false && nums[i][j] == 1) {
                    int num = bfs(i, j, t);
                    cnts[cnt] =num;
                    //System.out.println("cnt" + cnt +" num " + num);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        Arrays.sort(cnts);
        int a = t*t;
        for(int i = a - cnt; i < a; i++) {
            System.out.println(cnts[i]);
        }
    }
}