import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) 
            a[i] = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(br.readLine());
        Arrays.sort(a);
        int l = 0, r = n - 1;
        int cnt = 0;

        while (l < r) {
            int sum = a[l] + a[r];
            if (sum == x) {
                cnt++;
                l++;
                r--;
            } else if (sum < x)
                l++;
            else
                r--;
        }

        System.out.print(cnt);
    }
}
