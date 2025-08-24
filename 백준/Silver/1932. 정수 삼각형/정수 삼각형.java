import java.io.*;
import java.util.*;

class Main {
    static int num;
    static int[][] arr;
    static int[][] sum; 
    static int max = 0;
    public static int dp(int i, int j) {
        if(i == num - 1) {
            return arr[i][j];
        }
        if (sum[i][j] != 0) return sum[i][j];
        
        sum[i][j] = arr[i][j] + Math.max(dp(i + 1, j), dp(i + 1, j + 1));
        
        return sum[i][j];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        arr = new int[num][num];
        sum = new int[num][num];
        
        for(int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int max = dp(0, 0);
        System.out.println(max);
    }
}