import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) 
                return a[0] - b[0];
            return a[1] - b[1];
        });

        int[] p = new int[n];
        for (int i = 0; i < n; i++)
            p[arr[i][1]] = i;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(p[i]);
            if (i < n - 1) sb.append(" ");
        }

        System.out.print(sb.toString());
    }
}
