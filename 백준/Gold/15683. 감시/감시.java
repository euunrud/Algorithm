import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static List<int[]> list;
    static int min;
    static int cnt(int[][] arr) {
        int num = 0;
        for(int i =  0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(arr[i][j] == 0) num++;
                
        return num;
    }
    static void dfs(int idx, int[][] arr) {
        if(idx == list.size()) {
            int num = cnt(arr);
            min = num < min ? num : min;
            return;
        }
        
        int x = list.get(idx)[0];
        int y = list.get(idx)[1];
        //먼저 각 방향마다 바뀌는 곳 리스트에 구해놓자
        List<int[]>[] cctv = new ArrayList[4];
        for(int i = 0; i < 4; i++)
            cctv[i] = new ArrayList<>();
            
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for(int i = 0; i < 4; i++) { 
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            while(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] < 6) {
                if(arr[nx][ny] == 0)
                    cctv[i].add(new int[]{nx, ny});
                nx += dx[i];
                ny += dy[i];
            }
        }
        
        if(arr[x][y] == 1) {
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < cctv[i].size(); j++)
                    arr[cctv[i].get(j)[0]][cctv[i].get(j)[1]] = -1;
                dfs(idx + 1, arr);
                
                for(int j = 0; j < cctv[i].size(); j++)
                    arr[cctv[i].get(j)[0]][cctv[i].get(j)[1]] = 0;
            }
        } else if(arr[x][y] == 2) {
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < cctv[i].size(); j++)
                    arr[cctv[i].get(j)[0]][cctv[i].get(j)[1]] = -1;
                for(int j = 0; j < cctv[i + 2].size(); j++)
                    arr[cctv[i + 2].get(j)[0]][cctv[i + 2].get(j)[1]] = -1;
                dfs(idx + 1, arr);
                
                for(int j = 0; j < cctv[i].size(); j++)
                    arr[cctv[i].get(j)[0]][cctv[i].get(j)[1]] = 0;
                for(int j = 0; j < cctv[i + 2].size(); j++)
                    arr[cctv[i + 2].get(j)[0]][cctv[i + 2].get(j)[1]] = 0;
            }
        } else if(arr[x][y] == 3) {
            for(int i = 0; i < 4; i++) {
                int k = (i + 1) % 4;
                for(int j = 0; j < cctv[i].size(); j++)
                    arr[cctv[i].get(j)[0]][cctv[i].get(j)[1]] = -1;
                for(int j = 0; j < cctv[k].size(); j++)
                    arr[cctv[k].get(j)[0]][cctv[k].get(j)[1]] = -1;
                dfs(idx + 1, arr);
                
                for(int j = 0; j < cctv[i].size(); j++)
                    arr[cctv[i].get(j)[0]][cctv[i].get(j)[1]] = 0;
                for(int j = 0; j < cctv[k].size(); j++)
                    arr[cctv[k].get(j)[0]][cctv[k].get(j)[1]] = 0;
            }
        } else if(arr[x][y] == 4) {
            for(int i = 0; i < 4; i++) {
                int n1 = (i + 1) % 4;
                int n2 = (i + 2) % 4;
                for(int j = 0; j < cctv[i].size(); j++)
                    arr[cctv[i].get(j)[0]][cctv[i].get(j)[1]] = -1;
                for(int j = 0; j < cctv[n1].size(); j++)
                    arr[cctv[n1].get(j)[0]][cctv[n1].get(j)[1]] = -1;
                for(int j = 0; j < cctv[n2].size(); j++)
                    arr[cctv[n2].get(j)[0]][cctv[n2].get(j)[1]] = -1;
                    
                dfs(idx + 1, arr);
                
                for(int j = 0; j < cctv[i].size(); j++)
                    arr[cctv[i].get(j)[0]][cctv[i].get(j)[1]] = 0;
                for(int j = 0; j < cctv[n1].size(); j++)
                    arr[cctv[n1].get(j)[0]][cctv[n1].get(j)[1]] = 0;
                for(int j = 0; j < cctv[n2].size(); j++)
                    arr[cctv[n2].get(j)[0]][cctv[n2].get(j)[1]] = 0;
            }
        } else if(arr[x][y] == 5) {
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < cctv[i].size(); j++)
                    arr[cctv[i].get(j)[0]][cctv[i].get(j)[1]] = -1;
            }
            dfs(idx + 1, arr);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        list = new ArrayList<>();
        min = n * m;
        
        for(int i =  0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] % 6 != 0)
                    list.add(new int[]{i, j});
            }
        }
        
        dfs(0, arr);
        System.out.print(min);
        
    }
}