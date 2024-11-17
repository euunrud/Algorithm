import java.util.*;
class Main {
    static boolean[] visited;
    static int size;
    public static int bfs(int n, int m) {
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(n);
        visited[n] = true;
        int cnt = 0;
        int[] cnts = new int[size * 2 + 2];
        cnts[n] = 0;
        while(!que.isEmpty()) {
            int num = que.poll();
            //System.out.println("num : " + num);
            for(int i = 0; i < 3; i++) {
                int p = num;
                if( i == 0)  {
                    p += 1;
                }else if (i == 1) {
                    p -= 1;
                    if(p < 0) {
                        continue;
                    }
                }else if(i == 2) {
                    p *= 2;
                }

                if(p > size + 2 || p < 0) {
                    continue;
                }
                //System.out.println("p " + p);
                if(visited[p] == true) {
                    continue;
                }
                que.offer(p);
                visited[p] = true;
                cnts[p] = cnts[num] + 1;
                if(p == m) {
                    break;
                }
            }
            if(cnts[m] != 0) {
                return cnts[m];
            }
        }

        return cnts[m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        size = m > n ? m : n;
        visited = new boolean[size * 2 + 2];
        int result;
        if(n == m){
            result = 0;
        } else {
            result = bfs(n, m);
        }
        System.out.println(result);
    }
}