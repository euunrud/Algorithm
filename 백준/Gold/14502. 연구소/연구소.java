import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static List<int[]> list;
    static int x, y;
    static int max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void dfs(int cnt, int next){
        if(cnt == 3) {
            int[][] arr2 = new int[x][y];
            for(int i = 0; i < x; i++)
                arr2[i] = arr[i].clone();
            for(int i = 0; i < list.size(); i++) {
                Queue<int[]> que = new ArrayDeque<>();
                que.offer(list.get(i));
                while(!que.isEmpty()){
                    int[] sp = que.poll();
                    for(int j = 0; j < 4; j++){
                        int nx = sp[0] + dx[j];
                        int ny = sp[1] + dy[j];
                        if(nx >= 0 && nx < x && ny >= 0 && ny < y && arr2[nx][ny] == 0){
                            que.offer(new int[]{nx, ny});
                            arr2[nx][ny] = 2;
                        }
                    }
                }
            }
            int num = 0;
            for(int i = 0; i < x; i++)
                for(int j = 0; j < y; j++)
                    if(arr2[i][j] == 0)
                        num++;
            
            if(num > max)
                max = num;
            return;
        }
        
        int a = next / y;
        int b = next % y;
        for(int i = a; i < x; i++)
            for(int j = (i == a ? b : 0); j < y; j++)
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    dfs(cnt + 1, i * y + j + 1);
                    arr[i][j] = 0;
                }
                
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        arr = new int[x][y];
        list = new ArrayList<>();
        for(int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < y; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2)
                    list.add(new int[]{i, j});
            }
        }
        
        dfs(0, 0);
        System.out.println(max);
    }
}