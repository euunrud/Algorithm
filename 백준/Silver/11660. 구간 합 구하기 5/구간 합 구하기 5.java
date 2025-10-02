import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long[][] nums = new long[n + 1][n + 1];
        long[] rslt = new long[c];
       
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                nums[i][j] = Long.parseLong(st.nextToken())
                            + nums[i - 1][j] + nums[i][j - 1] - nums[i - 1][j - 1];
            }
        }
       
        for (int i = 1; i <= c; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
           
            rslt[i - 1] = nums[x2][y2] - nums[x1 - 1][y2] - nums[x2][y1 - 1] + nums[x1 - 1][y1 - 1];
        }
       
        for (int i = 0; i < c; i++)
            System.out.println(rslt[i]);
    }
}
